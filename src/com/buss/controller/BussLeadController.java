package com.buss.controller;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.io.http.Http;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExcelTitle;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.buss.entity.BussAccountEntity;
import com.buss.entity.BussActivityEntity;
import com.buss.entity.BussLeadEntity;
import com.buss.page.BussLeadPage;
import com.buss.service.BussLeadServiceI;
import com.shared.entity.BussAccountSharedEntity;
import com.shared.entity.BussLeadSharedEntity;
/**   
 * @Title: Controller
 * @Description: 销售线索
 * @author caoliang
 * @date 2015-02-11 22:38:42
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/bussLeadController")
public class BussLeadController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BussLeadController.class);

	@Autowired
	private BussLeadServiceI bussLeadService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 线索列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussLead")
	public ModelAndView bussLead(HttpServletRequest request) {
		return new ModelAndView("com/lead/bussLeadList");
	}


	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(BussLeadEntity bussLead,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BussLeadEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bussLead);
		try{
		//自定义追加查询条件
			
			TSUser user = (TSUser)request.getSession().getAttribute("USER");			
			//查询关联表中属于自己资源的id
			String hql = "from BussLeadSharedEntity shared where shared.userId = ?";
			List<BussLeadSharedEntity> list = systemService.findHql(hql , user.getId());			
			String ids[] =new String[list.size()]; 
			for(int i=0 ; i<list.size();i++){
				BussLeadSharedEntity shared  = list.get(i);
 				ids[i] = shared.getSalesId();
			}
			//避免抛出异常
			if(ids.length==0)ids= new String[]{"0"};
 			//符合条件的客户id数组
			cq.in("id", ids);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		//过滤删除数据
		cq.eq("delStatus", 1);
		cq.add();
		this.bussLeadService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除线索(不做物理删除,只做逻辑删除)
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BussLeadEntity bussLead, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bussLead = systemService.getEntity(BussLeadEntity.class, bussLead.getId());
		message = "线索删除成功";
		try{
//			bussLeadService.delMain(bussLead);
			bussLeadService.updateBySqlString(" update buss_lead set del_status = 0 where id = '"+bussLead.getId()+"'");
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			
		}catch(Exception e){
			e.printStackTrace();
			message = "线索删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除线索(不做物理删除,只做逻辑删除)
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String[] array = ids.split(",");
		
		message = "线索删除成功";
		try{
			for(String id:ids.split(",")){
//				BussLeadEntity bussLead = systemService.getEntity(BussLeadEntity.class,id);
//				bussLeadService.delMain(bussLead);
				bussLeadService.updateBySqlString(" update buss_lead set del_status = 0 where id = '"+id+"'");

				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
				
			}
 		}catch(Exception e){
			e.printStackTrace();
			message = "线索删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加线索
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BussLeadEntity bussLead,BussLeadPage bussLeadPage, HttpServletRequest request) {
		List<BussActivityEntity> bussActivityList =  bussLeadPage.getBussActivityList();
		AjaxJson j = new AjaxJson();
		TSUser user = (TSUser)request.getSession().getAttribute("USER");

		message = "添加成功";
		try{
			//1添加基础业务表
			bussLeadService.addMain(bussLead, bussActivityList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			
			//2添加到线索资源关联表-buss_leadShared
			BussLeadSharedEntity shared = null;
			//获取上级部门id结果集,通过部门id,找到用户
			List<String> praDepIds =  systemService.getParentDepId(user.getTSDepart().getId());
			for(String praDepId : praDepIds){
				List<Map<String, Object>> list = systemService.findForJdbc("select id from  t_s_base_user where departid = ?", praDepId);
				for(Map<String, Object> map : list){
					shared = new BussLeadSharedEntity();
					shared.setCreateUserId(user.getId());
					shared.setSalesId(bussLead.getId());
					shared.setUserId(map.get("id").toString());
					systemService.save(shared);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);					
				}				
			}
			shared = new BussLeadSharedEntity();
			shared.setUserId(user.getId());
			shared.setSalesId(bussLead.getId());
			shared.setCreateUserId(user.getId());			
			systemService.save(shared);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "线索添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新线索
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BussLeadEntity bussLead,BussLeadPage bussLeadPage, HttpServletRequest request) {
		List<BussActivityEntity> bussActivityList =  bussLeadPage.getBussActivityList();
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		try{
			bussLeadService.updateMain(bussLead, bussActivityList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新线索失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 线索新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BussLeadEntity bussLead, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussLead.getId())) {
			bussLead = bussLeadService.getEntity(BussLeadEntity.class, bussLead.getId());
			req.setAttribute("bussLeadPage", bussLead);
		}
		return new ModelAndView("com/lead/bussLead-add");
	}
	
	/**
	 * 线索编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BussLeadEntity bussLead, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussLead.getId())) {
			bussLead = bussLeadService.getEntity(BussLeadEntity.class, bussLead.getId());
			req.setAttribute("bussLeadPage", bussLead);
		}
		return new ModelAndView("com/lead/bussLead-update");
	}
	
	
	/**
	 * 加载明细列表[活动跟进]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussActivityList")
	public ModelAndView bussActivityList(BussLeadEntity bussLead, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = bussLead.getId();
		//===================================================================================
		//查询-活动跟进
	    String hql0 = "from BussActivityEntity o where 1 = 1 AND  o.leadid = ? ";
	    try{
	    	List<BussActivityEntity> bussActivityEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("bussActivityList", bussActivityEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/lead/bussActivityList");
	}	
	
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("com/lead/bussLeadUpload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(BussLeadEntity bussLead,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "客户资源管理";
			// 根据浏览器进行转码，使其支持中文文件名
			if (BrowserUtils.isIE(request)) {
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ java.net.URLEncoder.encode(codedFileName,
										"UTF-8") + ".xls");
			} else {
				String newtitle = new String(codedFileName.getBytes("UTF-8"),
						"ISO8859-1");
				response.setHeader("content-disposition",
						"attachment;filename=" + newtitle + ".xls");
			}
			// 产生工作簿对象
			HSSFWorkbook workbook = null;
			CriteriaQuery cq = new CriteriaQuery(BussLeadEntity.class, dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bussLead, request.getParameterMap());
			
			List<BussLeadEntity> bussLeads = this.bussLeadService.getListByCriteriaQuery(cq,false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("客户资源管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
					"导出信息"), BussLeadEntity.class, bussLeads);
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception e) {
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {

			}
		}
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public void exportXlsByT(BussLeadEntity bussLead,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "客户资源管理";
			// 根据浏览器进行转码，使其支持中文文件名
			if (BrowserUtils.isIE(request)) {
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ java.net.URLEncoder.encode(codedFileName,
										"UTF-8") + ".xls");
			} else {
				String newtitle = new String(codedFileName.getBytes("UTF-8"),
						"ISO8859-1");
				response.setHeader("content-disposition",
						"attachment;filename=" + newtitle + ".xls");
			}
			// 产生工作簿对象
			HSSFWorkbook workbook = null;
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("线索资源管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
					"导出信息"), BussLeadEntity.class, null);
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception e) {
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {

			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setSecondTitleRows(2);
			params.setNeedSave(true);
			try {
				List<BussLeadEntity> listBussLeadEntitys = 
					(List<BussLeadEntity>)ExcelImportUtil.importExcelByIs(file.getInputStream(),BussLeadEntity.class,params);
				for (BussLeadEntity bussLead : listBussLeadEntitys) {
					bussLeadService.save(bussLead);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	
	/**
	 * 线索共享页面跳转
	 * @return
	 */
	@RequestMapping(params = "leadShared")
	public ModelAndView leadShared(HttpServletRequest request){
		request.setAttribute("leadIds", request.getParameter("ids"));
		return new ModelAndView("com/lead/leadShared");
	}
	
	/**
	 * 资源共享
	 * 避免数据重复,先删除(相同线索、相同分享者、相同创建者)数据
	 * @return
	 */
	@RequestMapping(params = "doLeadShared")
	@ResponseBody
	public AjaxJson doLeadShared(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String leadIds = request.getParameter("leadIds"); //分享资源ID
		String userIds = request.getParameter("userids"); //被分享用户ID
		String depId = request.getParameter("depid"); //分享至部门ID
		TSUser user = (TSUser)request.getSession().getAttribute("USER");//分享者
		/*String userId = user.getId();//分享者ID
		String hql = " from BussLeadSharedEntity where  userId = "+userId+"";
		List<BussLeadSharedEntity> list = systemService.findHql(hql, null);*/
		BussLeadSharedEntity obj = null;
		for(String leadId : leadIds.split(",")){
			//如果是共享到部门
			if(depId!=null && !"".equals(depId)){
				List<String> depIds = systemService.getParentDepId(depId);
				depIds.add(depId);//添加当前共享部门
				for(String praDepId : depIds){
					List<Map<String, Object>> list = systemService.findForJdbc("select id from  t_s_base_user where departid = ?", praDepId);
					for(Map<String, Object> map : list){
						obj = new BussLeadSharedEntity();
						obj.setUserId(map.get("id").toString());
						obj.setSalesId(leadId);
						obj.setCreateUserId(user.getId());
						try {
							systemService.save(obj);
							//systemService.addLog("线索"+leadId+"分享成功", Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);

							j.setMsg("分享成功");
							j.setSuccess(true);
						} catch (Exception e) {
							j.setMsg("已重复分享");
						}			
					}				
				}
			}else if(userIds!=null && !"".equals(userIds)){//共享到人员
				for(String userId : userIds.split(",")){
					obj = new BussLeadSharedEntity();
					obj.setUserId(userId);
					obj.setSalesId(leadId);
					obj.setCreateUserId(user.getId());
					try {
						systemService.save(obj);
						//systemService.addLog("线索"+leadId+"分享成功", Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
						
						j.setMsg("分享成功");
						j.setSuccess(true);
					} catch (Exception e) {
						j.setMsg("已重复分享");
					}			
				}				
			}
		}		
		return j;
	}
	
	/**
	 * 线索转化客户
	 * @param id
	 * @param taskId
	 * @return
	 */
	@RequestMapping(params = "leadTranslate")
	@ResponseBody
    public AjaxJson leadTranslate(HttpServletRequest request , String ids) {
		TSUser user = (TSUser)request.getSession().getAttribute("USER");
    	AjaxJson j = new AjaxJson();
    	String msg = "";
    	int i = 0;
    	try {
    		BussAccountEntity account = null;
    		BussAccountSharedEntity shared = null;
    		for(String id : ids.split(",")){
    			BussLeadEntity lead = bussLeadService.get(BussLeadEntity.class, id);
    			if("1".equals(lead.getLeadstatus())){
    				systemService.updateBySqlString(" update buss_lead set leadstatus = 2 where id = '"+id+"'");
    				/***更新到客户基础表中****/
    				account = new BussAccountEntity();
    				account.setRemark(lead.getRemark());
    				account.setCreateDate(new Timestamp(0));
    				account.setName(lead.getName());
    				account.setMobile(lead.getMobile()==null?lead.getPhone():lead.getMobile());
    				account.setLevel(lead.getLevel());
    				account.setCreateName(user.getRealName());
    				account.setCreateDate(new Date());
    				account.setDelStatus(1);
    				systemService.save(account);
    				
    				/****更新客户关联表******/
    				shared = new BussAccountSharedEntity();
					shared.setCreateUserId(user.getId());
					shared.setCustomerId(account.getId());
					shared.setUserId(user.getId());
					systemService.save(shared);
    				i++;
    			}
    		}
    		msg = "成功转化"+"<fond color='red'>"+i+"</fond>个线索";
		} catch (Exception e) {
			msg = "线索转化失败";
			logger.info("线索转化失败");
		}
    	j.setMsg(msg);
        return j;
    }
	/**
	 * 线索分配列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussLeadDistribute")
	public ModelAndView bussLeadDistribute(HttpServletRequest request) {
		return new ModelAndView("com/lead/distribute");
	}
}

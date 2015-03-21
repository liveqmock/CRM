package com.buss.controller;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.buss.entity.BussAccountEntity;
import com.buss.entity.BussActivityEntity;
import com.buss.entity.BussAttachmentEntity;
import com.buss.entity.BussContactEntity;
import com.buss.entity.BussContractEntity;
import com.buss.entity.BussDeliveryEntity;
import com.buss.entity.BussInvoiceEntity;
import com.buss.entity.BussReceiveEntity;
import com.buss.entity.BussServicesheetEntity;
import com.buss.page.BussAccountPage;
import com.buss.service.BussAccountServiceI;
import com.shared.entity.BussAccountSharedEntity;
import com.shared.entity.BussLeadSharedEntity;
/**   
 * @Title: Controller
 * @Description: 客户管理
 * @author caoliang
 * @date 2015-02-11 22:34:14
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/bussAccountController")
public class BussAccountController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BussAccountController.class);

	@Autowired
	private BussAccountServiceI bussAccountService;
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
	 * 客户管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussAccount")
	public ModelAndView bussAccount(HttpServletRequest request) {
		return new ModelAndView("com/buss/bussAccountList");
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
	public void datagrid(BussAccountEntity bussAccount,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BussAccountEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bussAccount);
		try{
		//自定义追加查询条件
			TSUser user = (TSUser)request.getSession().getAttribute("USER");			
			//查询关联表中属于自己资源的客户id
			String hql = "from BussAccountSharedEntity shared where shared.userId = ?";
			List<BussAccountSharedEntity> list = systemService.findHql(hql , user.getId());
			
			String ids[] =new String[list.size()]; 
			for(int i=0 ; i<list.size();i++){
				BussAccountSharedEntity shared  = list.get(i);
 				ids[i] = shared.getCustomerId();
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
		this.bussAccountService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除客户管理  
	 *               ----暂时不做共享资源的删除
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BussAccountEntity bussAccount, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bussAccount = systemService.getEntity(BussAccountEntity.class, bussAccount.getId());
		message = "客户管理删除成功";
		try{
//			bussAccountService.delMain(bussAccount);			
			bussAccountService.updateBySqlString("update buss_account set del_status = 0 where id = '"+bussAccount.getId()+"'");			
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除客户管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
 		message = "客户管理删除成功";
		try{
			for(String id:ids.split(",")){
//				BussAccountEntity bussAccount = systemService.getEntity(BussAccountEntity.class,id);
//				bussAccountService.delMain(bussAccount);
				bussAccountService.updateBySqlString("update buss_account set del_status = 0 where id = '"+id+"'");			
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
 		}catch(Exception e){
			e.printStackTrace();
			message = "客户管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加客户管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BussAccountEntity bussAccount,BussAccountPage bussAccountPage, HttpServletRequest request) {
		List<BussContactEntity> bussContactList =  bussAccountPage.getBussContactList();
		List<BussAttachmentEntity> bussAttachmentList =  bussAccountPage.getBussAttachmentList();
		List<BussContractEntity> bussContractList =  bussAccountPage.getBussContractList();
		List<BussInvoiceEntity> bussInvoiceList =  bussAccountPage.getBussInvoiceList();
		List<BussDeliveryEntity> bussDeliveryList =  bussAccountPage.getBussDeliveryList();
		List<BussReceiveEntity> bussReceiveList =  bussAccountPage.getBussReceiveList();
		List<BussServicesheetEntity> bussServicesheetList =  bussAccountPage.getBussServicesheetList();
		List<BussActivityEntity> bussActivityList =  bussAccountPage.getBussActivityList();
		AjaxJson j = new AjaxJson();
		TSUser user = (TSUser)request.getSession().getAttribute("USER");
		message = "添加成功";
		try{
			//1添加到客户基础表
			bussAccountService.addMain(bussAccount, bussContactList,bussAttachmentList,bussContractList,bussInvoiceList,bussDeliveryList,bussReceiveList,bussServicesheetList,bussActivityList);
			//2添加到客户资源关联表
			BussAccountSharedEntity shared = null;
			List<String> praDepIds =  systemService.getParentDepId(user.getTSDepart().getId());
			for(String praDepId : praDepIds){
				List<Map<String, Object>> list = systemService.findForJdbc("select id from  t_s_base_user where departid = ?", praDepId);
				for(Map<String, Object> map : list){
					shared = new BussAccountSharedEntity();
					shared.setCreateUserId(user.getId());
					shared.setCustomerId(bussAccount.getId());
					shared.setUserId(map.get("id").toString());
					systemService.save(shared);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);					
				}
				
			}
			
			shared = new BussAccountSharedEntity();
			shared.setCreateUserId(user.getId());
			shared.setCustomerId(bussAccount.getId());
			shared.setUserId(user.getId());
			systemService.save(shared);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新客户管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BussAccountEntity bussAccount,BussAccountPage bussAccountPage, HttpServletRequest request) {
		List<BussContactEntity> bussContactList =  bussAccountPage.getBussContactList();
		List<BussAttachmentEntity> bussAttachmentList =  bussAccountPage.getBussAttachmentList();
		List<BussContractEntity> bussContractList =  bussAccountPage.getBussContractList();
		List<BussInvoiceEntity> bussInvoiceList =  bussAccountPage.getBussInvoiceList();
		List<BussDeliveryEntity> bussDeliveryList =  bussAccountPage.getBussDeliveryList();
		List<BussReceiveEntity> bussReceiveList =  bussAccountPage.getBussReceiveList();
		List<BussServicesheetEntity> bussServicesheetList =  bussAccountPage.getBussServicesheetList();
		List<BussActivityEntity> bussActivityList =  bussAccountPage.getBussActivityList();
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		try{
			bussAccountService.updateMain(bussAccount, bussContactList,bussAttachmentList,bussContractList,bussInvoiceList,bussDeliveryList,bussReceiveList,bussServicesheetList,bussActivityList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新客户管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 客户管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BussAccountEntity bussAccount, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussAccount.getId())) {
			bussAccount = bussAccountService.getEntity(BussAccountEntity.class, bussAccount.getId());
			req.setAttribute("bussAccountPage", bussAccount);
		}
		return new ModelAndView("com/buss/bussAccount-add");
	}
	
	/**
	 * 客户管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BussAccountEntity bussAccount, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussAccount.getId())) {
			bussAccount = bussAccountService.getEntity(BussAccountEntity.class, bussAccount.getId());
			req.setAttribute("bussAccountPage", bussAccount);
		}
		return new ModelAndView("com/buss/bussAccount-update");
	}
	
	
	/**
	 * 加载明细列表[联系人]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussContactList")
	public ModelAndView bussContactList(BussAccountEntity bussAccount, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = bussAccount.getId();
		//===================================================================================
		//查询-联系人
	    String hql0 = "from BussContactEntity where 1 = 1 AND aCCOUNTID = ? ";
	    try{
	    	List<BussContactEntity> bussContactEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("bussContactList", bussContactEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/bussContactList");
	}
	/**
	 * 加载明细列表[附件]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussAttachmentList")
	public ModelAndView bussAttachmentList(BussAccountEntity bussAccount, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = bussAccount.getId();
		//===================================================================================
		//查询-附件
	    String hql1 = "from BussAttachmentEntity where 1 = 1 AND aCCOUNTID = ? ";
	    try{
	    	List<BussAttachmentEntity> bussAttachmentEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("bussAttachmentList", bussAttachmentEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/bussAttachmentList");
	}
	/**
	 * 加载明细列表[订单]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussContractList")
	public ModelAndView bussContractList(BussAccountEntity bussAccount, HttpServletRequest req) {	
		//===================================================================================
		//获取参数
		Object id2 = bussAccount.getId();
		//===================================================================================
		//查询-订单
	    String hql2 = "from BussContractEntity o where 1 = 1 AND o.accountid = ? ";
	    try{
	    	List<BussContractEntity> bussContractEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("bussContractList", bussContractEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/bussContractList");
	}
	/**
	 * 加载明细列表[发票]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussInvoiceList")
	public ModelAndView bussInvoiceList(BussAccountEntity bussAccount, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id3 = bussAccount.getId();
		//===================================================================================
		//查询-发票
	    String hql3 = "from BussInvoiceEntity o where 1 = 1 AND  o.accountid = ? ";
	    try{
	    	List<BussInvoiceEntity> bussInvoiceEntityList = systemService.findHql(hql3,id3);
			req.setAttribute("bussInvoiceList", bussInvoiceEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/bussInvoiceList");
	}
	/**
	 * 加载明细列表[发货单]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussDeliveryList")
	public ModelAndView bussDeliveryList(BussAccountEntity bussAccount, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id4 = bussAccount.getId();
		//===================================================================================
		//查询-发货单
	    String hql4 = "from BussDeliveryEntity o where 1 = 1 AND  o.accountid = ? ";
	    try{
	    	List<BussDeliveryEntity> bussDeliveryEntityList = systemService.findHql(hql4,id4);
			req.setAttribute("bussDeliveryList", bussDeliveryEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/bussDeliveryList");
	}
	/**
	 * 加载明细列表[收款]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussReceiveList")
	public ModelAndView bussReceiveList(BussAccountEntity bussAccount, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id5 = bussAccount.getId();
		//===================================================================================
		//查询-收款
	    String hql5 = "from BussReceiveEntity o where 1 = 1  AND o.accountid = ? ";
	    try{
	    	List<BussReceiveEntity> bussReceiveEntityList = systemService.findHql(hql5,id5);
			req.setAttribute("bussReceiveList", bussReceiveEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/bussReceiveList");
	}
	/**
	 * 加载明细列表[服务工单]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussServicesheetList")
	public ModelAndView bussServicesheetList(BussAccountEntity bussAccount, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id6 = bussAccount.getId();
		//===================================================================================
		//查询-服务工单
	    String hql6 = "from BussServicesheetEntity o where 1 = 1 AND o.accountid = ? ";
	    try{
	    	List<BussServicesheetEntity> bussServicesheetEntityList = systemService.findHql(hql6,id6);
			req.setAttribute("bussServicesheetList", bussServicesheetEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/bussServicesheetList");
	}
	/**
	 * 加载明细列表[活动跟进]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussActivityList")
	public ModelAndView bussActivityList(BussAccountEntity bussAccount, HttpServletRequest req) {	
		//===================================================================================
		//获取参数
		Object id7 = bussAccount.getId();
		//===================================================================================
		//查询-活动跟进
	    String hql7 = "from BussActivityEntity o where 1 = 1 AND o.accountid = ? ";
	    try{
	    	List<BussActivityEntity> bussActivityEntityList = systemService.findHql(hql7,id7);
			req.setAttribute("bussActivityList", bussActivityEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/bussActivityList");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("com/buss/bussCustomerUpload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(BussAccountEntity bussCustomer,HttpServletRequest request,HttpServletResponse response
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
			CriteriaQuery cq = new CriteriaQuery(BussAccountEntity.class, dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bussCustomer, request.getParameterMap());
			
			List<BussAccountEntity> bussCustomers = this.bussAccountService.getListByCriteriaQuery(cq,false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("客户资源管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
					"导出信息"), BussAccountEntity.class, bussCustomers);
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
	public void exportXlsByT(BussAccountEntity bussCustomer,HttpServletRequest request,HttpServletResponse response
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
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("客户资源管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
					"导出信息"), BussAccountEntity.class, null);
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
				List<BussAccountEntity> listBussAccountEntitys = 
					(List<BussAccountEntity>)ExcelImportUtil.importExcelByIs(file.getInputStream(),BussAccountEntity.class,params);
				for (BussAccountEntity bussCustomer : listBussAccountEntitys) {
					bussAccountService.save(bussCustomer);
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
	 * 发送短信页面跳转
	 * @return
	 */
	
	
	@RequestMapping(params = "goSendMsg")
	public ModelAndView goSendMsg(HttpServletRequest request) {
		logger.info(request.getParameter("ids"));
		logger.info(request.getParameter("names"));
		request.setAttribute("ids", request.getParameter("ids"));
		request.setAttribute("names", request.getParameter("names"));
		return new ModelAndView("com/buss/sendMsg");
	}
	/**
	 * 发送邮件页面跳转
	 * @return
	 */
	@RequestMapping(params = "goSendMail" )
	public ModelAndView goSendMail(HttpServletRequest request){
//		String ids = request.getParameter("ids");
//		String names = request.getParameter("names");
//		logger.info(ids);
//		logger.info(names);
		return new ModelAndView("com/buss/sendMail");
	}
	
	/**
	 * 发送短信
	 * @return
	 */
	@RequestMapping(params = "doSendMsg")
	@ResponseBody
	public AjaxJson sendMsg(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		j.setMsg("短信发送成功");
		j.setSuccess(true);
		
		return j;
	}
	/**
	 * 发送邮件
	 * @return
	 */
	@RequestMapping(params = "doSendMail")
	@ResponseBody
	public AjaxJson sendMail(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		
		return j;
	}
	/**
	 * 客户共享页面跳转
	 * @return
	 */
	@RequestMapping(params = "accountShared")
	public ModelAndView customeShared(HttpServletRequest request){
		request.setAttribute("customerIds", request.getParameter("ids"));
		return new ModelAndView("com/buss/accountShared");
	}
	
	/**
	 * 资源共享
	 * 避免数据重复,先删除(相同线索、相同分享者、相同创建者)数据
	 * @return
	 */
	@RequestMapping(params = "doAccountShared")
	@ResponseBody
	public AjaxJson doCustomeShared(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String userIds = request.getParameter("userids"); //分享对象用户ID
		String customerIds = request.getParameter("customerIds"); //分享资源对象ID
		String depId = request.getParameter("depId"); //分享至部门ID
		TSUser user = (TSUser)request.getSession().getAttribute("USER");//分享者
		/*String userId = user.getId();//分享者ID
		String hql = " from BussCustomerSharedEntity where  userId = "+userId+"";
		List<BussCustomerSharedEntity> list = systemService.findHql(hql, null);*/
		BussAccountSharedEntity obj = null;
		for(String customerId : customerIds.split(",")){
			//如果是共享到部门
			if(depId!=null && !"".equals(depId)){
				List<String> depIds = systemService.getParentDepId(depId);
				depIds.add(depId);//添加当前共享部门
				for(String praDepId : depIds){
					List<Map<String, Object>> list = systemService.findForJdbc("select id from  t_s_base_user where departid = ?", praDepId);
					for(Map<String, Object> map : list){
						obj = new BussAccountSharedEntity();
						obj.setUserId(map.get("id").toString());
						obj.setCustomerId(customerId);
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
					obj = new BussAccountSharedEntity();
					obj.setUserId(userId);
					obj.setCustomerId(customerId);
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
	
	
}

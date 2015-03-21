package com.buss.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buss.entity.BussDeliveryitemEntity;
import com.buss.entity.BussInvoiceEntity;
import com.buss.page.BussInvoicePage;
import com.buss.service.BussInvoiceServiceI;
import com.shared.entity.BussInvoiceSharedEntity;
/**   
 * @Title: Controller
 * @Description: 发票
 * @author caoliang
 * @date 2015-02-20 20:46:15
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/bussInvoiceController")
public class BussInvoiceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BussInvoiceController.class);

	@Autowired
	private BussInvoiceServiceI bussInvoiceService;
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
	 * 发票列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussInvoice")
	public ModelAndView bussInvoice(HttpServletRequest request){
		return new ModelAndView("com/invoice/bussInvoiceList");
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
	public void datagrid(BussInvoiceEntity bussInvoice,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BussInvoiceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bussInvoice);
		try{
		//自定义追加查询条件

			TSUser user = (TSUser)request.getSession().getAttribute("USER");			
			//查询关联表中属于自己资源的线索id
			String hql = "from BussInvoiceSharedEntity shared where shared.userId = ?";
			List<BussInvoiceSharedEntity> list = systemService.findHql(hql , user.getId());
			
			String ids[] =new String[list.size()]; 
			for(int i=0 ; i<list.size();i++){
				BussInvoiceSharedEntity shared  = list.get(i);
 				ids[i] = shared.getInvoicesId();
			}
			//避免抛出异常
			if(ids.length==0)ids= new String[]{"0"};
 			//符合条件的客户id数组
//			cq.in("id", ids);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		//cq.add();
		//过滤删除数据
//		cq.eq("delStatus", 1);
		cq.add();
		this.bussInvoiceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除发票
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BussInvoiceEntity bussInvoice, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bussInvoice = systemService.getEntity(BussInvoiceEntity.class, bussInvoice.getId());
		message = "发票删除成功";
		try{
			bussInvoiceService.delMain(bussInvoice);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "发票删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除发票
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "发票删除成功";
		try{
			for(String id:ids.split(",")){
				BussInvoiceEntity bussInvoice = systemService.getEntity(BussInvoiceEntity.class,id);
				bussInvoiceService.delMain(bussInvoice);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "发票删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加发票
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BussInvoiceEntity bussInvoice,BussInvoicePage bussInvoicePage, HttpServletRequest request) {
		List<BussDeliveryitemEntity> bussDeliveryitemList =  bussInvoicePage.getBussDeliveryitemList();
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			bussInvoiceService.addMain(bussInvoice, bussDeliveryitemList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "发票添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新发票
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BussInvoiceEntity bussInvoice,BussInvoicePage bussInvoicePage, HttpServletRequest request) {
		List<BussDeliveryitemEntity> bussDeliveryitemList =  bussInvoicePage.getBussDeliveryitemList();
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		try{
			bussInvoiceService.updateMain(bussInvoice, bussDeliveryitemList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新发票失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 发票新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BussInvoiceEntity bussInvoice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussInvoice.getId())) {
			bussInvoice = bussInvoiceService.getEntity(BussInvoiceEntity.class, bussInvoice.getId());
			req.setAttribute("bussInvoicePage", bussInvoice);
		}
		return new ModelAndView("com/invoice/bussInvoice-add");
	}
	
	/**
	 * 发票编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BussInvoiceEntity bussInvoice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussInvoice.getId())) {
			bussInvoice = bussInvoiceService.getEntity(BussInvoiceEntity.class, bussInvoice.getId());
			req.setAttribute("bussInvoicePage", bussInvoice);
		}
		return new ModelAndView("com/invoice/bussInvoice-update");
	}
	
	
	/**
	 * 加载明细列表[发票明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussDeliveryitemList")
	public ModelAndView bussDeliveryitemList(BussInvoiceEntity bussInvoice, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = bussInvoice.getId();
 		//===================================================================================
		//查询-发票明细
	    String hql0 = "from BussDeliveryitemEntity where 1 = 1 AND invoiceid = ?  ";
	    try{
	    	List<BussDeliveryitemEntity> bussDeliveryitemEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("bussDeliveryitemList", bussDeliveryitemEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/invoice/bussDeliveryitemList");
	}
	
}

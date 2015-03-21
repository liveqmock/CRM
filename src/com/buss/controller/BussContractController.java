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

import com.buss.entity.BussContractEntity;
import com.buss.entity.BussContractitemEntity;
import com.buss.entity.BussDeliveryEntity;
import com.buss.entity.BussInvoiceEntity;
import com.buss.entity.BussReceiveEntity;
import com.buss.page.BussContractPage;
import com.buss.service.BussContractServiceI;
import com.shared.entity.BussContractSharedEntity;
/**   
 * @Title: Controller
 * @Description: 订单
 * @author caoliang
 * @date 2015-03-06 20:45:46
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/bussContractController")
public class BussContractController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BussContractController.class);

	@Autowired
	private BussContractServiceI bussContractService;
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
	 * 订单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussContract")
	public ModelAndView bussContract(HttpServletRequest request) {
		return new ModelAndView("com/contract/bussContractList");
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
	public void datagrid(BussContractEntity bussContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BussContractEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bussContract);
		try{
		//自定义追加查询条件

			TSUser user = (TSUser)request.getSession().getAttribute("USER");			
			//查询关联表中属于自己资源的订单id
			String hql = "from BussContractSharedEntity shared where shared.userId = ?";
			List<BussContractSharedEntity> list = systemService.findHql(hql , user.getId());
			
			String ids[] =new String[list.size()]; 
			for(int i=0 ; i<list.size();i++){
				BussContractSharedEntity shared  = list.get(i);
 				ids[i] = shared.getOrdersId();
			}
			//避免抛出异常
			if(ids.length==0)ids= new String[]{"0"};
 			//符合条件的客户id数组
//			cq.in("id", ids);
			
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		//过滤删除数据
//		cq.eq("delStatus", 1);
		cq.add();
		this.bussContractService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除订单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BussContractEntity bussContract, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bussContract = systemService.getEntity(BussContractEntity.class, bussContract.getId());
		message = "订单删除成功";
		try{
			bussContractService.delMain(bussContract);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "订单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除订单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "订单删除成功";
		try{
			for(String id:ids.split(",")){
				BussContractEntity bussContract = systemService.getEntity(BussContractEntity.class,
				id
				);
				bussContractService.delMain(bussContract);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "订单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加订单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BussContractEntity bussContract,BussContractPage bussContractPage, HttpServletRequest request) {
		List<BussReceiveEntity> bussReceiveList =  bussContractPage.getBussReceiveList();
		List<BussInvoiceEntity> bussInvoiceList =  bussContractPage.getBussInvoiceList();
		List<BussDeliveryEntity> bussDeliveryList =  bussContractPage.getBussDeliveryList();
		List<BussContractitemEntity> bussContractitemList =  bussContractPage.getBussContractitemList();
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			bussContractService.addMain(bussContract, bussReceiveList,bussInvoiceList,bussDeliveryList,bussContractitemList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "订单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新订单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BussContractEntity bussContract,BussContractPage bussContractPage, HttpServletRequest request) {
		List<BussReceiveEntity> bussReceiveList =  bussContractPage.getBussReceiveList();
		List<BussInvoiceEntity> bussInvoiceList =  bussContractPage.getBussInvoiceList();
		List<BussDeliveryEntity> bussDeliveryList =  bussContractPage.getBussDeliveryList();
		List<BussContractitemEntity> bussContractitemList =  bussContractPage.getBussContractitemList();
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		try{
			bussContractService.updateMain(bussContract, bussReceiveList,bussInvoiceList,bussDeliveryList,bussContractitemList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新订单失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 订单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BussContractEntity bussContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussContract.getId())) {
			bussContract = bussContractService.getEntity(BussContractEntity.class, bussContract.getId());
			req.setAttribute("bussContractPage", bussContract);
		}
		return new ModelAndView("com/contract/bussContract-add");
	}
	
	/**
	 * 订单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BussContractEntity bussContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussContract.getId())) {
			bussContract = bussContractService.getEntity(BussContractEntity.class, bussContract.getId());
			req.setAttribute("bussContractPage", bussContract);
		}
		return new ModelAndView("com/contract/bussContract-update");
	}
	
	
	/**
	 * 加载明细列表[收款]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussReceiveList")
	public ModelAndView bussReceiveList(BussContractEntity bussContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = bussContract.getId();
		//===================================================================================
		//查询-收款
	    String hql0 = "from BussReceiveEntity o where 1 = 1 AND o.contractid = ? ";
	    try{
	    	List<BussReceiveEntity> bussReceiveEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("bussReceiveList", bussReceiveEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/contract/bussReceiveList");
	}
	/**
	 * 加载明细列表[发票]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussInvoiceList")
	public ModelAndView bussInvoiceList(BussContractEntity bussContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = bussContract.getId();
		//===================================================================================
		//查询-发票
	    String hql1 = "from BussInvoiceEntity o where 1 = 1 AND o.contractid = ? ";
	    try{
	    	List<BussInvoiceEntity> bussInvoiceEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("bussInvoiceList", bussInvoiceEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/contract/bussInvoiceList");
	}
	/**
	 * 加载明细列表[发货单]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussDeliveryList")
	public ModelAndView bussDeliveryList(BussContractEntity bussContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = bussContract.getId();
		//===================================================================================
		//查询-发货单
	    String hql2 = "from BussDeliveryEntity o where 1 = 1 AND o.contractid = ? ";
	    try{
	    	List<BussDeliveryEntity> bussDeliveryEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("bussDeliveryList", bussDeliveryEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/contract/bussDeliveryList");
	}
	/**
	 * 加载明细列表[订单明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussContractitemList")
	public ModelAndView bussContractitemList(BussContractEntity bussContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id3 = bussContract.getId();
		//===================================================================================
		//查询-订单明细
	    String hql3 = "from BussContractitemEntity o where 1 = 1 AND o.contractid = ? ";
	    try{
	    	List<BussContractitemEntity> bussContractitemEntityList = systemService.findHql(hql3,id3);
			req.setAttribute("bussContractitemList", bussContractitemEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/contract/bussContractitemList");
	}
	
}

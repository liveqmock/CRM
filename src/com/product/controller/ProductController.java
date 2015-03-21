package com.product.controller;
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
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.product.entity.ContractitemEntity;
import com.product.entity.DeliveryitemEntity;
import com.product.entity.DeliveryitemsEntity;
import com.product.entity.ProductEntity;
import com.product.page.ProductPage;
import com.product.service.ProductServiceI;
/**   
 * @Title: Controller
 * @Description: 产品
 * @author onlineGenerator
 * @date 2015-02-11 22:17:23
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/productController")
public class ProductController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductServiceI productService;
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
	 * 产品列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "product")
	public ModelAndView product(HttpServletRequest request) {
		return new ModelAndView("com/product/productList");
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
	public void datagrid(ProductEntity product,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ProductEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, product);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.productService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除产品
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ProductEntity product, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		product = systemService.getEntity(ProductEntity.class, product.getId());
		message = "产品删除成功";
		try{
			productService.delMain(product);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "产品删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除产品
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "产品删除成功";
		try{
			for(String id:ids.split(",")){
				ProductEntity product = systemService.getEntity(ProductEntity.class,
				id
				);
				productService.delMain(product);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "产品删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加产品
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ProductEntity product,ProductPage productPage, HttpServletRequest request) {
		List<ContractitemEntity> contractitemList =  productPage.getContractitemList();
		List<DeliveryitemEntity> deliveryitemList =  productPage.getDeliveryitemList();
		List<DeliveryitemsEntity> deliveryitemsList =  productPage.getDeliveryitemsList();
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			productService.addMain(product, contractitemList,deliveryitemList,deliveryitemsList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "产品添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新产品
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ProductEntity product,ProductPage productPage, HttpServletRequest request) {
		List<ContractitemEntity> contractitemList =  productPage.getContractitemList();
		List<DeliveryitemEntity> deliveryitemList =  productPage.getDeliveryitemList();
		List<DeliveryitemsEntity> deliveryitemsList =  productPage.getDeliveryitemsList();
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		try{
			productService.updateMain(product, contractitemList,deliveryitemList,deliveryitemsList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新产品失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 产品新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ProductEntity product, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(product.getId())) {
			product = productService.getEntity(ProductEntity.class, product.getId());
			req.setAttribute("productPage", product);
		}
		return new ModelAndView("com/product/product-add");
	}
	
	/**
	 * 产品编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ProductEntity product, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(product.getId())) {
			product = productService.getEntity(ProductEntity.class, product.getId());
			req.setAttribute("productPage", product);
		}
		return new ModelAndView("com/product/product-update");
	}
	
	
	/**
	 * 加载明细列表[订单明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "contractitemList")
	public ModelAndView contractitemList(ProductEntity product, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = product.getId();
		//===================================================================================
		//查询-订单明细
	    String hql0 = "from ContractitemEntity where 1 = 1 AND pRODUCTID = ?   ";
	    try{
	    	List<ContractitemEntity> contractitemEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("contractitemList", contractitemEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/product/contractitemList");
	}
	/**
	 * 加载明细列表[发货单明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "deliveryitemList")
	public ModelAndView deliveryitemList(ProductEntity product, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = product.getId();
//		Object id1 = product.getId();
		//===================================================================================
		//查询-发货单明细
	    String hql1 = "from DeliveryitemEntity where 1 = 1  AND pRODUCTID = ? ";
	    try{
	    	List<DeliveryitemEntity> deliveryitemEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("deliveryitemList", deliveryitemEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/product/deliveryitemList");
	}
	/**
	 * 加载明细列表[发票明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "deliveryitemsList")
	public ModelAndView deliveryitemsList(ProductEntity product, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = product.getId();
//		Object id2 = product.getId();
		//===================================================================================
		//查询-发票明细
	    String hql2 = "from DeliveryitemsEntity where 1 = 1   AND pRODUCTID = ? ";
	    try{
	    	List<DeliveryitemsEntity> deliveryitemsEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("deliveryitemsList", deliveryitemsEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/product/deliveryitemsList");
	}
	
}

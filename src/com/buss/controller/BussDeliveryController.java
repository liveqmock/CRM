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
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buss.entity.BussDeliveryEntity;
import com.buss.service.BussDeliveryServiceI;
import com.shared.entity.BussDeliverySharedEntity;

/**   
 * @Title: Controller
 * @Description: 发货单
 * @author caoliang
 * @date 2015-03-07 10:10:07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/bussDeliveryController")
public class BussDeliveryController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BussDeliveryController.class);

	@Autowired
	private BussDeliveryServiceI bussDeliveryService;
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
	 * 发货单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussDelivery")
	public ModelAndView bussDelivery(HttpServletRequest request) {
		return new ModelAndView("com/delivery/bussDeliveryList");
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
	public void datagrid(BussDeliveryEntity bussDelivery,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BussDeliveryEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bussDelivery, request.getParameterMap());
		try{
		//自定义追加查询条件

			TSUser user = (TSUser)request.getSession().getAttribute("USER");			
			//查询关联表中属于自己资源的线索id
			String hql = "from BussDeliverySharedEntity shared where shared.userId = ?";
			List<BussDeliverySharedEntity> list = systemService.findHql(hql , user.getId());
			
			String ids[] =new String[list.size()]; 
			for(int i=0 ; i<list.size();i++){
				BussDeliverySharedEntity shared  = list.get(i);
 				ids[i] = shared.getDeliverysId();
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
		this.bussDeliveryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除发货单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BussDeliveryEntity bussDelivery, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bussDelivery = systemService.getEntity(BussDeliveryEntity.class, bussDelivery.getId());
		message = "发货单删除成功";
		try{
			bussDeliveryService.delete(bussDelivery);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "发货单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除发货单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "发货单删除成功";
		try{
			for(String id:ids.split(",")){
				BussDeliveryEntity bussDelivery = systemService.getEntity(BussDeliveryEntity.class, 
				id
				);
				bussDeliveryService.delete(bussDelivery);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "发货单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加发货单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BussDeliveryEntity bussDelivery, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "发货单添加成功";
		try{
			bussDeliveryService.save(bussDelivery);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "发货单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新发货单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BussDeliveryEntity bussDelivery, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "发货单更新成功";
		BussDeliveryEntity t = bussDeliveryService.get(BussDeliveryEntity.class, bussDelivery.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(bussDelivery, t);
			bussDeliveryService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "发货单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 发货单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BussDeliveryEntity bussDelivery, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussDelivery.getId())) {
			bussDelivery = bussDeliveryService.getEntity(BussDeliveryEntity.class, bussDelivery.getId());
			req.setAttribute("bussDeliveryPage", bussDelivery);
		}
		return new ModelAndView("com/delivery/bussDelivery-add");
	}
	/**
	 * 发货单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BussDeliveryEntity bussDelivery, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussDelivery.getId())) {
			bussDelivery = bussDeliveryService.getEntity(BussDeliveryEntity.class, bussDelivery.getId());
			req.setAttribute("bussDeliveryPage", bussDelivery);
		}
		return new ModelAndView("com/delivery/bussDelivery-update");
	}
}

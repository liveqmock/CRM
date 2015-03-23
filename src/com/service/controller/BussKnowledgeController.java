package com.service.controller;
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
import org.jeecgframework.web.system.pojo.base.TSTypegroup;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.entity.BussKnowledgeEntity;
import com.service.service.BussKnowledgeServiceI;

/**   
 * @Title: Controller
 * @Description: 知识库
 * @author caoliang
 * @date 2015-02-11 22:46:25
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/bussKnowledgeController")
public class BussKnowledgeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BussKnowledgeController.class);

	@Autowired
	private BussKnowledgeServiceI bussKnowledgeService;
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
	 * 知识库列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "bussKnowledge")
	public ModelAndView bussKnowledge(HttpServletRequest request) {
		String typeid = request.getParameter("typeid");
		request.setAttribute("typeid", typeid);
//		List<TSTypegroup> typegroupList = systemService.findByProperty(TSTypegroup.class, "typegroupcode", "process");
		List<TSTypegroup> typegroupList = systemService.findHql(" from TSTypegroup where typegroupcode in ?", " ('Aproduct' , 'Bproduct') ");
		request.setAttribute("typegroupList", typegroupList);
		return new ModelAndView("com/service/bussKnowledgeList");
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
	public void datagrid(BussKnowledgeEntity bussKnowledge,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BussKnowledgeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bussKnowledge, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.bussKnowledgeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除知识库
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BussKnowledgeEntity bussKnowledge, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bussKnowledge = systemService.getEntity(BussKnowledgeEntity.class, bussKnowledge.getId());
		message = "知识库删除成功";
		try{
			bussKnowledgeService.delete(bussKnowledge);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "知识库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除知识库
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "知识库删除成功";
		try{
			for(String id:ids.split(",")){
				BussKnowledgeEntity bussKnowledge = systemService.getEntity(BussKnowledgeEntity.class, 
				id
				);
				bussKnowledgeService.delete(bussKnowledge);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "知识库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加知识库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BussKnowledgeEntity bussKnowledge, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "知识库添加成功";
		try{
			bussKnowledgeService.save(bussKnowledge);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "知识库添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新知识库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BussKnowledgeEntity bussKnowledge, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "知识库更新成功";
		BussKnowledgeEntity t = bussKnowledgeService.get(BussKnowledgeEntity.class, bussKnowledge.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(bussKnowledge, t);
			bussKnowledgeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "知识库更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 知识库新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BussKnowledgeEntity bussKnowledge, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussKnowledge.getId())) {
			bussKnowledge = bussKnowledgeService.getEntity(BussKnowledgeEntity.class, bussKnowledge.getId());
			req.setAttribute("bussKnowledgePage", bussKnowledge);
		}
		return new ModelAndView("com/service/bussKnowledge-add");
	}
	/**
	 * 知识库编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BussKnowledgeEntity bussKnowledge, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bussKnowledge.getId())) {
			bussKnowledge = bussKnowledgeService.getEntity(BussKnowledgeEntity.class, bussKnowledge.getId());
			req.setAttribute("bussKnowledgePage", bussKnowledge);
		}
		return new ModelAndView("com/service/bussKnowledge-update");
	}
}

package com.buss.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.buss.entity.BussActivityEntity;
import com.buss.entity.BussLeadEntity;

public interface BussLeadServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BussLeadEntity bussLead,
	        List<BussActivityEntity> bussActivityList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BussLeadEntity bussLead,
	        List<BussActivityEntity> bussActivityList);
	public void delMain (BussLeadEntity bussLead);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BussLeadEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BussLeadEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BussLeadEntity t);
}

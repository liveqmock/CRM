package com.buss.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.buss.entity.BussDeliveryEntity;
import com.buss.entity.BussDeliveryitemsEntity;

public interface BussDeliveryServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BussDeliveryEntity bussDelivery,
	        List<BussDeliveryitemsEntity> bussDeliveryitemsList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BussDeliveryEntity bussDelivery,
	        List<BussDeliveryitemsEntity> bussDeliveryitemsList);
	public void delMain (BussDeliveryEntity bussDelivery);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BussDeliveryEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BussDeliveryEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BussDeliveryEntity t);
}

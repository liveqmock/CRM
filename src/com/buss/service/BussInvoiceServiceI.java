package com.buss.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.buss.entity.BussDeliveryitemEntity;
import com.buss.entity.BussInvoiceEntity;

public interface BussInvoiceServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BussInvoiceEntity bussInvoice,
	        List<BussDeliveryitemEntity> bussDeliveryitemList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BussInvoiceEntity bussInvoice,
	        List<BussDeliveryitemEntity> bussDeliveryitemList);
	public void delMain (BussInvoiceEntity bussInvoice);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BussInvoiceEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BussInvoiceEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BussInvoiceEntity t);
}

package com.buss.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.buss.entity.BussContractEntity;
import com.buss.entity.BussContractitemEntity;
import com.buss.entity.BussDeliveryEntity;
import com.buss.entity.BussInvoiceEntity;
import com.buss.entity.BussReceiveEntity;

public interface BussContractServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BussContractEntity bussContract,
	        List<BussReceiveEntity> bussReceiveList,List<BussInvoiceEntity> bussInvoiceList,List<BussDeliveryEntity> bussDeliveryList,List<BussContractitemEntity> bussContractitemList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BussContractEntity bussContract,
	        List<BussReceiveEntity> bussReceiveList,List<BussInvoiceEntity> bussInvoiceList,List<BussDeliveryEntity> bussDeliveryList,List<BussContractitemEntity> bussContractitemList);
	public void delMain (BussContractEntity bussContract);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BussContractEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BussContractEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BussContractEntity t);
}

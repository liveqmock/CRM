package com.buss.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.buss.entity.BussAccountEntity;
import com.buss.entity.BussActivityEntity;
import com.buss.entity.BussAttachmentEntity;
import com.buss.entity.BussContactEntity;
import com.buss.entity.BussContractEntity;
import com.buss.entity.BussDeliveryEntity;
import com.buss.entity.BussInvoiceEntity;
import com.buss.entity.BussReceiveEntity;
import com.buss.entity.BussServicesheetEntity;

public interface BussAccountServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BussAccountEntity bussAccount,
	        List<BussContactEntity> bussContactList,List<BussAttachmentEntity> bussAttachmentList,List<BussContractEntity> bussContractList,List<BussInvoiceEntity> bussInvoiceList,List<BussDeliveryEntity> bussDeliveryList,List<BussReceiveEntity> bussReceiveList,List<BussServicesheetEntity> bussServicesheetList,List<BussActivityEntity> bussActivityList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BussAccountEntity bussAccount,
	        List<BussContactEntity> bussContactList,List<BussAttachmentEntity> bussAttachmentList,List<BussContractEntity> bussContractList,List<BussInvoiceEntity> bussInvoiceList,List<BussDeliveryEntity> bussDeliveryList,List<BussReceiveEntity> bussReceiveList,List<BussServicesheetEntity> bussServicesheetList,List<BussActivityEntity> bussActivityList);
	public void delMain (BussAccountEntity bussAccount);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BussAccountEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BussAccountEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BussAccountEntity t);
}

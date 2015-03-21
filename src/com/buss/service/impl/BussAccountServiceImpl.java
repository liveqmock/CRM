package com.buss.service.impl;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.entity.BussAccountEntity;
import com.buss.entity.BussActivityEntity;
import com.buss.entity.BussAttachmentEntity;
import com.buss.entity.BussContactEntity;
import com.buss.entity.BussContractEntity;
import com.buss.entity.BussDeliveryEntity;
import com.buss.entity.BussInvoiceEntity;
import com.buss.entity.BussReceiveEntity;
import com.buss.entity.BussServicesheetEntity;
import com.buss.service.BussAccountServiceI;
import com.shared.entity.BussAccountSharedEntity;
@Service("bussAccountService")
@Transactional
public class BussAccountServiceImpl extends CommonServiceImpl implements BussAccountServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((BussAccountEntity)entity);
 	}
	
	public void addMain(BussAccountEntity bussAccount,
	        List<BussContactEntity> bussContactList,List<BussAttachmentEntity> bussAttachmentList,List<BussContractEntity> bussContractList,List<BussInvoiceEntity> bussInvoiceList,List<BussDeliveryEntity> bussDeliveryList,List<BussReceiveEntity> bussReceiveList,List<BussServicesheetEntity> bussServicesheetList,List<BussActivityEntity> bussActivityList){
			//1保存主信息
			this.save(bussAccount);
			
		
			/**保存-联系人*/
			for(BussContactEntity bussContact:bussContactList){
				//外键设置
				bussContact.setAccountid(bussAccount.getId());
				this.save(bussContact);
			}
			/**保存-附件*/
			for(BussAttachmentEntity bussAttachment:bussAttachmentList){
				//外键设置
				bussAttachment.setAccountid(bussAccount.getId());
				this.save(bussAttachment);
			}
			/**保存-订单*/
			for(BussContractEntity bussContract:bussContractList){
				//外键设置
				bussContract.setAccountid(bussAccount.getId());
				this.save(bussContract);
			}
			/**保存-发票*/
			for(BussInvoiceEntity bussInvoice:bussInvoiceList){
				//外键设置
				bussInvoice.setAccountid(bussAccount.getId());
				this.save(bussInvoice);
			}
			/**保存-发货单*/
			for(BussDeliveryEntity bussDelivery:bussDeliveryList){
				//外键设置
				bussDelivery.setAccountid(bussAccount.getId());
				this.save(bussDelivery);
			}
			/**保存-收款*/
			for(BussReceiveEntity bussReceive:bussReceiveList){
				//外键设置
				bussReceive.setAccountid(bussAccount.getId());
				this.save(bussReceive);
			}
			/**保存-服务工单*/
			for(BussServicesheetEntity bussServicesheet:bussServicesheetList){
				//外键设置
				bussServicesheet.setAccountid(bussAccount.getId());
				this.save(bussServicesheet);
			}
			/**保存-活动跟进*/
			for(BussActivityEntity bussActivity:bussActivityList){
				//外键设置
				bussActivity.setAccountid(bussAccount.getId());
				this.save(bussActivity);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(bussAccount);
	}

	
	public void updateMain(BussAccountEntity bussAccount,
	        List<BussContactEntity> bussContactList,List<BussAttachmentEntity> bussAttachmentList,List<BussContractEntity> bussContractList,List<BussInvoiceEntity> bussInvoiceList,List<BussDeliveryEntity> bussDeliveryList,List<BussReceiveEntity> bussReceiveList,List<BussServicesheetEntity> bussServicesheetList,List<BussActivityEntity> bussActivityList) {
		//保存主表信息
		this.saveOrUpdate(bussAccount);
		//===================================================================================
		//获取参数
		Object id0 = bussAccount.getId();
		Object id1 = bussAccount.getId();
//		Object id1 = bussAccount.getId();
		Object id2 = bussAccount.getId();
//		Object cONTRACT3 = bussAccount.getCONTRACT();
		Object id3 = bussAccount.getId();
		Object id4 = bussAccount.getId();
//		Object id4 = bussAccount.getId();
		Object id5 = bussAccount.getId();
//		Object id5 = bussAccount.getId();
		Object id6 = bussAccount.getId();
		Object id7 = bussAccount.getId();
//		Object id7 = bussAccount.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-联系人
	    String hql0 = "from BussContactEntity where 1 = 1 AND accountid = ? ";
	    List<BussContactEntity> bussContactOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-联系人
		for(BussContactEntity oldE:bussContactOldList){
			boolean isUpdate = false;
				for(BussContactEntity sendE:bussContactList){
					//需要更新的明细数据-联系人
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-联系人
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-联系人
			for(BussContactEntity bussContact:bussContactList){
				if(oConvertUtils.isEmpty(bussContact.getId())){
					//外键设置
					bussContact.setAccountid(bussAccount.getId());
					this.save(bussContact);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-附件
	    String hql1 = "from BussAttachmentEntity where 1 = 1 AND aCCOUNTID = ?  ";
	    List<BussAttachmentEntity> bussAttachmentOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-附件
		for(BussAttachmentEntity oldE:bussAttachmentOldList){
			boolean isUpdate = false;
				for(BussAttachmentEntity sendE:bussAttachmentList){
					//需要更新的明细数据-附件
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-附件
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-附件
			for(BussAttachmentEntity bussAttachment:bussAttachmentList){
				if(oConvertUtils.isEmpty(bussAttachment.getId())){
					//外键设置
					bussAttachment.setAccountid(bussAccount.getId());
					this.save(bussAttachment);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-订单
	    String hql2 = "from BussContractEntity where 1 = 1 AND aCCOUNTID = ? ";
	    List<BussContractEntity> bussContractOldList = this.findHql(hql2,id2);
		//2.筛选更新明细数据-订单
		for(BussContractEntity oldE:bussContractOldList){
			boolean isUpdate = false;
				for(BussContractEntity sendE:bussContractList){
					//需要更新的明细数据-订单
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-订单
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-订单
			for(BussContractEntity bussContract:bussContractList){
				if(oConvertUtils.isEmpty(bussContract.getId())){
					//外键设置
					bussContract.setAccountid(bussAccount.getId());
					this.save(bussContract);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-发票
	    String hql3 = "from BussInvoiceEntity where 1 = 1 AND aCCOUNTID = ? ";
	    List<BussInvoiceEntity> bussInvoiceOldList = this.findHql(hql3,id3);
		//2.筛选更新明细数据-发票
		for(BussInvoiceEntity oldE:bussInvoiceOldList){
			boolean isUpdate = false;
				for(BussInvoiceEntity sendE:bussInvoiceList){
					//需要更新的明细数据-发票
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-发票
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-发票
			for(BussInvoiceEntity bussInvoice:bussInvoiceList){
				if(oConvertUtils.isEmpty(bussInvoice.getId())){
					//外键设置
					bussInvoice.setAccountid(bussAccount.getId());
					this.save(bussInvoice);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-发货单
	    String hql4 = "from BussDeliveryEntity where 1 = 1 AND  aCCOUNTID = ? ";
	    List<BussDeliveryEntity> bussDeliveryOldList = this.findHql(hql4,id4);
		//2.筛选更新明细数据-发货单
		for(BussDeliveryEntity oldE:bussDeliveryOldList){
			boolean isUpdate = false;
				for(BussDeliveryEntity sendE:bussDeliveryList){
					//需要更新的明细数据-发货单
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-发货单
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-发货单
			for(BussDeliveryEntity bussDelivery:bussDeliveryList){
				if(oConvertUtils.isEmpty(bussDelivery.getId())){
					//外键设置
					bussDelivery.setAccountid(bussAccount.getId());
					this.save(bussDelivery);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-收款
	    String hql5 = "from BussReceiveEntity where 1 = 1   AND aCCOUNTID = ? ";
	    List<BussReceiveEntity> bussReceiveOldList = this.findHql(hql5,id5);
		//2.筛选更新明细数据-收款
		for(BussReceiveEntity oldE:bussReceiveOldList){
			boolean isUpdate = false;
				for(BussReceiveEntity sendE:bussReceiveList){
					//需要更新的明细数据-收款
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-收款
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-收款
			for(BussReceiveEntity bussReceive:bussReceiveList){
				if(oConvertUtils.isEmpty(bussReceive.getId())){
					//外键设置
					bussReceive.setAccountid(bussAccount.getId());
					this.save(bussReceive);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-服务工单
	    String hql6 = "from BussServicesheetEntity where 1 = 1 AND aCCOUNTID = ? ";
	    List<BussServicesheetEntity> bussServicesheetOldList = this.findHql(hql6,id6);
		//2.筛选更新明细数据-服务工单
		for(BussServicesheetEntity oldE:bussServicesheetOldList){
			boolean isUpdate = false;
				for(BussServicesheetEntity sendE:bussServicesheetList){
					//需要更新的明细数据-服务工单
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-服务工单
		    		super.delete(oldE);
	    		}	    		
			}
			//3.持久化新增的数据-服务工单
			for(BussServicesheetEntity bussServicesheet:bussServicesheetList){
				if(oConvertUtils.isEmpty(bussServicesheet.getId())){
					//外键设置
					bussServicesheet.setAccountid(bussAccount.getId());
					this.save(bussServicesheet);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-活动跟进
	    String hql7 = "from BussActivityEntity where 1 = 1 AND aCCOUNTID = ? ";
	    List<BussActivityEntity> bussActivityOldList = this.findHql(hql7,id7);
		//2.筛选更新明细数据-活动跟进
		for(BussActivityEntity oldE:bussActivityOldList){
			boolean isUpdate = false;
				for(BussActivityEntity sendE:bussActivityList){
					//需要更新的明细数据-活动跟进
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-活动跟进
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-活动跟进
			for(BussActivityEntity bussActivity:bussActivityList){
				if(oConvertUtils.isEmpty(bussActivity.getId())){
					//外键设置
					bussActivity.setAccountid(bussAccount.getId());
					this.save(bussActivity);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(bussAccount);
	}

	
	public void delMain(BussAccountEntity bussAccount) {
		//删除主表信息
		this.delete(bussAccount);
		//===================================================================================
		//获取参数
		Object id0 = bussAccount.getId();
		Object id1 = bussAccount.getId();
//		Object id1 = bussAccount.getId();
		Object id2 = bussAccount.getId();
		Object id3 = bussAccount.getId();
		Object id4 = bussAccount.getId();
//		Object id4 = bussAccount.getId();
		Object id5 = bussAccount.getId();
//		Object id5 = bussAccount.getId();
		Object id6 = bussAccount.getId();
		Object id7 = bussAccount.getId();
//		Object id7 = bussAccount.getId();
		//===================================================================================
		//删除-联系人
	    String hql0 = "from BussContactEntity where 1 = 1 AND aCCOUNTID = ? ";
	    List<BussContactEntity> bussContactOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(bussContactOldList);
		//===================================================================================
		//删除-附件
	    String hql1 = "from BussAttachmentEntity where 1 = 1 AND aCCOUNTID = ? ";
	    List<BussAttachmentEntity> bussAttachmentOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(bussAttachmentOldList);
		//===================================================================================
		//删除-订单
	    String hql2 = "from BussContractEntity where 1 = 1 AND aCCOUNTID = ? ";
	    List<BussContractEntity> bussContractOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(bussContractOldList);
		//===================================================================================
		//删除-发票
	    String hql3 = "from BussInvoiceEntity where 1 = 1 AND   aCCOUNTID = ? ";
	    List<BussInvoiceEntity> bussInvoiceOldList = this.findHql(hql3,id3);
		this.deleteAllEntitie(bussInvoiceOldList);
		//===================================================================================
		//删除-发货单
	    String hql4 = "from BussDeliveryEntity where 1 = 1 AND   aCCOUNTID = ? ";
	    List<BussDeliveryEntity> bussDeliveryOldList = this.findHql(hql4,id4);
		this.deleteAllEntitie(bussDeliveryOldList);
		//===================================================================================
		//删除-收款
	    String hql5 = "from BussReceiveEntity where 1 = 1   AND aCCOUNTID = ? ";
	    List<BussReceiveEntity> bussReceiveOldList = this.findHql(hql5,id5);
		this.deleteAllEntitie(bussReceiveOldList);
		//===================================================================================
		//删除-服务工单
	    String hql6 = "from BussServicesheetEntity where 1 = 1 AND aCCOUNTID = ? ";
	    List<BussServicesheetEntity> bussServicesheetOldList = this.findHql(hql6,id6);
		this.deleteAllEntitie(bussServicesheetOldList);
		//===================================================================================
		//删除-活动跟进
	    String hql7 = "from BussActivityEntity where 1 = 1 AND aCCOUNTID = ?  ";
	    List<BussActivityEntity> bussActivityOldList = this.findHql(hql7,id7);
		this.deleteAllEntitie(bussActivityOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BussAccountEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BussAccountEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BussAccountEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,BussAccountEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{mobile}",String.valueOf(t.getMobile()));
 		sql  = sql.replace("#{intention}",String.valueOf(t.getIntention()));
 		sql  = sql.replace("#{provinces}",String.valueOf(t.getProvinces()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{level}",String.valueOf(t.getLevel()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{source}",String.valueOf(t.getSource()));
 		sql  = sql.replace("#{identity}",String.valueOf(t.getIdentity()));
 		sql  = sql.replace("#{photo}",String.valueOf(t.getPhoto()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{owner}",String.valueOf(t.getOwner()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}
package com.buss.service.impl;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.entity.BussContractEntity;
import com.buss.entity.BussContractitemEntity;
import com.buss.entity.BussDeliveryEntity;
import com.buss.entity.BussInvoiceEntity;
import com.buss.entity.BussReceiveEntity;
import com.buss.service.BussContractServiceI;
@Service("bussContractService")
@Transactional
public class BussContractServiceImpl extends CommonServiceImpl implements BussContractServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((BussContractEntity)entity);
 	}
	
	public void addMain(BussContractEntity bussContract,
	        List<BussReceiveEntity> bussReceiveList,List<BussInvoiceEntity> bussInvoiceList,List<BussDeliveryEntity> bussDeliveryList,List<BussContractitemEntity> bussContractitemList){
			//保存主信息
			this.save(bussContract);
		
			/**保存-收款*/
			for(BussReceiveEntity bussReceive:bussReceiveList){
				//外键设置
				bussReceive.setContractid(bussContract.getId());
				this.save(bussReceive);
			}
			/**保存-发票*/
			for(BussInvoiceEntity bussInvoice:bussInvoiceList){
				//外键设置
				bussInvoice.setContractid(bussContract.getId());
				this.save(bussInvoice);
			}
			/**保存-发货单*/
			for(BussDeliveryEntity bussDelivery:bussDeliveryList){
				//外键设置
				bussDelivery.setContractid(bussContract.getId());
				this.save(bussDelivery);
			}
			/**保存-订单明细*/
			for(BussContractitemEntity bussContractitem:bussContractitemList){
				//外键设置
				bussContractitem.setContractid(bussContract.getId());
				this.save(bussContractitem);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(bussContract);
	}

	
	public void updateMain(BussContractEntity bussContract,
	        List<BussReceiveEntity> bussReceiveList,List<BussInvoiceEntity> bussInvoiceList,List<BussDeliveryEntity> bussDeliveryList,List<BussContractitemEntity> bussContractitemList) {
		//保存主表信息
		this.saveOrUpdate(bussContract);
		//===================================================================================
		//获取参数
		Object id0 = bussContract.getId();
		Object id1 = bussContract.getId();
		Object id2 = bussContract.getId();
		Object id3 = bussContract.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-收款
	    String hql0 = "from BussReceiveEntity o where 1 = 1 AND o.contractid = ? ";
	    List<BussReceiveEntity> bussReceiveOldList = this.findHql(hql0,id0);
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
					bussReceive.setContractid(bussContract.getId());
					this.save(bussReceive);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-发票
	    String hql1 = "from BussInvoiceEntity o where 1 = 1 AND o.contractid = ? ";
	    List<BussInvoiceEntity> bussInvoiceOldList = this.findHql(hql1,id1);
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
					bussInvoice.setContractid(bussContract.getId());
					this.save(bussInvoice);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-发货单
	    String hql2 = "from BussDeliveryEntity o where 1 = 1 AND o.contractid = ? ";
	    List<BussDeliveryEntity> bussDeliveryOldList = this.findHql(hql2,id2);
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
					bussDelivery.setContractid(bussContract.getId());
					this.save(bussDelivery);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-订单明细
	    String hql3 = "from BussContractitemEntity o where 1 = 1 AND o.contractid = ? ";
	    List<BussContractitemEntity> bussContractitemOldList = this.findHql(hql3,id3);
		//2.筛选更新明细数据-订单明细
		for(BussContractitemEntity oldE:bussContractitemOldList){
			boolean isUpdate = false;
				for(BussContractitemEntity sendE:bussContractitemList){
					//需要更新的明细数据-订单明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-订单明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-订单明细
			for(BussContractitemEntity bussContractitem:bussContractitemList){
				if(oConvertUtils.isEmpty(bussContractitem.getId())){
					//外键设置
					bussContractitem.setContractid(bussContract.getId());
					this.save(bussContractitem);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(bussContract);
	}

	
	public void delMain(BussContractEntity bussContract) {
		//删除主表信息
		this.delete(bussContract);
		//===================================================================================
		//获取参数
		Object id0 = bussContract.getId();
		Object id1 = bussContract.getId();
		Object id2 = bussContract.getId();
		Object id3 = bussContract.getId();
		//===================================================================================
		//删除-收款
	    String hql0 = "from BussReceiveEntity o where 1 = 1 AND o.contractid = ? ";
	    List<BussReceiveEntity> bussReceiveOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(bussReceiveOldList);
		//===================================================================================
		//删除-发票
	    String hql1 = "from BussInvoiceEntity o where 1 = 1 AND o.contractid = ? ";
	    List<BussInvoiceEntity> bussInvoiceOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(bussInvoiceOldList);
		//===================================================================================
		//删除-发货单
	    String hql2 = "from BussDeliveryEntity o where 1 = 1 AND o.contractid = ? ";
	    List<BussDeliveryEntity> bussDeliveryOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(bussDeliveryOldList);
		//===================================================================================
		//删除-订单明细
	    String hql3 = "from BussContractitemEntity o where 1 = 1 AND o.contractid = ? ";
	    List<BussContractitemEntity> bussContractitemOldList = this.findHql(hql3,id3);
		this.deleteAllEntitie(bussContractitemOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BussContractEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BussContractEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BussContractEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,BussContractEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{quantily}",String.valueOf(t.getQuantily()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{total}",String.valueOf(t.getTotal()));
 		sql  = sql.replace("#{accountname}",String.valueOf(t.getAccountname()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{owner}",String.valueOf(t.getOwner()));
 		sql  = sql.replace("#{collect}",String.valueOf(t.getCollect()));
 		sql  = sql.replace("#{uncollect}",String.valueOf(t.getUncollect()));
 		sql  = sql.replace("#{accountid}",String.valueOf(t.getAccountid()));
 		sql  = sql.replace("#{ceatedate}",String.valueOf(t.getCeatedate()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}
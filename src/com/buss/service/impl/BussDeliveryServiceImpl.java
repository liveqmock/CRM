package com.buss.service.impl;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.entity.BussDeliveryEntity;
import com.buss.entity.BussDeliveryitemsEntity;
import com.buss.service.BussDeliveryServiceI;
@Service("bussDeliveryService")
@Transactional
public class BussDeliveryServiceImpl extends CommonServiceImpl implements BussDeliveryServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((BussDeliveryEntity)entity);
 	}
	
	public void addMain(BussDeliveryEntity bussDelivery,
	        List<BussDeliveryitemsEntity> bussDeliveryitemsList){
			//保存主信息
			this.save(bussDelivery);
		
			/**保存-发货单明细*/
			for(BussDeliveryitemsEntity bussDeliveryitems:bussDeliveryitemsList){
				//外键设置
				bussDeliveryitems.setDeliveryid(bussDelivery.getId());
				this.save(bussDeliveryitems);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(bussDelivery);
	}

	
	public void updateMain(BussDeliveryEntity bussDelivery,
	        List<BussDeliveryitemsEntity> bussDeliveryitemsList) {
		//保存主表信息
		this.saveOrUpdate(bussDelivery);
		//===================================================================================
		//获取参数
		Object id0 = bussDelivery.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-发货单明细
	    String hql0 = "from BussDeliveryitemsEntity where 1 = 1 AND dELIVERYID = ? ";
	    List<BussDeliveryitemsEntity> bussDeliveryitemsOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-发货单明细
		for(BussDeliveryitemsEntity oldE:bussDeliveryitemsOldList){
			boolean isUpdate = false;
				for(BussDeliveryitemsEntity sendE:bussDeliveryitemsList){
					//需要更新的明细数据-发货单明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-发货单明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-发货单明细
			for(BussDeliveryitemsEntity bussDeliveryitems:bussDeliveryitemsList){
				if(oConvertUtils.isEmpty(bussDeliveryitems.getId())){
					//外键设置
					bussDeliveryitems.setDeliveryid(bussDelivery.getId());
					this.save(bussDeliveryitems);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(bussDelivery);
	}

	
	public void delMain(BussDeliveryEntity bussDelivery) {
		//删除主表信息
		this.delete(bussDelivery);
		//===================================================================================
		//获取参数
		Object id0 = bussDelivery.getId();
		//===================================================================================
		//删除-发货单明细
	    String hql0 = "from BussDeliveryitemsEntity where 1 = 1 AND dELIVERYID = ? ";
	    List<BussDeliveryitemsEntity> bussDeliveryitemsOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(bussDeliveryitemsOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BussDeliveryEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BussDeliveryEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BussDeliveryEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,BussDeliveryEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{contractid}",String.valueOf(t.getContractid()));
 		sql  = sql.replace("#{contractname}",String.valueOf(t.getContractname()));
 		sql  = sql.replace("#{accountid}",String.valueOf(t.getAccountid()));
 		sql  = sql.replace("#{accountname}",String.valueOf(t.getAccountname()));
 		sql  = sql.replace("#{creatdate}",String.valueOf(t.getCreatdate()));
 		sql  = sql.replace("#{owner}",String.valueOf(t.getOwner()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{deliverytotal}",String.valueOf(t.getDeliverytotal()));
 		sql  = sql.replace("#{deliverydate}",String.valueOf(t.getDeliverydate()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{contractno}",String.valueOf(t.getContractno()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}
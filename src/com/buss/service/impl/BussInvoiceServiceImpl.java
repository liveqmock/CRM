package com.buss.service.impl;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.entity.BussDeliveryitemEntity;
import com.buss.entity.BussInvoiceEntity;
import com.buss.service.BussInvoiceServiceI;
@Service("bussInvoiceService")
@Transactional
public class BussInvoiceServiceImpl extends CommonServiceImpl implements BussInvoiceServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((BussInvoiceEntity)entity);
 	}
	
	public void addMain(BussInvoiceEntity bussInvoice,
	        List<BussDeliveryitemEntity> bussDeliveryitemList){
			//保存主信息
			this.save(bussInvoice);
		
			/**保存-发票明细*/
			for(BussDeliveryitemEntity bussDeliveryitem:bussDeliveryitemList){
				//外键设置
				bussDeliveryitem.setInvoiceid(bussInvoice.getId());
				this.save(bussDeliveryitem);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(bussInvoice);
	}

	
	public void updateMain(BussInvoiceEntity bussInvoice,
	        List<BussDeliveryitemEntity> bussDeliveryitemList) {
		//保存主表信息
		this.saveOrUpdate(bussInvoice);
		//===================================================================================
		//获取参数
		Object id0 = bussInvoice.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-发票明细
	    String hql0 = "from BussDeliveryitemEntity where 1 = 1 AND iNVOICEID = ? ";
	    List<BussDeliveryitemEntity> bussDeliveryitemOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-发票明细
		for(BussDeliveryitemEntity oldE:bussDeliveryitemOldList){
			boolean isUpdate = false;
				for(BussDeliveryitemEntity sendE:bussDeliveryitemList){
					//需要更新的明细数据-发票明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-发票明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-发票明细
			for(BussDeliveryitemEntity bussDeliveryitem:bussDeliveryitemList){
				if(oConvertUtils.isEmpty(bussDeliveryitem.getId())){
					//外键设置
					bussDeliveryitem.setInvoiceid(bussInvoice.getId());
					this.save(bussDeliveryitem);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(bussInvoice);
	}

	
	public void delMain(BussInvoiceEntity bussInvoice) {
		//删除主表信息
		this.delete(bussInvoice);
		//===================================================================================
		//获取参数
		Object id0 = bussInvoice.getId();
		//===================================================================================
		//删除-发票明细
	    String hql0 = "from BussDeliveryitemEntity where 1 = 1 AND iNVOICEID = ? ";
	    List<BussDeliveryitemEntity> bussDeliveryitemOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(bussDeliveryitemOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BussInvoiceEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BussInvoiceEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BussInvoiceEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,BussInvoiceEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{contractid}",String.valueOf(t.getContractid()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{quote}",String.valueOf(t.getQuote()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{accountname}",String.valueOf(t.getAccountname()));
 		sql  = sql.replace("#{accountid}",String.valueOf(t.getAccountid()));
 		sql  = sql.replace("#{createby}",String.valueOf(t.getCreateby()));
 		sql  = sql.replace("#{createdate}",String.valueOf(t.getCreatedate()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}
package com.product.service.impl;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.entity.ContractitemEntity;
import com.product.entity.DeliveryitemEntity;
import com.product.entity.DeliveryitemsEntity;
import com.product.entity.ProductEntity;
import com.product.service.ProductServiceI;
@Service("productService")
@Transactional
public class ProductServiceImpl extends CommonServiceImpl implements ProductServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ProductEntity)entity);
 	}
	
	public void addMain(ProductEntity product,
	        List<ContractitemEntity> contractitemList,List<DeliveryitemEntity> deliveryitemList,List<DeliveryitemsEntity> deliveryitemsList){
			//保存主信息
			this.save(product);
		
			/**保存-订单明细*/
			for(ContractitemEntity contractitem:contractitemList){
				//外键设置
				contractitem.setProductid(product.getId());
				this.save(contractitem);
			}
			/**保存-发货单明细*/
			for(DeliveryitemEntity deliveryitem:deliveryitemList){
				//外键设置
				deliveryitem.setProductid(product.getId());
				this.save(deliveryitem);
			}
			/**保存-发票明细*/
			for(DeliveryitemsEntity deliveryitems:deliveryitemsList){
				//外键设置
				deliveryitems.setProductid(product.getId());
				this.save(deliveryitems);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(product);
	}

	
	public void updateMain(ProductEntity product,
	        List<ContractitemEntity> contractitemList,List<DeliveryitemEntity> deliveryitemList,List<DeliveryitemsEntity> deliveryitemsList) {
		//保存主表信息
		this.saveOrUpdate(product);
		//===================================================================================
		//获取参数
		Object id = product.getId();
 		//===================================================================================
		//1.查询出数据库的明细数据-订单明细
	    String hql0 = "from ContractitemEntity where 1 = 1 AND  cONTRACTID = ? ";
	    List<ContractitemEntity> contractitemOldList = this.findHql(hql0,id);
		//2.筛选更新明细数据-订单明细
		for(ContractitemEntity oldE:contractitemOldList){
			boolean isUpdate = false;
				for(ContractitemEntity sendE:contractitemList){
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
			for(ContractitemEntity contractitem:contractitemList){
				if(oConvertUtils.isEmpty(contractitem.getId())){
					//外键设置
					contractitem.setProductid(product.getId());
					this.save(contractitem);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-发货单明细
	    String hql1 = "from DeliveryitemEntity where 1 = 1   AND pRODUCTID = ? ";
	    List<DeliveryitemEntity> deliveryitemOldList = this.findHql(hql1,id);
		//2.筛选更新明细数据-发货单明细
		for(DeliveryitemEntity oldE:deliveryitemOldList){
			boolean isUpdate = false;
				for(DeliveryitemEntity sendE:deliveryitemList){
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
			for(DeliveryitemEntity deliveryitem:deliveryitemList){
				if(oConvertUtils.isEmpty(deliveryitem.getId())){
					//外键设置
					deliveryitem.setProductid(product.getId());
					this.save(deliveryitem);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-发票明细
	    String hql2 = "from DeliveryitemsEntity where 1 = 1  AND pRODUCTID = ? ";
	    List<DeliveryitemsEntity> deliveryitemsOldList = this.findHql(hql2,id);
		//2.筛选更新明细数据-发票明细
		for(DeliveryitemsEntity oldE:deliveryitemsOldList){
			boolean isUpdate = false;
				for(DeliveryitemsEntity sendE:deliveryitemsList){
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
			for(DeliveryitemsEntity deliveryitems:deliveryitemsList){
				if(oConvertUtils.isEmpty(deliveryitems.getId())){
					//外键设置
					deliveryitems.setProductid(product.getId());
					this.save(deliveryitems);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(product);
	}

	
	public void delMain(ProductEntity product) {
		//删除主表信息
		this.delete(product);
		//===================================================================================
		//获取参数
		Object id0 = product.getId();
		Object id1 = product.getId();
		Object id2 = product.getId();
		//===================================================================================
		//删除-订单明细
	    String hql0 = "from ContractitemEntity where 1 = 1 AND pRODUCTID = ? ";
	    List<ContractitemEntity> contractitemOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(contractitemOldList);
		//===================================================================================
		//删除-发货单明细
	    String hql1 = "from DeliveryitemEntity where 1 = 1    AND pRODUCTID = ? ";
	    List<DeliveryitemEntity> deliveryitemOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(deliveryitemOldList);
		//===================================================================================
		//删除-发票明细
	    String hql2 = "from DeliveryitemsEntity where 1 = 1   AND pRODUCTID = ? ";
	    List<DeliveryitemsEntity> deliveryitemsOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(deliveryitemsOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ProductEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ProductEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ProductEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ProductEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{actualprice}",String.valueOf(t.getActualprice()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{unit}",String.valueOf(t.getUnit()));
 		sql  = sql.replace("#{stock}",String.valueOf(t.getStock()));
 		sql  = sql.replace("#{creatdate}",String.valueOf(t.getCreatdate()));
 		sql  = sql.replace("#{owner}",String.valueOf(t.getOwner()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}
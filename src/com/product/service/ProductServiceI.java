package com.product.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.product.entity.ContractitemEntity;
import com.product.entity.DeliveryitemEntity;
import com.product.entity.DeliveryitemsEntity;
import com.product.entity.ProductEntity;

public interface ProductServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ProductEntity product,
	        List<ContractitemEntity> contractitemList,List<DeliveryitemEntity> deliveryitemList,List<DeliveryitemsEntity> deliveryitemsList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ProductEntity product,
	        List<ContractitemEntity> contractitemList,List<DeliveryitemEntity> deliveryitemList,List<DeliveryitemsEntity> deliveryitemsList);
	public void delMain (ProductEntity product);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ProductEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ProductEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ProductEntity t);
}

package com.product.page;

import java.util.ArrayList;
import java.util.List;

import com.product.entity.ContractitemEntity;
import com.product.entity.DeliveryitemEntity;
import com.product.entity.DeliveryitemsEntity;

/**   
 * @Title: Entity
 * @Description: 产品
 * @author onlineGenerator
 * @date 2015-02-11 22:17:23
 * @version V1.0   
 *
 */
public class ProductPage implements java.io.Serializable {
	/**保存-订单明细*/
	private List<ContractitemEntity> contractitemList = new ArrayList<ContractitemEntity>();
	public List<ContractitemEntity> getContractitemList() {
		return contractitemList;
	}
	public void setContractitemList(List<ContractitemEntity> contractitemList) {
		this.contractitemList = contractitemList;
	}
	/**保存-发货单明细*/
	private List<DeliveryitemEntity> deliveryitemList = new ArrayList<DeliveryitemEntity>();
	public List<DeliveryitemEntity> getDeliveryitemList() {
		return deliveryitemList;
	}
	public void setDeliveryitemList(List<DeliveryitemEntity> deliveryitemList) {
		this.deliveryitemList = deliveryitemList;
	}
	/**保存-发票明细*/
	private List<DeliveryitemsEntity> deliveryitemsList = new ArrayList<DeliveryitemsEntity>();
	public List<DeliveryitemsEntity> getDeliveryitemsList() {
		return deliveryitemsList;
	}
	public void setDeliveryitemsList(List<DeliveryitemsEntity> deliveryitemsList) {
		this.deliveryitemsList = deliveryitemsList;
	}

	/**主键*/
	private java.lang.String id;
	/**产品名称*/
	private java.lang.String name;
	/**编号*/
	private java.lang.String no;
	/**类型*/
	private java.lang.String type;
	/**标准价格*/
	private java.lang.Double price;
	/**实际价格*/
	private java.lang.Double actualprice;
	/**描述*/
	private java.lang.String remark;
	/**计价单位*/
	private java.lang.String unit;
	/**库存*/
	private java.lang.Integer stock;
	/**创建时间*/
	private java.util.Date creatdate;
	/**管理人员*/
	private java.lang.String owner;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名称
	 */
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型
	 */
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  标准价格
	 */
	public java.lang.Double getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  标准价格
	 */
	public void setPrice(java.lang.Double price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实际价格
	 */
	public java.lang.Double getActualprice(){
		return this.actualprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际价格
	 */
	public void setActualprice(java.lang.Double actualprice){
		this.actualprice = actualprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计价单位
	 */
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计价单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  库存
	 */
	public java.lang.Integer getStock(){
		return this.stock;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  库存
	 */
	public void setStock(java.lang.Integer stock){
		this.stock = stock;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	public java.util.Date getCreatdate(){
		return this.creatdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreatdate(java.util.Date creatdate){
		this.creatdate = creatdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管理人员
	 */
	public java.lang.String getOwner(){
		return this.owner;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理人员
	 */
	public void setOwner(java.lang.String owner){
		this.owner = owner;
	}
}

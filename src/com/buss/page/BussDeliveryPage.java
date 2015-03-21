package com.buss.page;

import java.util.ArrayList;
import java.util.List;

import com.buss.entity.BussDeliveryitemsEntity;

/**   
 * @Title: Entity
 * @Description: 发货单
 * @author onlineGenerator
 * @date 2015-02-20 20:48:03
 * @version V1.0   
 *
 */
public class BussDeliveryPage implements java.io.Serializable {
	/**保存-发货单明细*/
	private List<BussDeliveryitemsEntity> bussDeliveryitemsList = new ArrayList<BussDeliveryitemsEntity>();
	public List<BussDeliveryitemsEntity> getBussDeliveryitemsList() {
		return bussDeliveryitemsList;
	}
	public void setBussDeliveryitemsList(List<BussDeliveryitemsEntity> bussDeliveryitemsList) {
		this.bussDeliveryitemsList = bussDeliveryitemsList;
	}

	/**主键*/
	private java.lang.String id;
	/**订单id*/
	private java.lang.String contractid;
	/**订单名称*/
	private java.lang.String contractname;
	/**客户id*/
	private java.lang.String accountid;
	/**客户名称*/
	private java.lang.String accountname;
	/**创建时间*/
	private java.util.Date creatdate;
	/**发货人*/
	private java.lang.String owner;
	/**状态*/
	private java.lang.String status;
	/**地址*/
	private java.lang.String address;
	/**发货数量*/
	private java.lang.Integer deliverytotal;
	/**发货时间*/
	private java.util.Date deliverydate;
	/**描述*/
	private java.lang.String remark;
	/**订单编号*/
	private java.lang.String contractno;
	/**发货单编号*/
	private java.lang.String no;
	
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
	 *@return: java.lang.String  订单id
	 */
	public java.lang.String getContractid(){
		return this.contractid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单id
	 */
	public void setContractid(java.lang.String contractid){
		this.contractid = contractid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单名称
	 */
	public java.lang.String getContractname(){
		return this.contractname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单名称
	 */
	public void setContractname(java.lang.String contractname){
		this.contractname = contractname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户id
	 */
	public java.lang.String getAccountid(){
		return this.accountid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户id
	 */
	public void setAccountid(java.lang.String accountid){
		this.accountid = accountid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	public java.lang.String getAccountname(){
		return this.accountname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setAccountname(java.lang.String accountname){
		this.accountname = accountname;
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
	 *@return: java.lang.String  发货人
	 */
	public java.lang.String getOwner(){
		return this.owner;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货人
	 */
	public void setOwner(java.lang.String owner){
		this.owner = owner;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发货数量
	 */
	public java.lang.Integer getDeliverytotal(){
		return this.deliverytotal;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发货数量
	 */
	public void setDeliverytotal(java.lang.Integer deliverytotal){
		this.deliverytotal = deliverytotal;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发货时间
	 */
	public java.util.Date getDeliverydate(){
		return this.deliverydate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发货时间
	 */
	public void setDeliverydate(java.util.Date deliverydate){
		this.deliverydate = deliverydate;
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
	 *@return: java.lang.String  订单编号
	 */
	public java.lang.String getContractno(){
		return this.contractno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单编号
	 */
	public void setContractno(java.lang.String contractno){
		this.contractno = contractno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货单编号
	 */
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货单编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
}

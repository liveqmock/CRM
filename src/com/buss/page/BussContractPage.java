package com.buss.page;

import java.util.ArrayList;
import java.util.List;

import com.buss.entity.BussContractitemEntity;
import com.buss.entity.BussDeliveryEntity;
import com.buss.entity.BussInvoiceEntity;
import com.buss.entity.BussReceiveEntity;

/**   
 * @Title: Entity
 * @Description: 订单
 * @author onlineGenerator
 * @date 2015-03-06 20:45:46
 * @version V1.0   
 *
 */
public class BussContractPage implements java.io.Serializable {
	/**保存-收款*/
	private List<BussReceiveEntity> bussReceiveList = new ArrayList<BussReceiveEntity>();
	public List<BussReceiveEntity> getBussReceiveList() {
		return bussReceiveList;
	}
	public void setBussReceiveList(List<BussReceiveEntity> bussReceiveList) {
		this.bussReceiveList = bussReceiveList;
	}
	/**保存-发票*/
	private List<BussInvoiceEntity> bussInvoiceList = new ArrayList<BussInvoiceEntity>();
	public List<BussInvoiceEntity> getBussInvoiceList() {
		return bussInvoiceList;
	}
	public void setBussInvoiceList(List<BussInvoiceEntity> bussInvoiceList) {
		this.bussInvoiceList = bussInvoiceList;
	}
	/**保存-发货单*/
	private List<BussDeliveryEntity> bussDeliveryList = new ArrayList<BussDeliveryEntity>();
	public List<BussDeliveryEntity> getBussDeliveryList() {
		return bussDeliveryList;
	}
	public void setBussDeliveryList(List<BussDeliveryEntity> bussDeliveryList) {
		this.bussDeliveryList = bussDeliveryList;
	}
	/**保存-订单明细*/
	private List<BussContractitemEntity> bussContractitemList = new ArrayList<BussContractitemEntity>();
	public List<BussContractitemEntity> getBussContractitemList() {
		return bussContractitemList;
	}
	public void setBussContractitemList(List<BussContractitemEntity> bussContractitemList) {
		this.bussContractitemList = bussContractitemList;
	}

	/**主键*/
	private java.lang.String id;
	/**订单编号*/
	private java.lang.String no;
	/**类型*/
	private java.lang.String type;
	/**订单名称*/
	private java.lang.String name;
	/**状态*/
	private java.lang.String status;
	/**数量*/
	private java.lang.Integer quantily;
	/**价格*/
	private java.lang.Integer price;
	/**总价*/
	private java.lang.Integer total;
	/**客户姓名*/
	private java.lang.String accountname;
	/**地址*/
	private java.lang.String address;
	/**描述*/
	private java.lang.String remark;
	/**负责人*/
	private java.lang.String owner;
	/**已收款*/
	private java.lang.Integer collect;
	/**未收款*/
	private java.lang.Integer uncollect;
	/**客户id*/
	private java.lang.String accountid;
	/**创建时间*/
	private java.util.Date ceatedate;
	
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
	 *@return: java.lang.String  订单编号
	 */
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单编号
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单名称
	 */
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数量
	 */
	public java.lang.Integer getQuantily(){
		return this.quantily;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数量
	 */
	public void setQuantily(java.lang.Integer quantily){
		this.quantily = quantily;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  价格
	 */
	public java.lang.Integer getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  价格
	 */
	public void setPrice(java.lang.Integer price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总价
	 */
	public java.lang.Integer getTotal(){
		return this.total;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总价
	 */
	public void setTotal(java.lang.Integer total){
		this.total = total;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户姓名
	 */
	public java.lang.String getAccountname(){
		return this.accountname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户姓名
	 */
	public void setAccountname(java.lang.String accountname){
		this.accountname = accountname;
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
	 *@return: java.lang.String  负责人
	 */
	public java.lang.String getOwner(){
		return this.owner;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  负责人
	 */
	public void setOwner(java.lang.String owner){
		this.owner = owner;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  已收款
	 */
	public java.lang.Integer getCollect(){
		return this.collect;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  已收款
	 */
	public void setCollect(java.lang.Integer collect){
		this.collect = collect;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  未收款
	 */
	public java.lang.Integer getUncollect(){
		return this.uncollect;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  未收款
	 */
	public void setUncollect(java.lang.Integer uncollect){
		this.uncollect = uncollect;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	public java.util.Date getCeatedate(){
		return this.ceatedate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCeatedate(java.util.Date ceatedate){
		this.ceatedate = ceatedate;
	}
}

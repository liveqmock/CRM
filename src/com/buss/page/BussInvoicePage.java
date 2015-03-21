package com.buss.page;

import java.util.ArrayList;
import java.util.List;

import com.buss.entity.BussDeliveryitemEntity;

/**   
 * @Title: Entity
 * @Description: 发票
 * @author onlineGenerator
 * @date 2015-02-20 20:46:15
 * @version V1.0   
 *
 */
public class BussInvoicePage implements java.io.Serializable {
	/**保存-发票明细*/
	private List<BussDeliveryitemEntity> bussDeliveryitemList = new ArrayList<BussDeliveryitemEntity>();
	public List<BussDeliveryitemEntity> getBussDeliveryitemList() {
		return bussDeliveryitemList;
	}
	public void setBussDeliveryitemList(List<BussDeliveryitemEntity> bussDeliveryitemList) {
		this.bussDeliveryitemList = bussDeliveryitemList;
	}

	/**主键*/
	private java.lang.String id;
	/**id*/
	private java.lang.String contract;
	/**发票编号*/
	private java.lang.String no;
	/**类型*/
	private java.lang.String type;
	/**发票名称*/
	private java.lang.String name;
	/**发票金额*/
	private java.lang.Double quote;
	/**描述*/
	private java.lang.String remark;
	/**状态*/
	private java.lang.String status;
	/**客户姓名*/
	private java.lang.String accountname;
	/**客户id*/
	private java.lang.String accountid;
	/**开票人*/
	private java.lang.String createby;
	/**开票时间*/
	private java.util.Date createdate;
	
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
	 *@return: java.lang.String  id
	 */
	public java.lang.String getContract(){
		return this.contract;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setContract(java.lang.String contract){
		this.contract = contract;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票编号
	 */
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票编号
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
	 *@return: java.lang.String  发票名称
	 */
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  发票金额
	 */
	public java.lang.Double getQuote(){
		return this.quote;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  发票金额
	 */
	public void setQuote(java.lang.Double quote){
		this.quote = quote;
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
	 *@return: java.lang.String  开票人
	 */
	public java.lang.String getCreateby(){
		return this.createby;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开票人
	 */
	public void setCreateby(java.lang.String createby){
		this.createby = createby;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开票时间
	 */
	public java.util.Date getCreatedate(){
		return this.createdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开票时间
	 */
	public void setCreatedate(java.util.Date createdate){
		this.createdate = createdate;
	}
}

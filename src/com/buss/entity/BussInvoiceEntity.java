package com.buss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 发票
 * @author onlineGenerator
 * @date 2015-03-06 20:45:46
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_invoice", schema = "")
@SuppressWarnings("serial")
public class BussInvoiceEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**订单id*/
	private java.lang.String contractid;
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
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
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
	@Column(name ="CONTRACT_ID",nullable=false,length=36)
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
	 *@return: java.lang.String  发票编号
	 */
	@Column(name ="NO",nullable=true,length=36)
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
	@Column(name ="TYPE",nullable=true,length=12)
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
	@Column(name ="NAME",nullable=true,length=36)
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
	@Column(name ="QUOTE",nullable=true,scale=2,length=12)
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
	@Column(name ="REMARK",nullable=true,length=512)
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
	@Column(name ="STATUS",nullable=true,length=12)
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
	@Column(name ="ACCOUNTNAME",nullable=true,length=36)
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
	@Column(name ="ACCOUNTID",nullable=false,length=36)
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
	@Column(name ="CREATEBY",nullable=true,length=36)
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
	@Column(name ="CREATEDATE",nullable=true,length=36)
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

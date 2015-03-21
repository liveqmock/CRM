package com.buss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 收款
 * @author onlineGenerator
 * @date 2015-03-06 20:45:46
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_receive", schema = "")
@SuppressWarnings("serial")
public class BussReceiveEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**订单id*/
	private java.lang.String contractid;
	/**订单编号*/
	private java.lang.String contractno;
	/**客户id*/
	private java.lang.String accountid;
	/**客户名称*/
	private java.lang.String accountname;
	/**收款编号*/
	private java.lang.String no;
	/**收款金额*/
	private java.lang.Double amount;
	/**创建时间*/
	private java.util.Date creatdate;
	/**收款日期*/
	private java.util.Date receivedate;
	/**状态*/
	private java.lang.String status;
	/**收款人*/
	private java.lang.String owner;
	/**描述*/
	private java.lang.String remark;
	
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
	 *@return: java.lang.String  订单编号
	 */
	@Column(name ="CONTRACTNO",nullable=true,length=36)
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
	 *@return: java.lang.String  客户id
	 */
	@Column(name ="ACCOUNTID",nullable=true,length=36)
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
	@Column(name ="ACCOUNTNAME",nullable=true,length=36)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款编号
	 */
	@Column(name ="NO",nullable=true,length=36)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  收款金额
	 */
	@Column(name ="AMOUNT",nullable=true,scale=2,length=12)
	public java.lang.Double getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  收款金额
	 */
	public void setAmount(java.lang.Double amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATDATE",nullable=true,length=12)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收款日期
	 */
	@Column(name ="RECEIVEDATE",nullable=true,length=12)
	public java.util.Date getReceivedate(){
		return this.receivedate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收款日期
	 */
	public void setReceivedate(java.util.Date receivedate){
		this.receivedate = receivedate;
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
	 *@return: java.lang.String  收款人
	 */
	@Column(name ="OWNER",nullable=true,length=12)
	public java.lang.String getOwner(){
		return this.owner;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款人
	 */
	public void setOwner(java.lang.String owner){
		this.owner = owner;
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
}

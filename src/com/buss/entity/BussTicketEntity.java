package com.buss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 发票
 * @author onlineGenerator
 * @date 2015-02-05 00:12:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_ticket", schema = "")
@SuppressWarnings("serial")
public class BussTicketEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**金额*/
	@Excel(exportName="金额")
	private java.lang.Integer amount;
	/**客户名称*/
	@Excel(exportName="客户名称")
	private java.lang.String customer;
	/**发票时间*/
	@Excel(exportName="发票时间")
	private java.util.Date createDt;
	/**外键*/
	private java.lang.String ticketId;
	
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  金额
	 */
	@Column(name ="AMOUNT",nullable=true,length=32)
	public java.lang.Integer getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  金额
	 */
	public void setAmount(java.lang.Integer amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	@Column(name ="CUSTOMER",nullable=true,length=100)
	public java.lang.String getCustomer(){
		return this.customer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setCustomer(java.lang.String customer){
		this.customer = customer;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发票时间
	 */
	@Column(name ="CREATE_DT",nullable=true,length=32)
	public java.util.Date getCreateDt(){
		return this.createDt;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发票时间
	 */
	public void setCreateDt(java.util.Date createDt){
		this.createDt = createDt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外键
	 */
	@Column(name ="TICKET_ID",nullable=true,length=36)
	public java.lang.String getTicketId(){
		return this.ticketId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外键
	 */
	public void setTicketId(java.lang.String ticketId){
		this.ticketId = ticketId;
	}
}

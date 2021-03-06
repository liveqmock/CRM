package com.shared.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 线索共享
 * @author onlineGenerator
 * @date 2015-02-08 00:50:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_lead_shared", schema = "")
@SuppressWarnings("serial")
public class BussLeadSharedEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**线索id*/
	private java.lang.String salesId;
	/**用户id*/
	private java.lang.String userId;
	/**创建者id*/
	private java.lang.String createUserId;
	/**共享时间*/
	private java.util.Date createDate;
	
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
	 *@return: java.lang.String  线索id
	 */
	@Column(name ="SALES_ID",nullable=true,length=36)
	public java.lang.String getSalesId(){
		return this.salesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  线索id
	 */
	public void setSalesId(java.lang.String salesId){
		this.salesId = salesId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USER_ID",nullable=true,length=36)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建者id
	 */
	@Column(name ="CREATE_USER_ID",nullable=true,length=36)
	public java.lang.String getCreateUserId(){
		return this.createUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建者id
	 */
	public void setCreateUserId(java.lang.String createUserId){
		this.createUserId = createUserId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  共享时间
	 */
	@Column(name ="CREATE_DATE",nullable=true,length=36)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  共享时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
}

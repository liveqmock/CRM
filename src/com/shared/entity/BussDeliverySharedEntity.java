package com.shared.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 发货单共享
 * @author qi
 * @date 2015-03-11 22:03:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_delivery_shared", schema = "")
@SuppressWarnings("serial")
public class BussDeliverySharedEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**发货单id*/
	private java.lang.String deliverysId;
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
	 *@return: java.lang.String  发货单id
	 */
	@Column(name ="INVOICES_ID",nullable=true,length=36)
	public java.lang.String getDeliverysId(){
		return this.deliverysId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货单id
	 */
	public void setDeliverysId(java.lang.String deliverysId){
		this.deliverysId = deliverysId;
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
package com.buss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 活动跟进
 * @author onlineGenerator
 * @date 2015-02-11 22:38:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_activity", schema = "")
@SuppressWarnings("serial")
public class BussActivityEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**活动时间*/
	private java.util.Date date;
	/**名称*/
	private java.lang.String name;
	/**内容描述*/
	private java.lang.String remark;
	/**执行人*/
	private java.lang.String people;
	/**创建时间*/
	private java.util.Date creatdate;
	/**客户id*/
	private java.lang.String accountid;
	/**客户姓名*/
	private java.lang.String accountname;
	/**线索id*/
	private java.lang.String leadid;
	/**线索姓名*/
	private java.lang.String leadname;
	/**状态*/
	private java.lang.String status;
	
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动时间
	 */
	@Column(name ="DATE",nullable=true,length=12)
	public java.util.Date getDate(){
		return this.date;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动时间
	 */
	public void setDate(java.util.Date date){
		this.date = date;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	@Column(name ="NAME",nullable=true,length=12)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容描述
	 */
	@Column(name ="REMARK",nullable=true,length=512)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容描述
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  执行人
	 */
	@Column(name ="PEOPLE",nullable=true,length=12)
	public java.lang.String getPeople(){
		return this.people;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  执行人
	 */
	public void setPeople(java.lang.String people){
		this.people = people;
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
	 *@return: java.lang.String  客户姓名
	 */
	@Column(name ="ACCOUNTNAME",nullable=true,length=24)
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
	 *@return: java.lang.String  线索id
	 */
	@Column(name ="LEADID",nullable=false,length=36)
	public java.lang.String getLeadid(){
		return this.leadid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  线索id
	 */
	public void setLeadid(java.lang.String leadid){
		this.leadid = leadid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  线索姓名
	 */
	@Column(name ="LEADNAME",nullable=true,length=24)
	public java.lang.String getLeadname(){
		return this.leadname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  线索姓名
	 */
	public void setLeadname(java.lang.String leadname){
		this.leadname = leadname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="STATUS",nullable=true,length=8)
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
}

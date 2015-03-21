package com.buss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 服务工单
 * @author onlineGenerator
 * @date 2015-02-11 22:34:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_servicesheet", schema = "")
@SuppressWarnings("serial")
public class BussServicesheetEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**客户id*/
	private java.lang.String accountid;
	/**客户名称*/
	private java.lang.String accountname;
	/**工单编号*/
	private java.lang.String no;
	/**工单类型*/
	private java.lang.String type;
	/**状态*/
	private java.lang.String status;
	/**受理人*/
	private java.lang.String persons;
	/**处理人*/
	private java.lang.String dealingpeople;
	/**问题描述*/
	private java.lang.String problem;
	/**处理方式*/
	private java.lang.String method;
	/**受理时间*/
	private java.util.Date creatdate;
	/**处理时间*/
	private java.util.Date processtime;
	/**联系电话*/
	private java.lang.String phone;
	/**地址*/
	private java.lang.String address;
	/**费用*/
	private java.lang.Double cost;
	/**图片*/
	private java.lang.String photo;
	/**工单级别*/
	private java.lang.String level;
	
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
	 *@return: java.lang.String  工单编号
	 */
	@Column(name ="NO",nullable=true,length=36)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工单编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工单类型
	 */
	@Column(name ="TYPE",nullable=true,length=12)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工单类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
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
	 *@return: java.lang.String  受理人
	 */
	@Column(name ="PERSONS",nullable=true,length=12)
	public java.lang.String getPersons(){
		return this.persons;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  受理人
	 */
	public void setPersons(java.lang.String persons){
		this.persons = persons;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理人
	 */
	@Column(name ="DEALINGPEOPLE",nullable=true,length=12)
	public java.lang.String getDealingpeople(){
		return this.dealingpeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理人
	 */
	public void setDealingpeople(java.lang.String dealingpeople){
		this.dealingpeople = dealingpeople;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  问题描述
	 */
	@Column(name ="PROBLEM",nullable=true,length=1024)
	public java.lang.String getProblem(){
		return this.problem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  问题描述
	 */
	public void setProblem(java.lang.String problem){
		this.problem = problem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理方式
	 */
	@Column(name ="METHOD",nullable=true,length=1024)
	public java.lang.String getMethod(){
		return this.method;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理方式
	 */
	public void setMethod(java.lang.String method){
		this.method = method;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  受理时间
	 */
	@Column(name ="CREATDATE",nullable=true,length=12)
	public java.util.Date getCreatdate(){
		return this.creatdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  受理时间
	 */
	public void setCreatdate(java.util.Date creatdate){
		this.creatdate = creatdate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  处理时间
	 */
	@Column(name ="PROCESSTIME",nullable=true,length=12)
	public java.util.Date getProcesstime(){
		return this.processtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  处理时间
	 */
	public void setProcesstime(java.util.Date processtime){
		this.processtime = processtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="PHONE",nullable=true,length=12)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */
	@Column(name ="ADDRESS",nullable=true,length=256)
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
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  费用
	 */
	@Column(name ="COST",nullable=true,scale=2,length=12)
	public java.lang.Double getCost(){
		return this.cost;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  费用
	 */
	public void setCost(java.lang.Double cost){
		this.cost = cost;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片
	 */
	@Column(name ="PHOTO",nullable=true,length=512)
	public java.lang.String getPhoto(){
		return this.photo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片
	 */
	public void setPhoto(java.lang.String photo){
		this.photo = photo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工单级别
	 */
	@Column(name ="LEVEL",nullable=true,length=8)
	public java.lang.String getLevel(){
		return this.level;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工单级别
	 */
	public void setLevel(java.lang.String level){
		this.level = level;
	}
}

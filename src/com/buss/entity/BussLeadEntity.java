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
 * @Description: 线索
 * @author onlineGenerator
 * @date 2015-02-11 22:38:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_lead", schema = "")
@SuppressWarnings("serial")
public class BussLeadEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**姓名*/
	@Excel(exportName="姓名")
	private java.lang.String name;
	/**手机*/
	@Excel(exportName="手机")
	private java.lang.String mobile;
	/**固话*/
	@Excel(exportName="固话")
	private java.lang.String phone;
	/**来源*/
	@Excel(exportName="来源")
	private java.lang.String source;
	/**意向级别*/
	@Excel(exportName="意向级别")
	private java.lang.String level;
	/**描述*/
	private java.lang.String remark;
	/**状态*/
	private java.lang.String leadstatus;
	/**负责人*/
	private java.lang.String owner;
	/**分配人*/
	private java.lang.String distribution;
	/**分配时间*/
	private java.util.Date distributiondate;
	/**分配状态*/
	private java.lang.String distributionstatus;
	/**创建人*/
	private java.lang.String createName;
	/**创建时间*/
	private java.util.Date createDate;
	/**修改人*/
	private java.lang.String updateName;
	/**修改时间*/
	private java.util.Date updateDate;
	//删除状态
	private java.lang.Integer delStatus;
	
	
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
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=24)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机
	 */
	@Column(name ="MOBILE",nullable=true,length=12)
	public java.lang.String getMobile(){
		return this.mobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机
	 */
	public void setMobile(java.lang.String mobile){
		this.mobile = mobile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  固话
	 */
	@Column(name ="PHONE",nullable=true,length=12)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  固话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  来源
	 */
	@Column(name ="SOURCE",nullable=true,length=24)
	public java.lang.String getSource(){
		return this.source;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来源
	 */
	public void setSource(java.lang.String source){
		this.source = source;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  意向级别
	 */
	@Column(name ="LEVEL",nullable=true,length=24)
	public java.lang.String getLevel(){
		return this.level;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  意向级别
	 */
	public void setLevel(java.lang.String level){
		this.level = level;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="REMARK",nullable=true,length=2048)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String 描述
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="leadstatus",nullable=true,length=12)
	public java.lang.String getLeadstatus(){
		return this.leadstatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setLeadstatus(java.lang.String leadstatus){
		this.leadstatus = leadstatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  负责人
	 */
	@Column(name ="OWNER",nullable=true,length=12)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分配人
	 */
	@Column(name ="DISTRIBUTION",nullable=true,length=12)
	public java.lang.String getDistribution(){
		return this.distribution;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分配人
	 */
	public void setDistribution(java.lang.String distribution){
		this.distribution = distribution;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  分配时间
	 */
	@Column(name ="DISTRIBUTIONDATE",nullable=true,length=24)
	public java.util.Date getDistributiondate(){
		return this.distributiondate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  分配时间
	 */
	public void setDistributiondate(java.util.Date distributiondate){
		this.distributiondate = distributiondate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分配状态
	 */
	@Column(name ="DISTRIBUTIONSTATUS",nullable=true,length=12)
	public java.lang.String getDistributionstatus(){
		return this.distributionstatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分配状态
	 */
	public void setDistributionstatus(java.lang.String distributionstatus){
		this.distributionstatus = distributionstatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=100)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	@Column(name ="del_status",nullable=true,length=20)
	public java.lang.Integer getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(java.lang.Integer delStatus) {
		this.delStatus = delStatus;
	}
	
}

package com.buss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 客户管理
 * @author onlineGenerator
 * @date 2015-02-11 22:34:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_account", schema = "")
@SuppressWarnings("serial")
public class BussAccountEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**客户姓名*/
	private java.lang.String name;
	/**电话号码*/
	private java.lang.String phone;
	/**性别*/
	private java.lang.String sex;
	/**地址*/
	private java.lang.String address;
	/**手机*/
	private java.lang.String mobile;
	/**客户意向*/
	private java.lang.String intention;
	/**省份*/
	private java.lang.String provinces;
	/**客户类型*/
	private java.lang.String type;
	/**客户级别*/
	private java.lang.String level;
	/**客户编码*/
	private java.lang.String no;
	/**客户来源*/
	private java.lang.String source;
	/**身份证*/
	private java.lang.String identity;
	/**图片*/
	private java.lang.String photo;
	/**描述*/
	private java.lang.String remark;
	/**负责人*/
	private java.lang.String owner;
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
	 *@return: java.lang.String  客户姓名
	 */
	@Column(name ="NAME",nullable=false,length=24)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话号码
	 */
	@Column(name ="PHONE",nullable=false,length=12)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话号码
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=6)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */
	@Column(name ="ADDRESS",nullable=true,length=128)
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
	 *@return: java.lang.String  客户意向
	 */
	@Column(name ="INTENTION",nullable=true,length=24)
	public java.lang.String getIntention(){
		return this.intention;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户意向
	 */
	public void setIntention(java.lang.String intention){
		this.intention = intention;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  省份
	 */
	@Column(name ="PROVINCES",nullable=true,length=12)
	public java.lang.String getProvinces(){
		return this.provinces;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省份
	 */
	public void setProvinces(java.lang.String provinces){
		this.provinces = provinces;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户类型
	 */
	@Column(name ="TYPE",nullable=true,length=24)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户级别
	 */
	@Column(name ="LEVEL",nullable=true,length=24)
	public java.lang.String getLevel(){
		return this.level;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户级别
	 */
	public void setLevel(java.lang.String level){
		this.level = level;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户编码
	 */
	@Column(name ="NO",nullable=true,length=24)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编码
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户来源
	 */
	@Column(name ="SOURCE",nullable=true,length=12)
	public java.lang.String getSource(){
		return this.source;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户来源
	 */
	public void setSource(java.lang.String source){
		this.source = source;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证
	 */
	@Column(name ="IDENTITY",nullable=true,length=18)
	public java.lang.String getIdentity(){
		return this.identity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证
	 */
	public void setIdentity(java.lang.String identity){
		this.identity = identity;
	}
	/**
	 *方法: 取得java.sql.String
	 *@return: java.sql.String  图片
	 */
	@Column(name ="PHOTO",nullable=true,length=128)
	public java.lang.String getPhoto(){
		return this.photo;
	}

	/**
	 *方法: 设置java.sql.String
	 *@param: java.sql.String  图片
	 */
	public void setPhoto(java.lang.String photo){
		this.photo = photo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="REMARK",nullable=true,length=5556)
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

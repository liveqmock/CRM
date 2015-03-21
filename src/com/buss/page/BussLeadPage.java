package com.buss.page;

import java.util.ArrayList;
import java.util.List;

import com.buss.entity.BussActivityEntity;

/**   
 * @Title: Entity
 * @Description: 线索
 * @author onlineGenerator
 * @date 2015-02-11 22:38:42
 * @version V1.0   
 *
 */
public class BussLeadPage implements java.io.Serializable {
	/**保存-活动跟进*/
	private List<BussActivityEntity> bussActivityList = new ArrayList<BussActivityEntity>();
	public List<BussActivityEntity> getBussActivityList() {
		return bussActivityList;
	}
	public void setBussActivityList(List<BussActivityEntity> bussActivityList) {
		this.bussActivityList = bussActivityList;
	}

	/**主键*/
	private java.lang.String id;
	/**姓名*/
	private java.lang.String name;
	/**手机*/
	private java.lang.String mobile;
	/**固话*/
	private java.lang.String phone;
	/**来源*/
	private java.lang.String source;
	/**意向级别*/
	private java.lang.String level;
	/**描述*/
	private java.lang.String remark;
	/**状态*/
	private java.lang.String status;
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
	 *@return: java.lang.String  姓名
	 */
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
	 *@return: java.lang.String  负责人
	 */
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
}

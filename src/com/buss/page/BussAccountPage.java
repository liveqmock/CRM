package com.buss.page;

import java.util.ArrayList;
import java.util.List;

import com.buss.entity.BussActivityEntity;
import com.buss.entity.BussAttachmentEntity;
import com.buss.entity.BussContactEntity;
import com.buss.entity.BussContractEntity;
import com.buss.entity.BussDeliveryEntity;
import com.buss.entity.BussInvoiceEntity;
import com.buss.entity.BussReceiveEntity;
import com.buss.entity.BussServicesheetEntity;

/**   
 * @Title: Entity
 * @Description: 客户管理
 * @author onlineGenerator
 * @date 2015-02-11 22:34:14
 * @version V1.0   
 *
 */
public class BussAccountPage implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**保存-联系人*/
	private List<BussContactEntity> bussContactList = new ArrayList<BussContactEntity>();
	public List<BussContactEntity> getBussContactList() {
		return bussContactList;
	}
	public void setBussContactList(List<BussContactEntity> bussContactList) {
		this.bussContactList = bussContactList;
	}
	/**保存-附件*/
	private List<BussAttachmentEntity> bussAttachmentList = new ArrayList<BussAttachmentEntity>();
	public List<BussAttachmentEntity> getBussAttachmentList() {
		return bussAttachmentList;
	}
	public void setBussAttachmentList(List<BussAttachmentEntity> bussAttachmentList) {
		this.bussAttachmentList = bussAttachmentList;
	}
	/**保存-订单*/
	private List<BussContractEntity> bussContractList = new ArrayList<BussContractEntity>();
	public List<BussContractEntity> getBussContractList() {
		return bussContractList;
	}
	public void setBussContractList(List<BussContractEntity> bussContractList) {
		this.bussContractList = bussContractList;
	}
	/**保存-发票*/
	private List<BussInvoiceEntity> bussInvoiceList = new ArrayList<BussInvoiceEntity>();
	public List<BussInvoiceEntity> getBussInvoiceList() {
		return bussInvoiceList;
	}
	public void setBussInvoiceList(List<BussInvoiceEntity> bussInvoiceList) {
		this.bussInvoiceList = bussInvoiceList;
	}
	/**保存-发货单*/
	private List<BussDeliveryEntity> bussDeliveryList = new ArrayList<BussDeliveryEntity>();
	public List<BussDeliveryEntity> getBussDeliveryList() {
		return bussDeliveryList;
	}
	public void setBussDeliveryList(List<BussDeliveryEntity> bussDeliveryList) {
		this.bussDeliveryList = bussDeliveryList;
	}
	/**保存-收款*/
	private List<BussReceiveEntity> bussReceiveList = new ArrayList<BussReceiveEntity>();
	public List<BussReceiveEntity> getBussReceiveList() {
		return bussReceiveList;
	}
	public void setBussReceiveList(List<BussReceiveEntity> bussReceiveList) {
		this.bussReceiveList = bussReceiveList;
	}
	/**保存-服务工单*/
	private List<BussServicesheetEntity> bussServicesheetList = new ArrayList<BussServicesheetEntity>();
	public List<BussServicesheetEntity> getBussServicesheetList() {
		return bussServicesheetList;
	}
	public void setBussServicesheetList(List<BussServicesheetEntity> bussServicesheetList) {
		this.bussServicesheetList = bussServicesheetList;
	}
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
	 *@return: java.lang.String  客户姓名
	 */
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片
	 */
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

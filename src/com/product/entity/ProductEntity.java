package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 产品
 * @author onlineGenerator
 * @date 2015-02-11 22:17:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_product", schema = "")
@SuppressWarnings("serial")
public class ProductEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**产品名称*/
	private java.lang.String name;
	/**编号*/
	private java.lang.String no;
	/**类型*/
	private java.lang.String type;
	/**标准价格*/
	private java.lang.Double price;
	/**实际价格*/
	private java.lang.Double actualprice;
	/**描述*/
	private java.lang.String remark;
	/**计价单位*/
	private java.lang.String unit;
	/**库存*/
	private java.lang.Integer stock;
	/**创建时间*/
	private java.util.Date creatdate;
	/**管理人员*/
	private java.lang.String owner;
	
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
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="NAME",nullable=true,length=36)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	@Column(name ="NO",nullable=true,length=36)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型
	 */
	@Column(name ="TYPE",nullable=true,length=12)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  标准价格
	 */
	@Column(name ="PRICE",nullable=true,scale=2,length=8)
	public java.lang.Double getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  标准价格
	 */
	public void setPrice(java.lang.Double price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实际价格
	 */
	@Column(name ="ACTUALPRICE",nullable=true,scale=2,length=8)
	public java.lang.Double getActualprice(){
		return this.actualprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际价格
	 */
	public void setActualprice(java.lang.Double actualprice){
		this.actualprice = actualprice;
	}
	/**
	 *方法: 取得
	 *@return:   描述
	 */
	@Column(name ="REMARK",nullable=true,length=1024)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置
	 *@param:   描述
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计价单位
	 */
	@Column(name ="UNIT",nullable=true,length=8)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计价单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  库存
	 */
	@Column(name ="STOCK",nullable=true,length=8)
	public java.lang.Integer getStock(){
		return this.stock;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  库存
	 */
	public void setStock(java.lang.Integer stock){
		this.stock = stock;
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
	 *@return: java.lang.String  管理人员
	 */
	@Column(name ="OWNER",nullable=true,length=12)
	public java.lang.String getOwner(){
		return this.owner;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理人员
	 */
	public void setOwner(java.lang.String owner){
		this.owner = owner;
	}
}

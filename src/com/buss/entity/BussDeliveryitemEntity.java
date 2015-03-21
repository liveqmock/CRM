package com.buss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 发票明细
 * @author onlineGenerator
 * @date 2015-03-07 10:32:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_deliveryItem", schema = "")
@SuppressWarnings("serial")
public class BussDeliveryitemEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**发票id*/
	private java.lang.String invoiceid;
	/**产品id*/
	private java.lang.String productid;
	/**产品名称*/
	private java.lang.String productname;
	/**计价单位*/
	private java.lang.String unit;
	/**数量*/
	private java.lang.Integer amount;
	/**单价*/
	private java.lang.Double price;
	/**小计*/
	private java.lang.Double subtotal;
	/**发票名称*/
	private java.lang.String invoicename;
	/**描述*/
	private java.lang.String remark;
	/**创建时间*/
	private java.util.Date creatdate;
	
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
	 *@return: java.lang.String  发票id
	 */
	@Column(name ="INVOICEID",nullable=false,length=36)
	public java.lang.String getInvoiceid(){
		return this.invoiceid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票id
	 */
	public void setInvoiceid(java.lang.String invoiceid){
		this.invoiceid = invoiceid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品id
	 */
	@Column(name ="PRODUCTID",nullable=false,length=36)
	public java.lang.String getProductid(){
		return this.productid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品id
	 */
	public void setProductid(java.lang.String productid){
		this.productid = productid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="PRODUCTNAME",nullable=true,length=36)
	public java.lang.String getProductname(){
		return this.productname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setProductname(java.lang.String productname){
		this.productname = productname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计价单位
	 */
	@Column(name ="UNIT",nullable=true,length=12)
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
	 *@return: java.lang.Integer  数量
	 */
	@Column(name ="AMOUNT",nullable=true,length=8)
	public java.lang.Integer getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数量
	 */
	public void setAmount(java.lang.Integer amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  单价
	 */
	@Column(name ="PRICE",nullable=true,scale=2,length=8)
	public java.lang.Double getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  单价
	 */
	public void setPrice(java.lang.Double price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  小计
	 */
	@Column(name ="SUBTOTAL",nullable=true,scale=2,length=12)
	public java.lang.Double getSubtotal(){
		return this.subtotal;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  小计
	 */
	public void setSubtotal(java.lang.Double subtotal){
		this.subtotal = subtotal;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票名称
	 */
	@Column(name ="INVOICENAME",nullable=true,length=36)
	public java.lang.String getInvoicename(){
		return this.invoicename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票名称
	 */
	public void setInvoicename(java.lang.String invoicename){
		this.invoicename = invoicename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="REMARK",nullable=true,length=512)
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
}

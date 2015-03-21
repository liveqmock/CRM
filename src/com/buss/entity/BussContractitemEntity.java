package com.buss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 订单明细
 * @author onlineGenerator
 * @date 2015-03-06 20:45:46
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_contractItem", schema = "")
@SuppressWarnings("serial")
public class BussContractitemEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**产品id*/
	private java.lang.String productid;
	/**订单id*/
	private java.lang.String contractid;
	/**产品名称*/
	private java.lang.String product;
	/**数量*/
	private java.lang.Integer amount;
	/**订单名称*/
	private java.lang.String contractname;
	/**计价单位*/
	private java.lang.String unit;
	/**单价*/
	private java.lang.Double unitprice;
	/**小计*/
	private java.lang.Double subtotal;
	/**折扣*/
	private java.lang.Double agio;
	/**创建时间*/
	private java.util.Date createdate;
	
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
	 *@return: java.lang.String  产品id
	 */
	@Column(name ="PRODUCT_ID",nullable=false,length=36)
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
	 *@return: java.lang.String  订单id
	 */
	@Column(name ="CONTRACT_ID",nullable=false,length=36)
	public java.lang.String getContractid(){
		return this.contractid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单id
	 */
	public void setContractid(java.lang.String contractid){
		this.contractid = contractid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="PRODUCT",nullable=true,length=36)
	public java.lang.String getProduct(){
		return this.product;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setProduct(java.lang.String product){
		this.product = product;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单名称
	 */
	@Column(name ="CONTRACTNAME",nullable=true,length=36)
	public java.lang.String getContractname(){
		return this.contractname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单名称
	 */
	public void setContractname(java.lang.String contractname){
		this.contractname = contractname;
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
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  单价
	 */
	@Column(name ="UNITPRICE",nullable=true,scale=2,length=8)
	public java.lang.Double getUnitprice(){
		return this.unitprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  单价
	 */
	public void setUnitprice(java.lang.Double unitprice){
		this.unitprice = unitprice;
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
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  折扣
	 */
	@Column(name ="AGIO",nullable=true,scale=2,length=8)
	public java.lang.Double getAgio(){
		return this.agio;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  折扣
	 */
	public void setAgio(java.lang.Double agio){
		this.agio = agio;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATEDATE",nullable=true,length=12)
	public java.util.Date getCreatedate(){
		return this.createdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreatedate(java.util.Date createdate){
		this.createdate = createdate;
	}
}

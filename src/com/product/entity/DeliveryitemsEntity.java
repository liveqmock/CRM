package com.product.entity;

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
 * @date 2015-02-11 22:17:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_deliveryitems", schema = "")
@SuppressWarnings("serial")
public class DeliveryitemsEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**发货单id*/
	private java.lang.String deliveryid;
	/**发货单编号*/
	private java.lang.String deliveryno;
	/**产品id*/
	private java.lang.String productid;
	/**产品名称*/
	private java.lang.String productname;
	/**数量*/
	private java.lang.Integer amount;
	/**单价*/
	private java.lang.Double price;
	/**发货数量*/
	private java.lang.Integer deliverynum;
	/**描述*/
	private java.lang.String remark;
	
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
	@Column(name ="DELIVERYID",nullable=false,length=36)
	public java.lang.String getDeliveryid(){
		return this.deliveryid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货单id
	 */
	public void setDeliveryid(java.lang.String deliveryid){
		this.deliveryid = deliveryid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货单编号
	 */
	@Column(name ="DELIVERYNO",nullable=true,length=36)
	public java.lang.String getDeliveryno(){
		return this.deliveryno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货单编号
	 */
	public void setDeliveryno(java.lang.String deliveryno){
		this.deliveryno = deliveryno;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数量
	 */
	@Column(name ="AMOUNT",nullable=true,length=12)
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发货数量
	 */
	@Column(name ="DELIVERYNUM",nullable=true,length=12)
	public java.lang.Integer getDeliverynum(){
		return this.deliverynum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发货数量
	 */
	public void setDeliverynum(java.lang.Integer deliverynum){
		this.deliverynum = deliverynum;
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
}

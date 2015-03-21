package com.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 知识库
 * @author onlineGenerator
 * @date 2015-02-11 22:46:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_knowledge", schema = "")
@SuppressWarnings("serial")
public class BussKnowledgeEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**名称*/
	private java.lang.String name;
	/**类型*/
	private java.lang.String type;
	/**内容*/
	private java.lang.String conten;
	/**创建时间*/
	private java.util.Date creatdate;
	/**创建人*/
	private java.lang.String creatby;
	
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
	 *@return: java.lang.String  名称
	 */
	@Column(name ="NAME",nullable=true,length=36)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTEN",nullable=true,length=5556)
	public java.lang.String getConten(){
		return this.conten;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setConten(java.lang.String conten){
		this.conten = conten;
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
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATBY",nullable=true,length=12)
	public java.lang.String getCreatby(){
		return this.creatby;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreatby(java.lang.String creatby){
		this.creatby = creatby;
	}
}

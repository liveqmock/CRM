package com.buss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 历史邮件
 * @author onlineGenerator
 * @date 2015-01-18 10:29:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "com_buss_mail", schema = "")
@SuppressWarnings("serial")
public class ComBussMailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**发件人*/
	private java.lang.String fromname;
	/**主题*/
	private java.lang.String title;
	/**内容*/
	private java.lang.String content;
	/**发送日期*/
	private java.util.Date createtime;
	/**收件人*/
	private java.lang.String toname;
	/**抄送*/
	private java.lang.String copyto;
	/**附件*/
	private java.lang.String accessory;
	
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
	 *@return: java.lang.String  发件人
	 */
	@Column(name ="FROMNAME",nullable=true,length=100)
	public java.lang.String getFromname(){
		return this.fromname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发件人
	 */
	public void setFromname(java.lang.String fromname){
		this.fromname = fromname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主题
	 */
	@Column(name ="TITLE",nullable=true,length=100)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=500)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发送日期
	 */
	@Column(name ="CREATETIME",nullable=true,length=100)
	public java.util.Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发送日期
	 */
	public void setCreatetime(java.util.Date createtime){
		this.createtime = createtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收件人
	 */
	@Column(name ="TONAME",nullable=true,length=100)
	public java.lang.String getToname(){
		return this.toname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收件人
	 */
	public void setToname(java.lang.String toname){
		this.toname = toname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  抄送
	 */
	@Column(name ="COPYTO",nullable=true,length=500)
	public java.lang.String getCopyto(){
		return this.copyto;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  抄送
	 */
	public void setCopyto(java.lang.String copyto){
		this.copyto = copyto;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */
	@Column(name ="ACCESSORY",nullable=true,length=100)
	public java.lang.String getAccessory(){
		return this.accessory;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setAccessory(java.lang.String accessory){
		this.accessory = accessory;
	}
}

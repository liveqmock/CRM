package com.buss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 附件
 * @author onlineGenerator
 * @date 2015-02-11 22:34:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "buss_attachment", schema = "")
@SuppressWarnings("serial")
public class BussAttachmentEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**客户id*/
	private java.lang.String accountid;
	/**客户姓名*/
	private java.lang.String accontname;
	/**工单id*/
	private java.lang.String serviceid;
	/**工单编号*/
	private java.lang.String serviceno;
	/**名称*/
	private java.lang.String name;
	/**文件名*/
	private java.lang.String filename;
	/**创建时间*/
	private java.util.Date createdate;
	/**创建人*/
	private java.lang.String creatperson;
	
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
	 *@return: java.lang.String  客户id
	 */
	@Column(name ="ACCOUNTID",nullable=false,length=36)
	public java.lang.String getAccountid(){
		return this.accountid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户id
	 */
	public void setAccountid(java.lang.String accountid){
		this.accountid = accountid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户姓名
	 */
	@Column(name ="ACCONTNAME",nullable=true,length=24)
	public java.lang.String getAccontname(){
		return this.accontname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户姓名
	 */
	public void setAccontname(java.lang.String accontname){
		this.accontname = accontname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工单id
	 */
	@Column(name ="SERVICEID",nullable=false,length=36)
	public java.lang.String getServiceid(){
		return this.serviceid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工单id
	 */
	public void setServiceid(java.lang.String serviceid){
		this.serviceid = serviceid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工单编号
	 */
	@Column(name ="SERVICENO",nullable=true,length=36)
	public java.lang.String getServiceno(){
		return this.serviceno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工单编号
	 */
	public void setServiceno(java.lang.String serviceno){
		this.serviceno = serviceno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	@Column(name ="NAME",nullable=true,length=24)
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
	 *@return: java.lang.String  文件名
	 */
	@Column(name ="FILENAME",nullable=true,length=36)
	public java.lang.String getFilename(){
		return this.filename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件名
	 */
	public void setFilename(java.lang.String filename){
		this.filename = filename;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATPERSON",nullable=true,length=12)
	public java.lang.String getCreatperson(){
		return this.creatperson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreatperson(java.lang.String creatperson){
		this.creatperson = creatperson;
	}
}

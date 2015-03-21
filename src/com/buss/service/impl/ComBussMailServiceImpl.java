package com.buss.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.buss.entity.ComBussMailEntity;
import com.buss.service.ComBussMailServiceI;

import java.util.UUID;
import java.io.Serializable;

@Service("comBussMailService")
@Transactional
public class ComBussMailServiceImpl extends CommonServiceImpl implements ComBussMailServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ComBussMailEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((ComBussMailEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((ComBussMailEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ComBussMailEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ComBussMailEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ComBussMailEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ComBussMailEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{fromname}",String.valueOf(t.getFromname()));
 		sql  = sql.replace("#{title}",String.valueOf(t.getTitle()));
 		sql  = sql.replace("#{content}",String.valueOf(t.getContent()));
 		sql  = sql.replace("#{createtime}",String.valueOf(t.getCreatetime()));
 		sql  = sql.replace("#{toname}",String.valueOf(t.getToname()));
 		sql  = sql.replace("#{copyto}",String.valueOf(t.getCopyto()));
 		sql  = sql.replace("#{accessory}",String.valueOf(t.getAccessory()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}
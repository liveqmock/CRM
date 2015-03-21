package com.buss.service.impl;

import java.util.List;
import java.util.UUID;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.entity.BussActivityEntity;
import com.buss.entity.BussLeadEntity;
import com.buss.service.BussLeadServiceI;
@Service("bussLeadService")
@Transactional
public class BussLeadServiceImpl extends CommonServiceImpl implements BussLeadServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((BussLeadEntity)entity);
 	}
	
	public void addMain(BussLeadEntity bussLead,
	        List<BussActivityEntity> bussActivityList){
			//保存主信息
			this.save(bussLead);
		
			/**保存-活动跟进*/
			for(BussActivityEntity bussActivity:bussActivityList){				
				//外键设置
				bussActivity.setLeadid(bussLead.getId());
				this.save(bussActivity);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(bussLead);
	}

	
	public void updateMain(BussLeadEntity bussLead,
	        List<BussActivityEntity> bussActivityList) {
		//保存主表信息
		this.saveOrUpdate(bussLead);
		//===================================================================================
		//获取参数
		Object id0 = bussLead.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-活动跟进
	    String hql0 = "from BussActivityEntity where 1 = 1   AND lEADID = ? ";
	    List<BussActivityEntity> bussActivityOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-活动跟进
		for(BussActivityEntity oldE:bussActivityOldList){
			boolean isUpdate = false;
				for(BussActivityEntity sendE:bussActivityList){
					//需要更新的明细数据-活动跟进
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-活动跟进
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-活动跟进
			for(BussActivityEntity bussActivity:bussActivityList){
				if(oConvertUtils.isEmpty(bussActivity.getId())){
					//外键设置
					bussActivity.setLeadid(bussLead.getId());
					this.save(bussActivity);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(bussLead);
	}

	
	public void delMain(BussLeadEntity bussLead) {
		//删除主表信息
		this.delete(bussLead);
		//===================================================================================
		//获取参数
		Object id0 = bussLead.getId();
		//===================================================================================
		//删除-活动跟进
	    String hql0 = "from BussActivityEntity where 1 = 1  AND lEADID = ? ";
	    List<BussActivityEntity> bussActivityOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(bussActivityOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BussLeadEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BussLeadEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BussLeadEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,BussLeadEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{mobile}",String.valueOf(t.getMobile()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{source}",String.valueOf(t.getSource()));
 		sql  = sql.replace("#{level}",String.valueOf(t.getLevel()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{leadstatus}",String.valueOf(t.getLeadstatus()));
 		sql  = sql.replace("#{owner}",String.valueOf(t.getOwner()));
 		sql  = sql.replace("#{distribution}",String.valueOf(t.getDistribution()));
 		sql  = sql.replace("#{distributiondate}",String.valueOf(t.getDistributiondate()));
 		sql  = sql.replace("#{distributionstatus}",String.valueOf(t.getDistributionstatus()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}
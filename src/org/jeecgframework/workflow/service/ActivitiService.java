package org.jeecgframework.workflow.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.workflow.model.activiti.ActivitiCom;
import org.jeecgframework.workflow.model.activiti.ProcessHandle;
import org.jeecgframework.workflow.pojo.base.TPProcessnode;
import org.jeecgframework.workflow.pojo.base.TSBusConfig;
import org.jeecgframework.workflow.pojo.base.TSPrjstatus;
import org.springframework.transaction.annotation.Transactional;


public interface ActivitiService extends CommonService {
	/**
	 * synToActiviti 同步用户到Activiti数据库
	 */
	public void save(TSUser user, String roleIds, Short synToActiviti);

	/**
	 * synToActiviti 同步用户到Activiti数据库
	 * @param userId
	 */
	public void delete(TSUser user);
	/**
	 * 启动流程
	 */
	public ProcessInstance startWorkflow(Object entity,String businessKey,
			Map<String, Object> variables,TSBusConfig tsBusbase);

	/**
	 * 查询待办任务	
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 */
	public List findTodoTasks(String userId,List<TSBusConfig> tsBusConfigs);

	/**
	 * 获取流程图跟踪信息
	 * 
	 * @param request
	 * @return
	 */
	public List<Map<String, Object>> traceProcess(String processInstanceId)
			throws Exception;

	/**
	 * 获取跟踪信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public ActivityImpl getProcessMap(String processInstanceId);
	public List<String> highLight(String processInstanceId);
	/**
	 * 获取业务ID
	 * 
	 * @param taskId
	 * @return
	 */
	public String getBusinessKeyByTask(Task task);
	/**
	 * 完成任务
	 */
	public ActivitiCom complete(String taskId, Map<String, Object> map);

	/**
	 * 获取业务Id
	 */
	public String getBusinessKeyByTask(String taskId);
	/**
	 *根据流程KEY和当前流程环节标示获取当前环节对象
	 */
	public TPProcessnode getTPProcessnode(String taskDefinitionKey,String processkey);
	/**
	 * 获取全部部署流程
	 */
	@Transactional(readOnly = true)
	public List processDefinitionList();
	/**
	 * 根据taskId获取task对象
	 * @param taskId
	 * @return
	 */
	public Task getTask(String taskId);
	/**
	 * 查询流程定义对象
	 * 
	 * @param processDefinitionId
	 *            流程定义ID
	 * @return
	 */
	public ProcessDefinition getProcessDefinition(String processDefinitionId);
	/**
	 * 根据taskId封装ProcessHandle对象
	 * @param taskId
	 * @return
	 */
	public ProcessHandle getProcessHandle(String taskId);
	/**
	 * 根据业务ID获取HistoricProcessInstance对象
	 * 
	 * @param businessKey
	 * @return
	 */
	public HistoricProcessInstance getHiProcInstByBusKey(String businessKey);
	/**
	 * 根据父流程业务ID更新子流程的业务ID
	 * 
	 * @param parBusKey
	 *            父流程业务ID
	 * @param subBusKey
	 *            子流程业务ID
	 * @return
	 */
	public void updateHiProcInstBusKey(String parBusKey, String subBusKey);
	
	
	/**
	 * 根据角色编码和当前审批状态值获取审批状态
	 */
	public TSPrjstatus getTBPrjstatusByCode(String prjstate, String rolecode);
	/**
	 * 根据流程编码和业务类名获取业务配置类
	 */
	public TSBusConfig getTSBusConfig(Class classname, String processkey);
	
	/**
	 * 注意会把整个表数据删除
	 * @param <T>
	 */
	public <T> void batchDelete(final Class<T> entityClass);
	/**
	 * 查询待办任务-只查询用户自己的
	 * @param userId
	 * @param tsBusConfigs
	 * @param request 
	 * @return
	 */
	public List findPriTodoTasks(String userId,  HttpServletRequest request);
	/**
	 * 查询组待办任务
	 * @param userName
	 * @param tsBusConfigs
	 * @param request 
	 * @return
	 */
	public List findGroupTodoTasks(List<TSRoleUser> roles,HttpServletRequest request);
	/**
	 * 查询历史任务
	 * @param userName
	 * @param request 
	 * @return
	 */
	public List findHistoryTasks(String userName, HttpServletRequest request);
	/**
	 * 查询待办任务-只查询用户自己的 (统计总数)
	 * @param userName
	 * @param tsBusConfigs
	 * @param request
	 * @return
	 */
	public Long countPriTodaoTask(String userName,HttpServletRequest request);
	/**
	 * 查询组待办任务 (统计总数)
	 * @param roles
	 * @param tsBusConfigs
	 * @param request
	 * @return
	 */
	public Long countGroupTodoTasks(List<TSRoleUser> roles, HttpServletRequest request);
	/**
	 * 查询历史任务(统计总数)
	 * @param userName
	 * @param request
	 * @return
	 */
	public Long countHistoryTasks(String userName, HttpServletRequest request);
	
}

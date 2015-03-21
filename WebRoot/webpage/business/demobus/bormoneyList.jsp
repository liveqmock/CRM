<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:datagrid name="bormoney" title="借款列表" actionUrl="busController.do?bormoneyGrid" idField="id">
 <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
 <t:dgCol title="借款人" field="TSUser_userName"></t:dgCol>
 <t:dgCol title="借款金额" field="bormoney"></t:dgCol>
 <t:dgCol title="申请时间" field="createtime" formatter="yyyy-MM-dd"></t:dgCol>
 <t:dgCol title="业务配置ID" field="TSBusConfig_id" hidden="false"></t:dgCol>
 <t:dgCol title="状态" field="TSPrjstatus_description"></t:dgCol>
 <t:dgCol hidden="false" title="状态ID(该字段隐藏)" field="TSPrjstatus_code"></t:dgCol>
 <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
 <t:dgConfOpt exp="TSPrjstatus_code#eq#new" url="activitiController.do?startBusProcess&businessKey={id}&busconfigKey={TSBusConfig_id}" message="确认完毕,提交申请?" title="办理"></t:dgConfOpt>
 <t:dgFunOpt exp="TSPrjstatus_code#eq#doing" funname="progress(id)" title="项目进度"></t:dgFunOpt>
 <t:dgDelOpt exp="TSPrjstatus_code#eq#new" url="busController.do?delBormoney&id={id}" title="删除"></t:dgDelOpt>
</t:datagrid>
<div id="bormoneytb" style="padding: 3px; height: 25px">
 <div style="float:left;">
  <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="add('借款申请','busController.do?aorubormoney','bormoney');">借款申请</a>
  <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="update('编辑','busController.do?aorubormoney','bormoney')">编辑</a>
 </div>
 <div align="right">
   申请时间:
  <input class="Wdate" type="text" name="createtime" id="createtime" onFocus="WdatePicker({isShowClear:false,readOnly:true})"/>
   <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="bormoneysearch()">查询</a>
 </div>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="bussContractList" checkbox="true" fitColumns="false" title="订单" actionUrl="bussContractController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="订单编号"  field="no"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  hidden="true" query="true" queryMode="single" dictionary="ctype" width="120"></t:dgCol>
   <t:dgCol title="订单名称"  field="name"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status"  hidden="true" query="true" queryMode="single" dictionary="cstatus" width="120"></t:dgCol>
   <t:dgCol title="数量"  field="quantily"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="价格"  field="price"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="总价"  field="total"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="accountname"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="地址"  field="address"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="描述"  field="remark"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="负责人"  field="owner"  hidden="true" query="true" queryMode="single" dictionary="t_s_base_user,id,realname" width="120"></t:dgCol>
   <t:dgCol title="已收款"  field="collect"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="未收款"  field="uncollect"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户id"  field="accountid"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="ceatedate" formatter="yyyy-MM-dd hh:mm:ss" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="bussContractController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="bussContractController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="bussContractController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="bussContractController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="bussContractController.do?goUpdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/contract/bussContractList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#bussContractListtb").find("input[name='ceatedate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>
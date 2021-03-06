<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid fitColumns="false" checkbox="true" name="bussInvoiceList" title="发票" actionUrl="bussInvoiceController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="订单id"  field="contractId"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发票编号"  field="no"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  hidden="true" query="true" queryMode="single" dictionary="itype" width="120"></t:dgCol>
   <t:dgCol title="发票名称"  field="name"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发票金额"  field="quote"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="描述"  field="remark"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status"  hidden="true" query="true" queryMode="single" dictionary="istatus" width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="accountname"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户id"  field="accountid"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="开票人"  field="createby"  hidden="true"  queryMode="single" dictionary="t_s_base_user,id,realname" width="120"></t:dgCol>
   <t:dgCol title="开票时间"  field="createdate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="bussInvoiceController.do?doDel&id={id}" />
 <%--   <t:dgToolBar title="录入" icon="icon-add" url="bussInvoiceController.do?goAdd" funname="add" height="450"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="bussInvoiceController.do?goUpdate" funname="update" height="450"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="bussInvoiceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="bussInvoiceController.do?goUpdate" funname="detail" height="450"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/invoice/bussInvoiceList.js"></script>		
 <script type="text/javascript">
  $(document).ready(function(){
 		//给时间控件加上样式
 			$("#bussInvoiceListtb").find("input[name='createdate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>
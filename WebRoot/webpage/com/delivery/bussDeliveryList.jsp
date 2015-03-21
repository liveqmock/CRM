<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="bussDeliveryList" checkbox="true" fitColumns="false" title="发货单" actionUrl="bussDeliveryController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="订单id"  field="contractid"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="订单名称"  field="contractname"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户id"  field="accountid"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="accountname"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="creatdate" formatter="yyyy-MM-dd hh:mm:ss" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发货人"  field="owner"  hidden="true" query="true" queryMode="single" dictionary="t_s_base_user,id,realname" width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status"  hidden="true" query="true" queryMode="single" dictionary="dstatus" width="120"></t:dgCol>
   <t:dgCol title="地址"  field="address"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发货数量"  field="deliverytotal"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发货时间"  field="deliverydate" formatter="yyyy-MM-dd" hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="描述"  field="remark"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="订单编号"  field="contractno"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发货单编号"  field="no"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <%-- <t:dgDelOpt title="删除" url="bussDeliveryController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="bussDeliveryController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="bussDeliveryController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="bussDeliveryController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="bussDeliveryController.do?goUpdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/delivery/bussDeliveryList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#bussDeliveryListtb").find("input[name='creatdate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#bussDeliveryListtb").find("input[name='deliverydate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid fitColumns="false" checkbox="true" name="productList" title="产品" actionUrl="productController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="产品名称"  field="name"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="no"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="标准价格"  field="price"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="实际价格"  field="actualprice"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="描述"  field="remark"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计价单位"  field="unit"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="库存"  field="stock"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="creatdate" formatter="yyyy-MM-dd hh:mm:ss" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管理人员"  field="owner"  hidden="true"  queryMode="single" dictionary="t_s_base_user,id,realname" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="productController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="productController.do?goAdd" funname="add" height="450"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="productController.do?goUpdate" funname="update" height="450"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="productController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="productController.do?goUpdate" funname="detail" height="450"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/product/productList.js"></script>		
 <script type="text/javascript">
  $(document).ready(function(){
 		//给时间控件加上样式
 			$("#productListtb").find("input[name='creatdate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>
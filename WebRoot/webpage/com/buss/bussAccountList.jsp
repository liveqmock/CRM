<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid fitColumns="false" checkbox="true" name="bussAccountList" title="客户管理" actionUrl="bussAccountController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="name"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="电话号码"  field="phone"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  hidden="false"  queryMode="single" dictionary="sex" width="120"></t:dgCol>
   <t:dgCol title="地址"  field="address"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="手机"  field="mobile"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户意向"  field="intention"  hidden="true" query="true" queryMode="single" dictionary="intention" width="120"></t:dgCol>
   <t:dgCol title="省份"  field="provinces"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户类型"  field="type"  hidden="true" query="true" queryMode="single" dictionary="type" width="120"></t:dgCol>
   <t:dgCol title="客户级别"  field="level"  hidden="true" query="true" queryMode="single" dictionary="level" width="120"></t:dgCol>
   <t:dgCol title="客户编码"  field="no"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户来源"  field="source"  hidden="true" query="true" queryMode="single" dictionary="source" width="120"></t:dgCol>
   <t:dgCol title="身份证"  field="identity"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="图片"  field="photo"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="描述"  field="remark"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="负责人"  field="owner"  hidden="true" query="true" queryMode="single" dictionary="t_s_base_user,id,realname" width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="修改人"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="修改时间"  field="updateDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="bussAccountController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="bussAccountController.do?goAdd" funname="add" height="450"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="bussAccountController.do?goUpdate" funname="update" height="450"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="bussAccountController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="bussAccountController.do?goUpdate" funname="detail" height="450"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
   <t:dgToolBar title="发送短信" icon="icon-msg" url="bussAccountController.do?goSendMsg"  funname="goSendMsg"></t:dgToolBar>
   <t:dgToolBar title="发送邮件" icon="icon-mail" url="bussAccountController.do?goSendMail" funname="goSendMail"></t:dgToolBar>
   <t:dgToolBar title="客户共享" icon="icon-add" url="bussAccountController.do?accountShared" funname="accountShared"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/bussAccountList.js"></script>		
 <script type="text/javascript">
  $(document).ready(function(){
 		//给时间控件加上样式
 });
  
//导入
  function ImportXls() {
  	openuploadwin('Excel导入', 'bussAccountController.do?upload', "bussAccountList");
  }

  //导出
  function ExportXls() {
  	JeecgExcelExport("bussAccountController.do?exportXls","bussAccountList");
  }

  //模板下载
  function ExportXlsByT() {
  	JeecgExcelExport("bussAccountController.do?exportXlsByT","bussAccountList");
  }

  //发送短信
  function goSendMsg(title,url, id,width,height){
  		gridname=id;
  		var rows = $('#'+id).datagrid('getSelections');
  		var ids = [];
  		var names = [];
  		if(rows.length > 0){
  			for ( var i = 0; i < rows.length; i++) {
  				ids.push(rows[i].id);
  				names.push(rows[i].cusName);
  			}
  		url=url+"&ids="+ids.join(',')+"&names="+names.join(',');
   		createwindow(title,url,300,200);
  		}else{
  			tip("请至少选择一行数据");
  		}
  		
  }

  //发送邮件
  function goSendMail(title,url, id,width,height){
  		gridname=id;
  		var rows = $('#'+id).datagrid('getSelections');
  		var ids = [];
  		var names = [];
  		if(rows.length > 0){
  			for ( var i = 0; i < rows.length; i++) {
  				ids.push(rows[i].id);
  				names.push(rows[i].cusName);
  			}
  		url=url+"&ids="+ids.join(',')+"&names="+names.join(',');
  		createwindow(title,url,width,height);
  		}else{
  			tip("请至少选择一行数据");
  		}
  }
  /**
   * 客户共享
   */
  function accountShared(title,url, id,width,height){
  	gridname=id;
  	var rows = $('#'+id).datagrid('getSelections');
  	var ids = [];
  	var names = [];
  	if(rows.length > 0){
  		for ( var i = 0; i < rows.length; i++) {
  			ids.push(rows[i].id);
  			names.push(rows[i].cusName);
  		}
  	url=url+"&ids="+ids.join(',');
  		createwindow(title,url,500,340);
  	}else{
  		tip("请至少选择一行数据");
  	}
  }

 </script>
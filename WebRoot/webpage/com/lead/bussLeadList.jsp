<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid fitColumns="false" checkbox="true" name="bussLeadList" title="线索" actionUrl="bussLeadController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="手机"  field="mobile"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="固话"  field="phone"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="来源"  field="source"  hidden="true" query="true" queryMode="single" dictionary="lsource" width="120"></t:dgCol>
   <t:dgCol title="意向级别"  field="level"  hidden="true" query="true" queryMode="single" dictionary="level" width="120"></t:dgCol>
   <t:dgCol title="描述"  field="remark"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="leadstatus"  hidden="true" query="true" queryMode="single" dictionary="lstatus" width="120"></t:dgCol>
   <t:dgCol title="负责人"  field="owner"  hidden="true" query="true" queryMode="single" dictionary="t_s_base_user,id,realname" width="120"></t:dgCol>
   <t:dgCol title="分配人"  field="distribution"  hidden="true"  queryMode="single" dictionary="t_s_base_user,id,realname" width="120"></t:dgCol>
   <t:dgCol title="分配时间"  field="distributiondate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="分配状态"  field="distributionstatus"  hidden="true"  queryMode="single" dictionary="assigstatu" width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate" formatter="yyyy-MM-dd hh:mm:ss" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="修改人"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="修改时间"  field="updateDate" formatter="yyyy-MM-dd hh:mm:ss" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="bussLeadController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="bussLeadController.do?goAdd" funname="add" height="450"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="bussLeadController.do?goUpdate" funname="update" height="450"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="bussLeadController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="bussLeadController.do?goUpdate" funname="detail" height="450"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
   <t:dgToolBar title="线索共享" icon="icon-add" url="bussLeadController.do?leadShared" funname="leadShared"></t:dgToolBar>
   <t:dgToolBar title="线索转化" icon="icon-add" url="bussLeadController.do?leadTranslate" funname="leadTranslate"></t:dgToolBar>
   <t:dgToolBar title="线索去重" icon="icon-add" url="bussLeadController.do?delRepeat" funname="delRepeat"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/lead/bussLeadList.js"></script>		
 <script type="text/javascript">
  $(document).ready(function(){
 		//给时间控件加上样式
 			$("#bussLeadListtb").find("input[name='distributiondate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#bussLeadListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#bussLeadListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
  
  
//导入
  function ImportXls() {
  	openuploadwin('Excel导入', 'bussLeadController.do?upload', "bussLeadList");
  }

  //导出
  function ExportXls() {
  	JeecgExcelExport("bussLeadController.do?exportXls","bussLeadList");
  }

  //模板下载
  function ExportXlsByT() {
  	JeecgExcelExport("bussLeadController.do?exportXlsByT","bussLeadList");
  }

  
  /**
   * 线索共享
   */
  function leadShared(title,url, id,width,height){
  	gridname=id;
  	var rows = $('#'+id).datagrid('getSelections');
  	var ids = [];
  	var names = [];
  	if(rows.length > 0){
  		for ( var i = 0; i < rows.length; i++) {
  			ids.push(rows[i].id);  			
  		}
  	url=url+"&ids="+ids.join(',');
  		createwindow(title,url,500,340);
  	}else{
  		tip("请至少选择一行数据");
  	}
  }
  /**
   * 线索去重
   */
  function leadTranslate(title,url, id,width,height){
	  alert("is ok ");
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
  
  /**
   * 线索转化
   */
  function leadTranslate(title,url, id,width,height){
  	gridname=id;
  	var rows = $('#'+id).datagrid('getSelections');
  	var ids = [];
  	var status ;
  	if(rows.length > 0){
  		for ( var i = 0; i < rows.length; i++) {
  			status = rows[i].leadstatus;
			if(status==1){//线索为活动状态才能转化
	  			ids.push(rows[i].id);	  			
			}
  		}
  		if(ids.length>0){
  			url=url+"&ids="+ids.join(',');  		 
  	  		ajaxSubForm(url);
  		}else{
	  		tip("无活动状态线索");  			
  		}  		
  	}else{
  		tip("请至少选择一行数据");
  	}
  }
  
  

 </script>
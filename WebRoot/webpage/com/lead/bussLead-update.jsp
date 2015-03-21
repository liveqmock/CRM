<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>线索</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="bussLeadController.do?doUpdate">
					<input id="id" name="id" type="hidden" value="${bussLeadPage.id }">
					<input id="createName" name="createName" type="hidden" value="${bussLeadPage.createName }">
					<input id="createDate" name="createDate" type="hidden" value="${bussLeadPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${bussLeadPage.updateName }">
					<input id="updateDate" name="updateDate" type="hidden" value="${bussLeadPage.updateDate }">
					<input id="delStatus" name="delStatus" type="hidden" value="${bussLeadPage.delStatus }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">姓名:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${bussLeadPage.name}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">姓名</label>
			</td>
			<td align="right">
				<label class="Validform_label">手机:</label>
			</td>
			<td class="value">
		     	 <input id="mobile" name="mobile" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${bussLeadPage.mobile}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">手机</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">固话:</label>
			</td>
			<td class="value">
		     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${bussLeadPage.phone}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">固话</label>
			</td>
			<td align="right">
				<label class="Validform_label">来源:</label>
			</td>
			<td class="value">
					<t:dictSelect field="source" type="list"
						typeGroupCode="lsource" defaultVal="${bussLeadPage.source}" hasLabel="false"  title="来源"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">来源</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">意向级别:</label>
			</td>
			<td class="value">
					<t:dictSelect field="level" type="list"
						typeGroupCode="level" defaultVal="${bussLeadPage.level}" hasLabel="false"  title="意向级别"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">意向级别</label>
			</td>
			
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="leadstatus" type="list"
						typeGroupCode="lstatus" defaultVal="${bussLeadPage.leadstatus}" hasLabel="false"  title="状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">状态</label>
			</td>
			<td align="right">
				<label class="Validform_label">负责人:</label>
			</td>
			<td class="value">
					<t:dictSelect field="owner" type="list"
						dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${bussLeadPage.owner}" hasLabel="false"  title="负责人"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">负责人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">分配人:</label>
			</td>
			<td class="value">
					<t:dictSelect field="distribution" type="list"
						dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${bussLeadPage.distribution}" hasLabel="false"  title="分配人"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">分配人</label>
			</td>
			<td align="right">
				<label class="Validform_label">分配时间:</label>
			</td>
			<td class="value">
					  <input id="distributiondate" name="distributiondate" type="text" style="width: 150px" 
		      						class="Wdate" onClick="WdatePicker()"
					                
					                value='<fmt:formatDate value='${bussLeadPage.distributiondate}' type="date" pattern="yyyy-MM-dd"/>'>   
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">分配时间</label>
			</td>
		</tr>
		<tr>
			
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">描述:</label>
			</td>
			<td class="value" colspan="3">
				 <textarea id="remark" name="remark" style="width: 450px;height: 60px">${bussLeadPage.remark}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">描述</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="bussLeadController.do?bussActivityList&id=${bussLeadPage.id}" icon="icon-search" title="活动跟进" id="bussActivity"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			 <!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_bussActivity_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					      	<input name="bussActivityList[#index#].date" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">活动时间</label>
				  </td>
				  <td align="left">
					  	<input name="bussActivityList[#index#].name" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">名称</label>
				  </td>
				  <td align="left">
					       	<input name="bussActivityList[#index#].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">内容描述</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussActivityList[#index#].people" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="" hasLabel="false"  title="执行人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">执行人</label>
				  </td>
				  <td align="left">
					      	<input name="bussActivityList[#index#].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				  </td>
				  <td align="left">
					  	<input name="bussActivityList[#index#].accountname" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户姓名</label>
				  </td>
				  <td align="left">
					  	<input name="bussActivityList[#index#].leadname" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">线索姓名</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussActivityList[#index#].status" type="list"
										typeGroupCode="astatus" defaultVal="" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/lead/bussLead.js"></script>	
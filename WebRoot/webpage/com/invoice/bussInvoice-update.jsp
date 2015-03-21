<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>发票</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="bussInvoiceController.do?doUpdate">
					<input id="id" name="id" type="hidden" value="${bussInvoicePage.id }">
					<input id="contractid" name="contractid" type="hidden" value="${bussInvoicePage.contractid }">
					<input id="accountid" name="accountid" type="hidden" value="${bussInvoicePage.accountid }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">发票编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${bussInvoicePage.no}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发票编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">类型:</label>
			</td>
			<td class="value">
					<t:dictSelect field="type" type="list"
						typeGroupCode="itype" defaultVal="${bussInvoicePage.type}" hasLabel="false"  title="类型"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">类型</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">发票名称:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${bussInvoicePage.name}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发票名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">发票金额:</label>
			</td>
			<td class="value">
		     	 <input id="quote" name="quote" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${bussInvoicePage.quote}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发票金额</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">描述:</label>
			</td>
			<td class="value">
				 <textarea id="remark" name="remark">${bussInvoicePage.remark}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">描述</label>
			</td>
			<td align="right">
				<label class="Validform_label">状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="status" type="list"
						typeGroupCode="istatus" defaultVal="${bussInvoicePage.status}" hasLabel="false"  title="状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">客户姓名:</label>
			</td>
			<td class="value">
		     	 <input id="accountname" name="accountname" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${bussInvoicePage.accountname}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户姓名</label>
			</td>
			<td align="right">
				<label class="Validform_label">开票人:</label>
			</td>
			<td class="value">
					<t:dictSelect field="createby" type="list"
						dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${bussInvoicePage.createby}" hasLabel="false"  title="开票人"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">开票人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">开票时间:</label>
			</td>
			<td class="value">
					  <input id="createdate" name="createdate" type="text" style="width: 150px" 
		      						class="Wdate" onClick="WdatePicker()"
					                
					                value='<fmt:formatDate value='${bussInvoicePage.createdate}' type="date" pattern="yyyy-MM-dd"/>'>   
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">开票时间</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="bussInvoiceController.do?bussDeliveryitemList&id=${bussInvoicePage.id}" icon="icon-search" title="发票明细" id="bussDeliveryitem"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_bussDeliveryitem_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[#index#].productname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">产品名称</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[#index#].unit" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">计价单位</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[#index#].amount" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[#index#].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[#index#].subtotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">小计</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[#index#].invoicename" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发票名称</label>
				  </td>
				  <td align="left">
					       	<input name="bussDeliveryitemList[#index#].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
					      	<input name="bussDeliveryitemList[#index#].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/invoice/bussInvoice.js"></script>	
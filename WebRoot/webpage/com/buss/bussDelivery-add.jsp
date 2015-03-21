<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>发货单</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="bussDeliveryController.do?doAdd">
					<input id="id" name="id" type="hidden" value="${bussDeliveryPage.id }">
					<input id="contractid" name="contractid" type="hidden" value="${bussDeliveryPage.contractid }">
					<input id="accountid" name="accountid" type="hidden" value="${bussDeliveryPage.accountid }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">订单名称:</label>
			</td>
			<td class="value">
		     	 <input id="contractname" name="contractname" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">订单名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户名称:</label>
			</td>
			<td class="value">
		     	 <input id="accountname" name="accountname" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">创建时间:</label>
			</td>
			<td class="value">
					  <input id="creatdate" name="creatdate" type="text" style="width: 150px" 
		      						 class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
					                
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">创建时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">发货人:</label>
			</td>
			<td class="value">
					<t:dictSelect field="owner" type="list"
						dictTable="t_s_base_user" dictField="id" dictText="realname"  hasLabel="false"  title="发货人"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发货人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="status" type="list"
						typeGroupCode="dstatus"  hasLabel="false"  title="状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">状态</label>
			</td>
			<td align="right">
				<label class="Validform_label">地址:</label>
			</td>
			<td class="value">
		     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">地址</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">发货数量:</label>
			</td>
			<td class="value">
		     	 <input id="deliverytotal" name="deliverytotal" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发货数量</label>
			</td>
			<td align="right">
				<label class="Validform_label">发货时间:</label>
			</td>
			<td class="value">
					  <input id="deliverydate" name="deliverydate" type="text" style="width: 150px" 
		      						class="Wdate" onClick="WdatePicker()"
					                
					               >    
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发货时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">发货单编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">发货单编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">订单编号:</label>
			</td>
			<td class="value">
		     	 <input id="contractno" name="contractno" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">订单编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">描述:</label>
			</td>
			<td class="value" colspan="3">
				 <textarea id="remark" name="remark" rows="6"  style="width: 500px"></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">描述</label>
			</td>
			
		</tr>
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="bussDeliveryController.do?bussDeliveryitemsList&id=${bussDeliveryPage.id}" icon="icon-search" title="发货单明细" id="bussDeliveryitems"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_bussDeliveryitems_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="bussDeliveryitemsList[#index#].deliveryno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货单编号</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryitemsList[#index#].productname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">产品名称</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryitemsList[#index#].amount" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryitemsList[#index#].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryitemsList[#index#].deliverynum" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货数量</label>
				  </td>
				  <td align="left">
					       	<input name="bussDeliveryitemsList[#index#].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/bussDelivery.js"></script>	
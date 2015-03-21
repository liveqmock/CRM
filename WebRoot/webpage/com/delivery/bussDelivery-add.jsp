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
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="bussDeliveryController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${bussDeliveryPage.id }">
					<input id="contractId" name="contractId" type="hidden" value="${bussDeliveryPage.contractId }">
					<input id="accountid" name="accountid" type="hidden" value="${bussDeliveryPage.accountid }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							订单名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="contractname" name="contractname" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							客户名称:
						</label>
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
						<label class="Validform_label">
							创建时间:
						</label>
					</td>
					<td class="value">
							   <input id="creatdate" name="creatdate" type="text" style="width: 150px" 
					      						 class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								                
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							发货人:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="owner" type="list"
									dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${bussDeliveryPage.owner}" hasLabel="false"  title="发货人"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发货人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							状态:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="status" type="list"
									typeGroupCode="dstatus" defaultVal="${bussDeliveryPage.status}" hasLabel="false"  title="状态"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							地址:
						</label>
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
						<label class="Validform_label">
							发货数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="deliverytotal" name="deliverytotal" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发货数量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							发货时间:
						</label>
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
						<label class="Validform_label">
							描述:
						</label>
					</td>
					<td class="value">
						  	 <textarea id="remark" name="remark"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">描述</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							订单编号:
						</label>
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
						<label class="Validform_label">
							发货单编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发货单编号</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/buss/bussDelivery.js"></script>		
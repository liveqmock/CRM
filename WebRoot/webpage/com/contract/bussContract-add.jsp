<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>订单</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="bussContractController.do?doAdd">
					<input id="id" name="id" type="hidden" value="${bussContractPage.id }">
					<input id="accountid" name="accountid" type="hidden" value="${bussContractPage.accountid }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">订单编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">订单编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">类型:</label>
			</td>
			<td class="value">
					<t:dictSelect field="type" type="list"
						typeGroupCode="ctype"  hasLabel="false"  title="类型"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">类型</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">订单名称:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">订单名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="status" type="list"
						typeGroupCode="cstatus"  hasLabel="false"  title="状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">数量:</label>
			</td>
			<td class="value">
		     	 <input id="quantily" name="quantily" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">数量</label>
			</td>
			<td align="right">
				<label class="Validform_label">价格:</label>
			</td>
			<td class="value">
		     	 <input id="price" name="price" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">价格</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">总价:</label>
			</td>
			<td class="value">
		     	 <input id="total" name="total" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">总价</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户姓名:</label>
			</td>
			<td class="value">
		     	 <input id="accountname" name="accountname" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户姓名</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">地址:</label>
			</td>
			<td class="value">
		     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">地址</label>
			</td>
			<td align="right">
				<label class="Validform_label">描述:</label>
			</td>
			<td class="value">
				 <textarea id="remark" name="remark"></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">描述</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">负责人:</label>
			</td>
			<td class="value">
					<t:dictSelect field="owner" type="list"
						dictTable="t_s_base_user" dictField="id" dictText="realname"  hasLabel="false"  title="负责人"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">负责人</label>
			</td>
			<td align="right">
				<label class="Validform_label">已收款:</label>
			</td>
			<td class="value">
		     	 <input id="collect" name="collect" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">已收款</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">未收款:</label>
			</td>
			<td class="value">
		     	 <input id="uncollect" name="uncollect" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">未收款</label>
			</td>
			<td align="right">
				<label class="Validform_label">创建时间:</label>
			</td>
			<td class="value">
					  <input id="ceatedate" name="ceatedate" type="text" style="width: 150px" 
		      						 class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
					                
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">创建时间</label>
			</td>
		</tr>
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="bussContractController.do?bussReceiveList&id=${bussContractPage.id}" icon="icon-search" title="收款" id="bussReceive"></t:tab>
				 <t:tab href="bussContractController.do?bussInvoiceList&id=${bussContractPage.id}" icon="icon-search" title="发票" id="bussInvoice"></t:tab>
				 <t:tab href="bussContractController.do?bussDeliveryList&id=${bussContractPage.id}" icon="icon-search" title="发货单" id="bussDelivery"></t:tab>
				 <t:tab href="bussContractController.do?bussContractitemList&id=${bussContractPage.id}" icon="icon-search" title="订单明细" id="bussContractitem"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_bussReceive_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="bussReceiveList[#index#].contractno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单编号</label>
				  </td>
				  <td align="left">
					  	<input name="bussReceiveList[#index#].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户名称</label>
				  </td>
				  <td align="left">
					  	<input name="bussReceiveList[#index#].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">收款编号</label>
				  </td>
				  <td align="left">
					  	<input name="bussReceiveList[#index#].amount" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">收款金额</label>
				  </td>
				  <td align="left">
					      	<input name="bussReceiveList[#index#].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				  </td>
				  <td align="left">
							<input name="bussReceiveList[#index#].receivedate" maxlength="12" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">收款日期</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussReceiveList[#index#].status" type="list"
										typeGroupCode="istatus" defaultVal="" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussReceiveList[#index#].owner" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="" hasLabel="false"  title="收款人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">收款人</label>
				  </td>
				  <td align="left">
					       	<input name="bussReceiveList[#index#].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_bussInvoice_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="bussInvoiceList[#index#].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发票编号</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussInvoiceList[#index#].type" type="list"
										typeGroupCode="itype" defaultVal="" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
				  </td>
				  <td align="left">
					  	<input name="bussInvoiceList[#index#].name" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发票名称</label>
				  </td>
				  <td align="left">
					  	<input name="bussInvoiceList[#index#].quote" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发票金额</label>
				  </td>
				  <td align="left">
					       	<input name="bussInvoiceList[#index#].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussInvoiceList[#index#].status" type="list"
										typeGroupCode="istatus" defaultVal="" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				  </td>
				  <td align="left">
					  	<input name="bussInvoiceList[#index#].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户姓名</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussInvoiceList[#index#].createby" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="" hasLabel="false"  title="开票人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">开票人</label>
				  </td>
				  <td align="left">
							<input name="bussInvoiceList[#index#].createdate" maxlength="36" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">开票时间</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_bussDelivery_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="bussDeliveryList[#index#].contractname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单名称</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryList[#index#].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户名称</label>
				  </td>
				  <td align="left">
					      	<input name="bussDeliveryList[#index#].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussDeliveryList[#index#].owner" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="" hasLabel="false"  title="发货人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">发货人</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussDeliveryList[#index#].status" type="list"
										typeGroupCode="dstatus" defaultVal="" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryList[#index#].address" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">地址</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryList[#index#].deliverytotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货数量</label>
				  </td>
				  <td align="left">
							<input name="bussDeliveryList[#index#].deliverydate" maxlength="8" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发货时间</label>
				  </td>
				  <td align="left">
					       	<input name="bussDeliveryList[#index#].remark" maxlength="1000" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryList[#index#].contractno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单编号</label>
				  </td>
				  <td align="left">
					  	<input name="bussDeliveryList[#index#].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货单编号</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_bussContractitem_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="bussContractitemList[#index#].product" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">产品名称</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractitemList[#index#].amount" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractitemList[#index#].contractname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单名称</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractitemList[#index#].unit" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">计价单位</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractitemList[#index#].unitprice" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractitemList[#index#].subtotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">小计</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractitemList[#index#].agio" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">折扣</label>
				  </td>
				  <td align="left">
					      	<input name="bussContractitemList[#index#].createdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/contract/bussContract.js"></script>	
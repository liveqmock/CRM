<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>产品</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="productController.do?doAdd">
					<input id="id" name="id" type="hidden" value="${productPage.id }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">产品名称:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">产品名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">类型:</label>
			</td>
			<td class="value">
					<t:dictSelect field="type" type="list"
						typeGroupCode=""  hasLabel="false"  title="类型"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">标准价格:</label>
			</td>
			<td class="value">
		     	 <input id="price" name="price" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">标准价格</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">实际价格:</label>
			</td>
			<td class="value">
		     	 <input id="actualprice" name="actualprice" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">实际价格</label>
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
				<label class="Validform_label">计价单位:</label>
			</td>
			<td class="value">
		     	 <input id="unit" name="unit" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计价单位</label>
			</td>
			<td align="right">
				<label class="Validform_label">库存:</label>
			</td>
			<td class="value">
		     	 <input id="stock" name="stock" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">库存</label>
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
				<label class="Validform_label">管理人员:</label>
			</td>
			<td class="value">
					<t:dictSelect field="owner" type="list"
						dictTable="t_s_base_user" dictField="id" dictText="realname"  hasLabel="false"  title="管理人员"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">管理人员</label>
			</td>
		</tr>
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="productController.do?contractitemList&id=${productPage.id}&id=${productPage.id}" icon="icon-search" title="订单明细" id="contractitem"></t:tab>
				 <t:tab href="productController.do?deliveryitemList&id=${productPage.id}&id=${productPage.id}" icon="icon-search" title="发货单明细" id="deliveryitem"></t:tab>
				 <t:tab href="productController.do?deliveryitemsList&id=${productPage.id}&id=${productPage.id}" icon="icon-search" title="发票明细" id="deliveryitems"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_contractitem_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="contractitemList[#index#].product" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">产品名称</label>
				  </td>
				  <td align="left">
					  	<input name="contractitemList[#index#].amount" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  	<input name="contractitemList[#index#].contractname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单名称</label>
				  </td>
				  <td align="left">
					  	<input name="contractitemList[#index#].unit" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">计价单位</label>
				  </td>
				  <td align="left">
					  	<input name="contractitemList[#index#].unitprice" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="contractitemList[#index#].subtotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">小计</label>
				  </td>
				  <td align="left">
					  	<input name="contractitemList[#index#].agio" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">折扣</label>
				  </td>
				  <td align="left">
					      	<input name="contractitemList[#index#].createdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_deliveryitem_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="deliveryitemList[#index#].productname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">产品名称</label>
				  </td>
				  <td align="left">
					  	<input name="deliveryitemList[#index#].unit" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">计价单位</label>
				  </td>
				  <td align="left">
					  	<input name="deliveryitemList[#index#].amount" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  	<input name="deliveryitemList[#index#].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="deliveryitemList[#index#].subtotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">小计</label>
				  </td>
				  <td align="left">
					  	<input name="deliveryitemList[#index#].invoicename" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发票名称</label>
				  </td>
				  <td align="left">
					       	<input name="deliveryitemList[#index#].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
					      	<input name="deliveryitemList[#index#].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_deliveryitems_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="deliveryitemsList[#index#].deliveryno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货单编号</label>
				  </td>
				  <td align="left">
					  	<input name="deliveryitemsList[#index#].productname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">产品名称</label>
				  </td>
				  <td align="left">
					  	<input name="deliveryitemsList[#index#].amount" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  	<input name="deliveryitemsList[#index#].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="deliveryitemsList[#index#].deliverynum" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货数量</label>
				  </td>
				  <td align="left">
					       	<input name="deliveryitemsList[#index#].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/product/product.js"></script>	
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>客户管理</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="bussAccountController.do?doUpdate">
					<input id="id" name="id" type="hidden" value="${bussAccountPage.id }">
					<input id="createName" name="createName" type="hidden" value="${bussAccountPage.createName }">
					<input id="createDate" name="createDate" type="hidden" value="${bussAccountPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${bussAccountPage.updateName }">
					<input id="updateDate" name="updateDate" type="hidden" value="${bussAccountPage.updateDate }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">客户姓名:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
					               datatype="*"
					                value='${bussAccountPage.name}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户姓名</label>
			</td>
			<td align="right">
				<label class="Validform_label">电话号码:</label>
			</td>
			<td class="value">
		     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  
					               datatype="*"
					                value='${bussAccountPage.phone}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">电话号码</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">性别:</label>
			</td>
			<td class="value">
					<t:dictSelect field="sex" type="list"
						typeGroupCode="sex" defaultVal="${bussAccountPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">性别</label>
			</td>
			<td align="right">
				<label class="Validform_label">地址:</label>
			</td>
			<td class="value">
				 <textarea id="address" name="address">${bussAccountPage.address}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">地址</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">手机:</label>
			</td>
			<td class="value">
		     	 <input id="mobile" name="mobile" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${bussAccountPage.mobile}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">手机</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户意向:</label>
			</td>
			<td class="value">
					<t:dictSelect field="intention" type="list"
						typeGroupCode="intention" defaultVal="${bussAccountPage.intention}" hasLabel="false"  title="客户意向"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户意向</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">省份:</label>
			</td>
			<td class="value">
					<t:dictSelect field="provinces" type="list"
						typeGroupCode="" defaultVal="${bussAccountPage.provinces}" hasLabel="false"  title="省份"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">省份</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户类型:</label>
			</td>
			<td class="value">
					<t:dictSelect field="type" type="list"
						typeGroupCode="type" defaultVal="${bussAccountPage.type}" hasLabel="false"  title="客户类型"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户类型</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">客户级别:</label>
			</td>
			<td class="value">
					<t:dictSelect field="level" type="list"
						typeGroupCode="level" defaultVal="${bussAccountPage.level}" hasLabel="false"  title="客户级别"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户级别</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户编码:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${bussAccountPage.no}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户编码</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">客户来源:</label>
			</td>
			<td class="value">
					<t:dictSelect field="source" type="list"
						typeGroupCode="source" defaultVal="${bussAccountPage.source}" hasLabel="false"  title="客户来源"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户来源</label>
			</td>
			<td align="right">
				<label class="Validform_label">身份证:</label>
			</td>
			<td class="value">
		     	 <input id="identity" name="identity" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${bussAccountPage.identity}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">图片:</label>
			</td>
			<td class="value">
						<input type="hidden" id="photo" name="photo" />
						<c:if test="${bussAccountPage.photo==''}">
							<a   target="_blank" id="photo_href">暂时未上传文件</a>
						</c:if>
						<c:if test="${bussAccountPage.photo!=''}">
							<a href="${bussAccountPage.photo}"  target="_blank" id="photo_href">下载</a>
						</c:if>
					   <input class="ui-button" type="button" value="上传附件"
									onclick="browseFiles('photo','photo_href')"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">图片</label>
			</td>
			<td align="right">
				<label class="Validform_label">描述:</label>
			</td>
			<td class="value">
				 <textarea id="remark" name="remark">${bussAccountPage.remark}</textarea>
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
						dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${bussAccountPage.owner}" hasLabel="false"  title="负责人"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">负责人</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="bussAccountController.do?bussContactList&id=${bussAccountPage.id}" icon="icon-search" title="联系人" id="bussContact"></t:tab>
				 <t:tab href="bussAccountController.do?bussAttachmentList&id=${bussAccountPage.id}" icon="icon-search" title="附件" id="bussAttachment"></t:tab>
				 <t:tab href="bussAccountController.do?bussContractList&id=${bussAccountPage.id}" icon="icon-search" title="订单" id="bussContract"></t:tab>
				 <t:tab href="bussAccountController.do?bussInvoiceList&id=${bussAccountPage.id}" icon="icon-search" title="发票" id="bussInvoice"></t:tab>
				 <t:tab href="bussAccountController.do?bussDeliveryList&id=${bussAccountPage.id}" icon="icon-search" title="发货单" id="bussDelivery"></t:tab>
				 <t:tab href="bussAccountController.do?bussReceiveList&id=${bussAccountPage.id}" icon="icon-search" title="收款" id="bussReceive"></t:tab>
				 <t:tab href="bussAccountController.do?bussServicesheetList&id=${bussAccountPage.id}" icon="icon-search" title="服务工单" id="bussServicesheet"></t:tab>
				 <t:tab href="bussAccountController.do?bussActivityList&id=${bussAccountPage.id}" icon="icon-search" title="活动跟进" id="bussActivity"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_bussContact_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="bussContactList[#index#].name" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">联系人</label>
				  </td>
				  <td align="left">
					  	<input name="bussContactList[#index#].phone" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">电话号码</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_bussAttachment_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="bussAttachmentList[#index#].accontname" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户姓名</label>
				  </td>
				  <td align="left">
					  	<input name="bussAttachmentList[#index#].serviceno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">工单编号</label>
				  </td>
				  <td align="left">
					  	<input name="bussAttachmentList[#index#].name" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">名称</label>
				  </td>
				  <td align="left">
										<input type="hidden" id="bussAttachmentList[#index#].filename" name="bussAttachmentList[#index#].filename" />
										<a  target="_blank" id="bussAttachmentList[#index#].filename_href">暂时未上传文件</a>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="browseFiles('bussAttachmentList\\[#index#\\]\\.filename','bussAttachmentList\\[#index#\\]\\.filename_href')"/>
					  <label class="Validform_label" style="display: none;">文件名</label>
				  </td>
				  <td align="left">
							<input name="bussAttachmentList[#index#].createdate" maxlength="12" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussAttachmentList[#index#].creatperson" type="list"
										typeGroupCode="" defaultVal="" hasLabel="false"  title="创建人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">创建人</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_bussContract_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="bussContractList[#index#].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单编号</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussContractList[#index#].type" type="list"
										typeGroupCode="ctype" defaultVal="" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractList[#index#].name" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单名称</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussContractList[#index#].status" type="list"
										typeGroupCode="cstatus" defaultVal="" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractList[#index#].quantily" maxlength="6" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractList[#index#].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">价格</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractList[#index#].total" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">总价</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractList[#index#].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户姓名</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractList[#index#].address" maxlength="128" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">地址</label>
				  </td>
				  <td align="left">
					       	<input name="bussContractList[#index#].remark" maxlength="1000" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussContractList[#index#].owner" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="" hasLabel="false"  title="负责人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">负责人</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractList[#index#].collect" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">已收款</label>
				  </td>
				  <td align="left">
					  	<input name="bussContractList[#index#].uncollect" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">未收款</label>
				  </td>
				  <td align="left">
					      	<input name="bussContractList[#index#].ceatedate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">创建时间</label>
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
		<tbody id="add_bussServicesheet_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="bussServicesheetList[#index#].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户名称</label>
				  </td>
				  <td align="left">
					  	<input name="bussServicesheetList[#index#].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">工单编号</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussServicesheetList[#index#].type" type="list"
										typeGroupCode="wtype" defaultVal="" hasLabel="false"  title="工单类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">工单类型</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussServicesheetList[#index#].status" type="list"
										typeGroupCode="wstatus" defaultVal="" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussServicesheetList[#index#].persons" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="" hasLabel="false"  title="受理人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">受理人</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussServicesheetList[#index#].dealingpeople" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="" hasLabel="false"  title="处理人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">处理人</label>
				  </td>
				  <td align="left">
					       	<input name="bussServicesheetList[#index#].problem" maxlength="1024" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">问题描述</label>
				  </td>
				  <td align="left">
					       	<input name="bussServicesheetList[#index#].method" maxlength="1024" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">处理方式</label>
				  </td>
				  <td align="left">
							<input name="bussServicesheetList[#index#].creatdate" maxlength="12" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">受理时间</label>
				  </td>
				  <td align="left">
							<input name="bussServicesheetList[#index#].processtime" maxlength="12" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">处理时间</label>
				  </td>
				  <td align="left">
					  	<input name="bussServicesheetList[#index#].phone" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">联系电话</label>
				  </td>
				  <td align="left">
					       	<input name="bussServicesheetList[#index#].address" maxlength="256" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">地址</label>
				  </td>
				  <td align="left">
					  	<input name="bussServicesheetList[#index#].cost" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">费用</label>
				  </td>
				  <td align="left">
										<input type="hidden" id="bussServicesheetList[#index#].photo" name="bussServicesheetList[#index#].photo" />
										<a  target="_blank" id="bussServicesheetList[#index#].photo_href">暂时未上传文件</a>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="browseFiles('bussServicesheetList\\[#index#\\]\\.photo','bussServicesheetList\\[#index#\\]\\.photo_href')"/>
					  <label class="Validform_label" style="display: none;">图片</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="bussServicesheetList[#index#].level" type="list"
										typeGroupCode="wlevel" defaultVal="" hasLabel="false"  title="工单级别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">工单级别</label>
				  </td>
			</tr>
		 </tbody>
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
 <script src = "webpage/com/buss/bussAccount.js"></script>	
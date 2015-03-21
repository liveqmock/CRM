<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBussInvoiceBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBussInvoiceBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBussInvoiceBtn').bind('click', function(){   
 		 var tr =  $("#add_bussInvoice_table_template tr").clone();
	 	 $("#add_bussInvoice_table").append(tr);
	 	 resetTrNum('add_bussInvoice_table');
    });  
	$('#delBussInvoiceBtn').bind('click', function(){   
      	$("#add_bussInvoice_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_bussInvoice_table'); 
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
			$(":input").each(function(){
				var $thisThing = $(this);
				$thisThing.attr("title",$thisThing.val());
			});
		}
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addBussInvoiceBtn" href="#">添加</a> <a id="delBussInvoiceBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="bussInvoice_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								发票编号
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								类型
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								发票名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								发票金额
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								描述
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								状态
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								客户姓名
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								开票人
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								开票时间
							</label></td>
	</tr>
	<tbody id="add_bussInvoice_table">	
	<c:if test="${fn:length(bussInvoiceList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="bussInvoiceList[0].id" type="hidden"/>
					<input name="bussInvoiceList[0].contractid" type="hidden"/>
					<input name="bussInvoiceList[0].accountid" type="hidden"/>
				  <td align="left">
					  	<input name="bussInvoiceList[0].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发票编号</label>
					</td>
				  <td align="left">
							<%-- <t:dictSelect field="type" type="list"
										typeGroupCode="itype" defaultVal="${bussInvoicePage.type}" hasLabel="false"  title="类型"></t:dictSelect> --%>     
							<input name="bussInvoiceList[0].type" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">类型</label>
					</td>
				  <td align="left">
					  	<input name="bussInvoiceList[0].name" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发票名称</label>
					</td>
				  <td align="left">
					  	<input name="bussInvoiceList[0].quote" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发票金额</label>
					</td>
				  <td align="left">
					       	<input name="bussInvoiceList[0].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
				  <td align="left">
							<%-- <t:dictSelect field="status" type="list"
										typeGroupCode="istatus" defaultVal="${bussInvoicePage.status}" hasLabel="false"  title="状态"></t:dictSelect> --%>
							<input name="bussInvoiceList[0].status" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >     
					  <label class="Validform_label" style="display: none;">状态</label>
					</td>
				  <td align="left">
					  	<input name="bussInvoiceList[0].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户姓名</label>
					</td>
				  <td align="left">
							<%-- <t:dictSelect field="createby" type="list"
										dictTable="po.dictTable" dictField="id" dictText="realname" defaultVal="${bussInvoicePage.createby}" hasLabel="false"  title="开票人"></t:dictSelect> --%>     
							<input name="bussInvoiceList[0].createby" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">开票人</label>
					</td>
				  <td align="left">
							<input name="bussInvoiceList[0].createdate" maxlength="36" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">开票时间</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(bussInvoiceList)  > 0 }">
		<c:forEach items="${bussInvoiceList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="bussInvoiceList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="bussInvoiceList[${stuts.index }].contractid" type="hidden" value="${poVal.contractid }"/>
					<input name="bussInvoiceList[${stuts.index }].accountid" type="hidden" value="${poVal.accountid }"/>
				   <td align="left">
					  	<input name="bussInvoiceList[${stuts.index }].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.no }">
					  <label class="Validform_label" style="display: none;">发票编号</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussInvoiceList[${stuts.index }].type" type="list"
										typeGroupCode="itype" defaultVal="${poVal.type }" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
				   </td>
				   <td align="left">
					  	<input name="bussInvoiceList[${stuts.index }].name" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.name }">
					  <label class="Validform_label" style="display: none;">发票名称</label>
				   </td>
				   <td align="left">
					  	<input name="bussInvoiceList[${stuts.index }].quote" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.quote }">
					  <label class="Validform_label" style="display: none;">发票金额</label>
				   </td>
				   <td align="left">
					       	<input name="bussInvoiceList[${stuts.index }].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussInvoiceList[${stuts.index }].status" type="list"
										typeGroupCode="istatus" defaultVal="${poVal.status }" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				   </td>
				   <td align="left">
					  	<input name="bussInvoiceList[${stuts.index }].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.accountname }">
					  <label class="Validform_label" style="display: none;">客户姓名</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussInvoiceList[${stuts.index }].createby" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${poVal.createby }" hasLabel="false"  title="开票人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">开票人</label>
				   </td>
				   <td align="left">
							<input name="bussInvoiceList[${stuts.index }].createdate" maxlength="36" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.createdate}' type="date" pattern="yyyy-MM-dd"/>">  
					  <label class="Validform_label" style="display: none;">开票时间</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>
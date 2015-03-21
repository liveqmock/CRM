<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBussDeliveryitemBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBussDeliveryitemBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBussDeliveryitemBtn').bind('click', function(){   
 		 var tr =  $("#add_bussDeliveryitem_table_template tr").clone();
	 	 $("#add_bussDeliveryitem_table").append(tr);
	 	 resetTrNum('add_bussDeliveryitem_table');
    });  
	$('#delBussDeliveryitemBtn').bind('click', function(){   
      	$("#add_bussDeliveryitem_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_bussDeliveryitem_table'); 
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addBussDeliveryitemBtn" href="#">添加</a> <a id="delBussDeliveryitemBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="bussDeliveryitem_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								产品名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								计价单位
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								数量
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								单价
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								小计
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								发票名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								描述
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								创建时间
							</label></td>
	</tr>
	<tbody id="add_bussDeliveryitem_table">	
	<c:if test="${fn:length(bussDeliveryitemList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="bussDeliveryitemList[0].id" type="hidden"/>
					<input name="bussDeliveryitemList[0].invoiceid" type="hidden"/>
					<input name="bussDeliveryitemList[0].productid" type="hidden"/>
				  <td align="left">
					  	<input name="bussDeliveryitemList[0].productname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">产品名称</label>
					</td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[0].unit" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">计价单位</label>
					</td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[0].amount" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[0].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[0].subtotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">小计</label>
					</td>
				  <td align="left">
					  	<input name="bussDeliveryitemList[0].invoicename" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发票名称</label>
					</td>
				  <td align="left">
					       	<input name="bussDeliveryitemList[0].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
				  <td align="left">
					      	<input name="bussDeliveryitemList[0].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               > 
					  <label class="Validform_label" style="display: none;">创建时间</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(bussDeliveryitemList)  > 0 }">
		<c:forEach items="${bussDeliveryitemList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="bussDeliveryitemList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="bussDeliveryitemList[${stuts.index }].invoiceid" type="hidden" value="${poVal.invoiceid }"/>
					<input name="bussDeliveryitemList[${stuts.index }].productid" type="hidden" value="${poVal.productid }"/>
				   <td align="left">
					  	<input name="bussDeliveryitemList[${stuts.index }].productname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.productname }">
					  <label class="Validform_label" style="display: none;">产品名称</label>
				   </td>
				   <td align="left">
					  	<input name="bussDeliveryitemList[${stuts.index }].unit" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.unit }">
					  <label class="Validform_label" style="display: none;">计价单位</label>
				   </td>
				   <td align="left">
					  	<input name="bussDeliveryitemList[${stuts.index }].amount" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.amount }">
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
					  	<input name="bussDeliveryitemList[${stuts.index }].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.price }">
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="bussDeliveryitemList[${stuts.index }].subtotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.subtotal }">
					  <label class="Validform_label" style="display: none;">小计</label>
				   </td>
				   <td align="left">
					  	<input name="bussDeliveryitemList[${stuts.index }].invoicename" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.invoicename }">
					  <label class="Validform_label" style="display: none;">发票名称</label>
				   </td>
				   <td align="left">
					       	<input name="bussDeliveryitemList[${stuts.index }].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
				   <td align="left">
					      	<input name="bussDeliveryitemList[${stuts.index }].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.creatdate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>
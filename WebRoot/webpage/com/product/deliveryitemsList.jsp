<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addDeliveryitemsBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delDeliveryitemsBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addDeliveryitemsBtn').bind('click', function(){   
 		 var tr =  $("#add_deliveryitems_table_template tr").clone();
	 	 $("#add_deliveryitems_table").append(tr);
	 	 resetTrNum('add_deliveryitems_table');
    });  
	$('#delDeliveryitemsBtn').bind('click', function(){   
      	$("#add_deliveryitems_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_deliveryitems_table'); 
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
	<a id="addDeliveryitemsBtn" href="#">添加</a> <a id="delDeliveryitemsBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="deliveryitems_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								发货单编号
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								产品名称
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
								发货数量
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								描述
							</label></td>
	</tr>
	<tbody id="add_deliveryitems_table">	
	<c:if test="${fn:length(deliveryitemsList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="deliveryitemsList[0].id" type="hidden"/>
					<input name="deliveryitemsList[0].deliveryid" type="hidden"/>
					<input name="deliveryitemsList[0].productid" type="hidden"/>
				  <td align="left">
					  	<input name="deliveryitemsList[0].deliveryno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货单编号</label>
					</td>
				  <td align="left">
					  	<input name="deliveryitemsList[0].productname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">产品名称</label>
					</td>
				  <td align="left">
					  	<input name="deliveryitemsList[0].amount" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
					  	<input name="deliveryitemsList[0].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="deliveryitemsList[0].deliverynum" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货数量</label>
					</td>
				  <td align="left">
					       	<input name="deliveryitemsList[0].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(deliveryitemsList)  > 0 }">
		<c:forEach items="${deliveryitemsList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="deliveryitemsList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="deliveryitemsList[${stuts.index }].deliveryid" type="hidden" value="${poVal.deliveryid }"/>
					<input name="deliveryitemsList[${stuts.index }].productid" type="hidden" value="${poVal.productid }"/>
				   <td align="left">
					  	<input name="deliveryitemsList[${stuts.index }].deliveryno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.deliveryno }">
					  <label class="Validform_label" style="display: none;">发货单编号</label>
				   </td>
				   <td align="left">
					  	<input name="deliveryitemsList[${stuts.index }].productname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.productname }">
					  <label class="Validform_label" style="display: none;">产品名称</label>
				   </td>
				   <td align="left">
					  	<input name="deliveryitemsList[${stuts.index }].amount" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.amount }">
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
					  	<input name="deliveryitemsList[${stuts.index }].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.price }">
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="deliveryitemsList[${stuts.index }].deliverynum" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.deliverynum }">
					  <label class="Validform_label" style="display: none;">发货数量</label>
				   </td>
				   <td align="left">
					       	<input name="deliveryitemsList[${stuts.index }].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>
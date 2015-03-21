<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addContractitemBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delContractitemBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addContractitemBtn').bind('click', function(){   
 		 var tr =  $("#add_contractitem_table_template tr").clone();
	 	 $("#add_contractitem_table").append(tr);
	 	 resetTrNum('add_contractitem_table');
    });  
	$('#delContractitemBtn').bind('click', function(){   
      	$("#add_contractitem_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_contractitem_table'); 
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
	<a id="addContractitemBtn" href="#">添加</a> <a id="delContractitemBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="contractitem_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
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
								订单名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								计价单位
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
								折扣
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								创建时间
							</label></td>
	</tr>
	<tbody id="add_contractitem_table">	
	<c:if test="${fn:length(contractitemList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="contractitemList[0].id" type="hidden"/>
					<input name="contractitemList[0].productid" type="hidden"/>
					<input name="contractitemList[0].contractid" type="hidden"/>
				  <td align="left">
					  	<input name="contractitemList[0].product" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">产品名称</label>
					</td>
				  <td align="left">
					  	<input name="contractitemList[0].amount" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
					  	<input name="contractitemList[0].contractname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单名称</label>
					</td>
				  <td align="left">
					  	<input name="contractitemList[0].unit" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">计价单位</label>
					</td>
				  <td align="left">
					  	<input name="contractitemList[0].unitprice" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="contractitemList[0].subtotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">小计</label>
					</td>
				  <td align="left">
					  	<input name="contractitemList[0].agio" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">折扣</label>
					</td>
				  <td align="left">
					      	<input name="contractitemList[0].createdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               > 
					  <label class="Validform_label" style="display: none;">创建时间</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(contractitemList)  > 0 }">
		<c:forEach items="${contractitemList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="contractitemList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="contractitemList[${stuts.index }].productid" type="hidden" value="${poVal.productid }"/>
					<input name="contractitemList[${stuts.index }].contractid" type="hidden" value="${poVal.contractid }"/>
				   <td align="left">
					  	<input name="contractitemList[${stuts.index }].product" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.product }">
					  <label class="Validform_label" style="display: none;">产品名称</label>
				   </td>
				   <td align="left">
					  	<input name="contractitemList[${stuts.index }].amount" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.amount }">
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
					  	<input name="contractitemList[${stuts.index }].contractname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.contractname }">
					  <label class="Validform_label" style="display: none;">订单名称</label>
				   </td>
				   <td align="left">
					  	<input name="contractitemList[${stuts.index }].unit" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.unit }">
					  <label class="Validform_label" style="display: none;">计价单位</label>
				   </td>
				   <td align="left">
					  	<input name="contractitemList[${stuts.index }].unitprice" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.unitprice }">
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="contractitemList[${stuts.index }].subtotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.subtotal }">
					  <label class="Validform_label" style="display: none;">小计</label>
				   </td>
				   <td align="left">
					  	<input name="contractitemList[${stuts.index }].agio" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.agio }">
					  <label class="Validform_label" style="display: none;">折扣</label>
				   </td>
				   <td align="left">
					      	<input name="contractitemList[${stuts.index }].createdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.createdate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>
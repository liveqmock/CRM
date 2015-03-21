<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBussDeliveryBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBussDeliveryBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBussDeliveryBtn').bind('click', function(){   
 		 var tr =  $("#add_bussDelivery_table_template tr").clone();
	 	 $("#add_bussDelivery_table").append(tr);
	 	 resetTrNum('add_bussDelivery_table');
    });  
	$('#delBussDeliveryBtn').bind('click', function(){   
      	$("#add_bussDelivery_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_bussDelivery_table'); 
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
	<a id="addBussDeliveryBtn" href="#">添加</a> <a id="delBussDeliveryBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="bussDelivery_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								订单名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								客户名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								创建时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								发货人
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								状态
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								地址
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								发货数量
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								发货时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								描述
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								订单编号
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								发货单编号
							</label></td>
	</tr>
	<tbody id="add_bussDelivery_table">	
	<c:if test="${fn:length(bussDeliveryList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="bussDeliveryList[0].id" type="hidden"/>
					<input name="bussDeliveryList[0].contractid" type="hidden"/>
					<input name="bussDeliveryList[0].accountid" type="hidden"/>
				  <td align="left">
					  	<input name="bussDeliveryList[0].contractname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单名称</label>
					</td>
				  <td align="left">
					  	<input name="bussDeliveryList[0].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户名称</label>
					</td>
				  <td align="left">
					      	<input name="bussDeliveryList[0].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               > 
					  <label class="Validform_label" style="display: none;">创建时间</label>
					</td>
				  <td align="left">
							<%-- <t:dictSelect field="owner" type="list"
										dictTable="po.dictTable" dictField="id" dictText="realname" defaultVal="${bussDeliveryPage.owner}" hasLabel="false"  title="发货人"></t:dictSelect> --%>     
							<input name="bussDeliveryList[0].owner" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货人</label>
					</td>
				  <td align="left">
							<%-- <t:dictSelect field="status" type="list"
										typeGroupCode="dstatus" defaultVal="${bussDeliveryPage.status}" hasLabel="false"  title="状态"></t:dictSelect> --%>     
							<input name="bussDeliveryList[0].status" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >	
					  <label class="Validform_label" style="display: none;">状态</label>
					</td>
				  <td align="left">
					  	<input name="bussDeliveryList[0].address" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">地址</label>
					</td>
				  <td align="left">
					  	<input name="bussDeliveryList[0].deliverytotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货数量</label>
					</td>
				  <td align="left">
							<input name="bussDeliveryList[0].deliverydate" maxlength="8" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发货时间</label>
					</td>
				  <td align="left">
					       	<input name="bussDeliveryList[0].remark" maxlength="1000" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
				  <td align="left">
					  	<input name="bussDeliveryList[0].contractno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单编号</label>
					</td>
				  <td align="left">
					  	<input name="bussDeliveryList[0].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发货单编号</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(bussDeliveryList)  > 0 }">
		<c:forEach items="${bussDeliveryList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="bussDeliveryList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="bussDeliveryList[${stuts.index }].contractid" type="hidden" value="${poVal.contractid }"/>
					<input name="bussDeliveryList[${stuts.index }].accountid" type="hidden" value="${poVal.accountid }"/>
				   <td align="left">
					  	<input name="bussDeliveryList[${stuts.index }].contractname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.contractname }">
					  <label class="Validform_label" style="display: none;">订单名称</label>
				   </td>
				   <td align="left">
					  	<input name="bussDeliveryList[${stuts.index }].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.accountname }">
					  <label class="Validform_label" style="display: none;">客户名称</label>
				   </td>
				   <td align="left">
					      	<input name="bussDeliveryList[${stuts.index }].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.creatdate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussDeliveryList[${stuts.index }].owner" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${poVal.owner }" hasLabel="false"  title="发货人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">发货人</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussDeliveryList[${stuts.index }].status" type="list"
										typeGroupCode="dstatus" defaultVal="${poVal.status }" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				   </td>
				   <td align="left">
					  	<input name="bussDeliveryList[${stuts.index }].address" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.address }">
					  <label class="Validform_label" style="display: none;">地址</label>
				   </td>
				   <td align="left">
					  	<input name="bussDeliveryList[${stuts.index }].deliverytotal" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.deliverytotal }">
					  <label class="Validform_label" style="display: none;">发货数量</label>
				   </td>
				   <td align="left">
							<input name="bussDeliveryList[${stuts.index }].deliverydate" maxlength="8" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.deliverydate}' type="date" pattern="yyyy-MM-dd"/>">  
					  <label class="Validform_label" style="display: none;">发货时间</label>
				   </td>
				   <td align="left">
					       	<input name="bussDeliveryList[${stuts.index }].remark" maxlength="1000" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
				   <td align="left">
					  	<input name="bussDeliveryList[${stuts.index }].contractno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.contractno }">
					  <label class="Validform_label" style="display: none;">订单编号</label>
				   </td>
				   <td align="left">
					  	<input name="bussDeliveryList[${stuts.index }].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.no }">
					  <label class="Validform_label" style="display: none;">发货单编号</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>
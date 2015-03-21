<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBussContractBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBussContractBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBussContractBtn').bind('click', function(){   
 		 var tr =  $("#add_bussContract_table_template tr").clone();
	 	 $("#add_bussContract_table").append(tr);
	 	 resetTrNum('add_bussContract_table');
    });  
	$('#delBussContractBtn').bind('click', function(){   
      	$("#add_bussContract_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_bussContract_table'); 
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
	<a id="addBussContractBtn" href="#">添加</a> <a id="delBussContractBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="bussContract_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								订单编号
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								类型
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								订单名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								状态
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								数量
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								价格
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								总价
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								客户姓名
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								地址
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								描述
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								负责人
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								已收款
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								未收款
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								创建时间
							</label></td>
	</tr>
	<tbody id="add_bussContract_table">	
	<c:if test="${fn:length(bussContractList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="bussContractList[0].id" type="hidden"/>
					<input name="bussContractList[0].accountid" type="hidden"/>
				  <td align="left">
					  	<input name="bussContractList[0].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单编号</label>
					</td>
				  <td align="left">
							<t:dictSelect field="type" type="list"
										typeGroupCode="ctype" defaultVal="${bussContractPage.type}" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
					</td>
				  <td align="left">
					  	<input name="bussContractList[0].name" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">订单名称</label>
					</td>
				  <td align="left">
							<t:dictSelect field="status" type="list"
										typeGroupCode="cstatus" defaultVal="${bussContractPage.status}" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
					</td>
				  <td align="left">
					  	<input name="bussContractList[0].quantily" maxlength="6" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
					  	<input name="bussContractList[0].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">价格</label>
					</td>
				  <td align="left">
					  	<input name="bussContractList[0].total" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">总价</label>
					</td>
				  <td align="left">
					  	<input name="bussContractList[0].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户姓名</label>
					</td>
				  <td align="left">
					  	<input name="bussContractList[0].address" maxlength="128" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">地址</label>
					</td>
				  <td align="left">
					       	<input name="bussContractList[0].remark" maxlength="1000" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
				  <td align="left">
							<t:dictSelect field="owner" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${bussContractPage.owner}" hasLabel="false"  title="负责人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">负责人</label>
					</td>
				  <td align="left">
					  	<input name="bussContractList[0].collect" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">已收款</label>
					</td>
				  <td align="left">
					  	<input name="bussContractList[0].uncollect" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">未收款</label>
					</td>
				  <td align="left">
					      	<input name="bussContractList[0].ceatedate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               > 
					  <label class="Validform_label" style="display: none;">创建时间</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(bussContractList)  > 0 }">
		<c:forEach items="${bussContractList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="bussContractList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="bussContractList[${stuts.index }].accountid" type="hidden" value="${poVal.accountid }"/>
				   <td align="left">
					  	<input name="bussContractList[${stuts.index }].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.no }">
					  <label class="Validform_label" style="display: none;">订单编号</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussContractList[${stuts.index }].type" type="list"
										typeGroupCode="ctype" defaultVal="${poVal.type }" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
				   </td>
				   <td align="left">
					  	<input name="bussContractList[${stuts.index }].name" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.name }">
					  <label class="Validform_label" style="display: none;">订单名称</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussContractList[${stuts.index }].status" type="list"
										typeGroupCode="cstatus" defaultVal="${poVal.status }" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				   </td>
				   <td align="left">
					  	<input name="bussContractList[${stuts.index }].quantily" maxlength="6" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.quantily }">
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
					  	<input name="bussContractList[${stuts.index }].price" maxlength="8" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.price }">
					  <label class="Validform_label" style="display: none;">价格</label>
				   </td>
				   <td align="left">
					  	<input name="bussContractList[${stuts.index }].total" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.total }">
					  <label class="Validform_label" style="display: none;">总价</label>
				   </td>
				   <td align="left">
					  	<input name="bussContractList[${stuts.index }].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.accountname }">
					  <label class="Validform_label" style="display: none;">客户姓名</label>
				   </td>
				   <td align="left">
					  	<input name="bussContractList[${stuts.index }].address" maxlength="128" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.address }">
					  <label class="Validform_label" style="display: none;">地址</label>
				   </td>
				   <td align="left">
					       	<input name="bussContractList[${stuts.index }].remark" maxlength="1000" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussContractList[${stuts.index }].owner" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${poVal.owner }" hasLabel="false"  title="负责人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">负责人</label>
				   </td>
				   <td align="left">
					  	<input name="bussContractList[${stuts.index }].collect" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.collect }">
					  <label class="Validform_label" style="display: none;">已收款</label>
				   </td>
				   <td align="left">
					  	<input name="bussContractList[${stuts.index }].uncollect" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.uncollect }">
					  <label class="Validform_label" style="display: none;">未收款</label>
				   </td>
				   <td align="left">
					      	<input name="bussContractList[${stuts.index }].ceatedate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.ceatedate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>
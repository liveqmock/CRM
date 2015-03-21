<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBussContactBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBussContactBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBussContactBtn').bind('click', function(){   
 		 var tr =  $("#add_bussContact_table_template tr").clone();
	 	 $("#add_bussContact_table").append(tr);
	 	 resetTrNum('add_bussContact_table');
    });  
	$('#delBussContactBtn').bind('click', function(){   
      	$("#add_bussContact_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_bussContact_table'); 
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
	<a id="addBussContactBtn" href="#">添加</a> <a id="delBussContactBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="bussContact_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								联系人
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								电话号码
							</label></td>
	</tr>
	<tbody id="add_bussContact_table">	
	<c:if test="${fn:length(bussContactList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="bussContactList[0].id" type="hidden"/>
					<input name="bussContactList[0].accountid" type="hidden"/>
				  <td align="left">
					  	<input name="bussContactList[0].name" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">联系人</label>
					</td>
				  <td align="left">
					  	<input name="bussContactList[0].phone" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">电话号码</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(bussContactList)  > 0 }">
		<c:forEach items="${bussContactList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="bussContactList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="bussContactList[${stuts.index }].accountid" type="hidden" value="${poVal.accountid }"/>
				   <td align="left">
					  	<input name="bussContactList[${stuts.index }].name" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.name }">
					  <label class="Validform_label" style="display: none;">联系人</label>
				   </td>
				   <td align="left">
					  	<input name="bussContactList[${stuts.index }].phone" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.phone }">
					  <label class="Validform_label" style="display: none;">电话号码</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>
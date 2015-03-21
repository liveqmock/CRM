<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBussActivityBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBussActivityBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBussActivityBtn').bind('click', function(){   
 		 var tr =  $("#add_bussActivity_table_template tr").clone();
	 	 $("#add_bussActivity_table").append(tr);
	 	 resetTrNum('add_bussActivity_table');
    });  
	$('#delBussActivityBtn').bind('click', function(){   
      	$("#add_bussActivity_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_bussActivity_table'); 
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
	<a id="addBussActivityBtn" href="#">添加</a> <a id="delBussActivityBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="bussActivity_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								活动时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								内容描述
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								执行人
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								创建时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								客户姓名
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								线索姓名
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								状态
							</label></td>
	</tr>
	<tbody id="add_bussActivity_table">	
	<c:if test="${fn:length(bussActivityList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="bussActivityList[0].id" type="hidden"/>
					<input name="bussActivityList[0].accountid" type="hidden"/>
					<input name="bussActivityList[0].leadid" type="hidden"/>
				  <td align="left">
					      	<input name="bussActivityList[0].date" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               > 
					  <label class="Validform_label" style="display: none;">活动时间</label>
					</td>
				  <td align="left">
					  	<input name="bussActivityList[0].name" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">名称</label>
					</td>
				  <td align="left">
					       	<input name="bussActivityList[0].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                >
					  <label class="Validform_label" style="display: none;">内容描述</label>
					</td>
				  <td align="left">
							<t:dictSelect field="people" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${bussActivityPage.people}" hasLabel="false"  title="执行人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">执行人</label>
					</td>
				  <td align="left">
					      	<input name="bussActivityList[0].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					               > 
					  <label class="Validform_label" style="display: none;">创建时间</label>
					</td>
				  <td align="left">
					  	<input name="bussActivityList[0].accountname" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户姓名</label>
					</td>
				  <td align="left">
					  	<input name="bussActivityList[0].leadname" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">线索姓名</label>
					</td>
				  <td align="left">
							<t:dictSelect field="status" type="list"
										typeGroupCode="astatus" defaultVal="${bussActivityPage.status}" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(bussActivityList)  > 0 }">
		<c:forEach items="${bussActivityList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="bussActivityList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="bussActivityList[${stuts.index }].accountid" type="hidden" value="${poVal.accountid }"/>
					<input name="bussActivityList[${stuts.index }].leadid" type="hidden" value="${poVal.leadid }"/>
				   <td align="left">
					      	<input name="bussActivityList[${stuts.index }].date" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.date}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">  
					  <label class="Validform_label" style="display: none;">活动时间</label>
				   </td>
				   <td align="left">
					  	<input name="bussActivityList[${stuts.index }].name" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.name }">
					  <label class="Validform_label" style="display: none;">名称</label>
				   </td>
				   <td align="left">
					       	<input name="bussActivityList[${stuts.index }].remark" maxlength="512" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">内容描述</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussActivityList[${stuts.index }].people" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${poVal.people }" hasLabel="false"  title="执行人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">执行人</label>
				   </td>
				   <td align="left">
					      	<input name="bussActivityList[${stuts.index }].creatdate" maxlength="12" 
						  		type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.creatdate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				   </td>
				   <td align="left">
					  	<input name="bussActivityList[${stuts.index }].accountname" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.accountname }">
					  <label class="Validform_label" style="display: none;">客户姓名</label>
				   </td>
				   <td align="left">
					  	<input name="bussActivityList[${stuts.index }].leadname" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.leadname }">
					  <label class="Validform_label" style="display: none;">线索姓名</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussActivityList[${stuts.index }].status" type="list"
										typeGroupCode="astatus" defaultVal="${poVal.status }" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>
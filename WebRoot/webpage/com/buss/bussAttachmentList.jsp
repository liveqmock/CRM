<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBussAttachmentBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBussAttachmentBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBussAttachmentBtn').bind('click', function(){   
 		 var tr =  $("#add_bussAttachment_table_template tr").clone();
	 	 $("#add_bussAttachment_table").append(tr);
	 	 resetTrNum('add_bussAttachment_table');
    });  
	$('#delBussAttachmentBtn').bind('click', function(){   
      	$("#add_bussAttachment_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_bussAttachment_table'); 
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
	<a id="addBussAttachmentBtn" href="#">添加</a> <a id="delBussAttachmentBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="bussAttachment_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								客户姓名
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								工单编号
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								文件名
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								创建时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								创建人
							</label></td>
	</tr>
	<tbody id="add_bussAttachment_table">	
	<c:if test="${fn:length(bussAttachmentList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="bussAttachmentList[0].id" type="hidden"/>
					<input name="bussAttachmentList[0].accountid" type="hidden"/>
					<input name="bussAttachmentList[0].serviceid" type="hidden"/>
				  <td align="left">
					  	<input name="bussAttachmentList[0].accontname" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户姓名</label>
					</td>
				  <td align="left">
					  	<input name="bussAttachmentList[0].serviceno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">工单编号</label>
					</td>
				  <td align="left">
					  	<input name="bussAttachmentList[0].name" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">名称</label>
					</td>
				  <td align="left">
							<input type="hidden" id="bussAttachmentList[0].filename" name="bussAttachmentList[0].filename" />
										<a  target="_blank" id="bussAttachmentList[0].filename_href">暂时未上传文件</a>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="browseFiles('bussAttachmentList\\[0\\]\\.filename','bussAttachmentList\\[0\\]\\.filename_href')"/> 
					  <label class="Validform_label" style="display: none;">文件名</label>
					</td>
				  <td align="left">
							<input name="bussAttachmentList[0].createdate" maxlength="12" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">创建时间</label>
					</td>
				  <td align="left">
							<t:dictSelect field="creatperson" type="list"
										typeGroupCode="" defaultVal="${bussAttachmentPage.creatperson}" hasLabel="false"  title="创建人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">创建人</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(bussAttachmentList)  > 0 }">
		<c:forEach items="${bussAttachmentList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="bussAttachmentList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="bussAttachmentList[${stuts.index }].accountid" type="hidden" value="${poVal.accountid }"/>
					<input name="bussAttachmentList[${stuts.index }].serviceid" type="hidden" value="${poVal.serviceid }"/>
				   <td align="left">
					  	<input name="bussAttachmentList[${stuts.index }].accontname" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.accontname }">
					  <label class="Validform_label" style="display: none;">客户姓名</label>
				   </td>
				   <td align="left">
					  	<input name="bussAttachmentList[${stuts.index }].serviceno" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.serviceno }">
					  <label class="Validform_label" style="display: none;">工单编号</label>
				   </td>
				   <td align="left">
					  	<input name="bussAttachmentList[${stuts.index }].name" maxlength="24" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.name }">
					  <label class="Validform_label" style="display: none;">名称</label>
				   </td>
				   <td align="left">
					        <input type="hidden" id="bussAttachmentList[${stuts.index }].filename" name="bussAttachmentList[${stuts.index }].filename"  value="${poVal.filename }"/>
										<c:if test="${poVal.filename ==''}">
											<a  target="_blank" id="bussAttachmentList[${stuts.index }].filename_href">暂时未上传文件</a>
										</c:if>
										<c:if test="${poVal.filename !=''}">
											<a  href="${poVal.filename"  target="_blank" id="bussAttachmentList[${stuts.index }].filename_href">下载</a>
										</c:if>
										<a href ="#" target="_blank" id="bussAttachmentList[${stuts.index }].filename_href">暂时未上传文件</a>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="browseFiles('bussAttachmentList\\[${stuts.index }\\]\\.filename','bussAttachmentList\\[${stuts.index }\\]\\.filename_href')"/> 
					  <label class="Validform_label" style="display: none;">文件名</label>
				   </td>
				   <td align="left">
							<input name="bussAttachmentList[${stuts.index }].createdate" maxlength="12" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.createdate}' type="date" pattern="yyyy-MM-dd"/>">  
					  <label class="Validform_label" style="display: none;">创建时间</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussAttachmentList[${stuts.index }].creatperson" type="list"
										typeGroupCode="" defaultVal="${poVal.creatperson }" hasLabel="false"  title="创建人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">创建人</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>
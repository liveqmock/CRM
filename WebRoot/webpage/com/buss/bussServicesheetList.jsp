<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBussServicesheetBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBussServicesheetBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBussServicesheetBtn').bind('click', function(){   
 		 var tr =  $("#add_bussServicesheet_table_template tr").clone();
	 	 $("#add_bussServicesheet_table").append(tr);
	 	 resetTrNum('add_bussServicesheet_table');
    });  
	$('#delBussServicesheetBtn').bind('click', function(){   
      	$("#add_bussServicesheet_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_bussServicesheet_table'); 
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
	<a id="addBussServicesheetBtn" href="#">添加</a> <a id="delBussServicesheetBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="bussServicesheet_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								客户名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								工单编号
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								工单类型
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								状态
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								受理人
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								处理人
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								问题描述
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								处理方式
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								受理时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								处理时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								联系电话
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								地址
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								费用
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								图片
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								工单级别
							</label></td>
	</tr>
	<tbody id="add_bussServicesheet_table">	
	<c:if test="${fn:length(bussServicesheetList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="bussServicesheetList[0].id" type="hidden"/>
					<input name="bussServicesheetList[0].accountid" type="hidden"/>
				  <td align="left">
					  	<input name="bussServicesheetList[0].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">客户名称</label>
					</td>
				  <td align="left">
					  	<input name="bussServicesheetList[0].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">工单编号</label>
					</td>
				  <td align="left">
							<t:dictSelect field="type" type="list"
										typeGroupCode="wtype" defaultVal="${bussServicesheetPage.type}" hasLabel="false"  title="工单类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">工单类型</label>
					</td>
				  <td align="left">
							<t:dictSelect field="status" type="list"
										typeGroupCode="wstatus" defaultVal="${bussServicesheetPage.status}" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
					</td>
				  <td align="left">
							<t:dictSelect field="persons" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${bussServicesheetPage.persons}" hasLabel="false"  title="受理人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">受理人</label>
					</td>
				  <td align="left">
							<t:dictSelect field="dealingpeople" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${bussServicesheetPage.dealingpeople}" hasLabel="false"  title="处理人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">处理人</label>
					</td>
				  <td align="left">
					       	<input name="bussServicesheetList[0].problem" maxlength="1024" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                >
					  <label class="Validform_label" style="display: none;">问题描述</label>
					</td>
				  <td align="left">
					       	<input name="bussServicesheetList[0].method" maxlength="1024" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                >
					  <label class="Validform_label" style="display: none;">处理方式</label>
					</td>
				  <td align="left">
							<input name="bussServicesheetList[0].creatdate" maxlength="12" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">受理时间</label>
					</td>
				  <td align="left">
							<input name="bussServicesheetList[0].processtime" maxlength="12" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">处理时间</label>
					</td>
				  <td align="left">
					  	<input name="bussServicesheetList[0].phone" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">联系电话</label>
					</td>
				  <td align="left">
					       	<input name="bussServicesheetList[0].address" maxlength="256" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                >
					  <label class="Validform_label" style="display: none;">地址</label>
					</td>
				  <td align="left">
					  	<input name="bussServicesheetList[0].cost" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">费用</label>
					</td>
				  <td align="left">
							<input type="hidden" id="bussServicesheetList[0].photo" name="bussServicesheetList[0].photo" />
										<a  target="_blank" id="bussServicesheetList[0].photo_href">暂时未上传文件</a>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="browseFiles('bussServicesheetList\\[0\\]\\.photo','bussServicesheetList\\[0\\]\\.photo_href')"/> 
					  <label class="Validform_label" style="display: none;">图片</label>
					</td>
				  <td align="left">
							<t:dictSelect field="level" type="list"
										typeGroupCode="wlevel" defaultVal="${bussServicesheetPage.level}" hasLabel="false"  title="工单级别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">工单级别</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(bussServicesheetList)  > 0 }">
		<c:forEach items="${bussServicesheetList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="bussServicesheetList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="bussServicesheetList[${stuts.index }].accountid" type="hidden" value="${poVal.accountid }"/>
				   <td align="left">
					  	<input name="bussServicesheetList[${stuts.index }].accountname" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.accountname }">
					  <label class="Validform_label" style="display: none;">客户名称</label>
				   </td>
				   <td align="left">
					  	<input name="bussServicesheetList[${stuts.index }].no" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.no }">
					  <label class="Validform_label" style="display: none;">工单编号</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussServicesheetList[${stuts.index }].type" type="list"
										typeGroupCode="wtype" defaultVal="${poVal.type }" hasLabel="false"  title="工单类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">工单类型</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussServicesheetList[${stuts.index }].status" type="list"
										typeGroupCode="wstatus" defaultVal="${poVal.status }" hasLabel="false"  title="状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">状态</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussServicesheetList[${stuts.index }].persons" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${poVal.persons }" hasLabel="false"  title="受理人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">受理人</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussServicesheetList[${stuts.index }].dealingpeople" type="list"
										dictTable="t_s_base_user" dictField="id" dictText="realname" defaultVal="${poVal.dealingpeople }" hasLabel="false"  title="处理人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">处理人</label>
				   </td>
				   <td align="left">
					       	<input name="bussServicesheetList[${stuts.index }].problem" maxlength="1024" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.problem }">
					  <label class="Validform_label" style="display: none;">问题描述</label>
				   </td>
				   <td align="left">
					       	<input name="bussServicesheetList[${stuts.index }].method" maxlength="1024" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.method }">
					  <label class="Validform_label" style="display: none;">处理方式</label>
				   </td>
				   <td align="left">
							<input name="bussServicesheetList[${stuts.index }].creatdate" maxlength="12" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.creatdate}' type="date" pattern="yyyy-MM-dd"/>">  
					  <label class="Validform_label" style="display: none;">受理时间</label>
				   </td>
				   <td align="left">
							<input name="bussServicesheetList[${stuts.index }].processtime" maxlength="12" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.processtime}' type="date" pattern="yyyy-MM-dd"/>">  
					  <label class="Validform_label" style="display: none;">处理时间</label>
				   </td>
				   <td align="left">
					  	<input name="bussServicesheetList[${stuts.index }].phone" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.phone }">
					  <label class="Validform_label" style="display: none;">联系电话</label>
				   </td>
				   <td align="left">
					       	<input name="bussServicesheetList[${stuts.index }].address" maxlength="256" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.address }">
					  <label class="Validform_label" style="display: none;">地址</label>
				   </td>
				   <td align="left">
					  	<input name="bussServicesheetList[${stuts.index }].cost" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.cost }">
					  <label class="Validform_label" style="display: none;">费用</label>
				   </td>
				   <td align="left">
					        <input type="hidden" id="bussServicesheetList[${stuts.index }].photo" name="bussServicesheetList[${stuts.index }].photo"  value="${poVal.photo }"/>
										<c:if test="${poVal.photo ==''}">
											<a  target="_blank" id="bussServicesheetList[${stuts.index }].photo_href">暂时未上传文件</a>
										</c:if>
										<c:if test="${poVal.photo !=''}">
											<a  href="${poVal.photo"  target="_blank" id="bussServicesheetList[${stuts.index }].photo_href">下载</a>
										</c:if>
										<a href ="#" target="_blank" id="bussServicesheetList[${stuts.index }].photo_href">暂时未上传文件</a>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="browseFiles('bussServicesheetList\\[${stuts.index }\\]\\.photo','bussServicesheetList\\[${stuts.index }\\]\\.photo_href')"/> 
					  <label class="Validform_label" style="display: none;">图片</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="bussServicesheetList[${stuts.index }].level" type="list"
										typeGroupCode="wlevel" defaultVal="${poVal.level }" hasLabel="false"  title="工单级别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">工单级别</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>
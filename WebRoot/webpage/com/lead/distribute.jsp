<%@page import="org.jeecgframework.web.system.pojo.base.TSUser"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>资源共享</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="bussLeadController.do?doLeadShared" tiptype="1">
 					<input id="leadIds" name="leadIds" type="hidden" value="${leadIds}">  <!-- 资源对象 -->
					
		<table style="width: 450px;"  class="formtable">				
                <tr>
                	<td align="right">
						<label class="Validform_label">
							资源共享:
						</label>
					</td>
					<td class="value">					
					 		<t:dictSelect field="cusLevel" type="list" extendJson="{'onchange':'getDate(this.value)'}"   defaultVal="shared_all"
									typeGroupCode="shared"  hasLabel="false"  title="资源共享"></t:dictSelect>								               
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">资源共享</label>
						</td>
                </tr>
				<tr id="dep" style="display: none"> 	   
					<td align='right'>
						<label class='Validform_label'>
							共享至部门:
						</label>
					</td>
					<td class='value' >
							<t:dictSelect field='*' type='list' id="depIds"
									dictTable='t_s_depart' dictField='id'   dictText='departname'  hasLabel='false'  title='departname'></t:dictSelect>     
							<span class='Validform_checktip'></span>
							<label class='Validform_label' style='display: none;'>共享至部门</label>
						</td>
				</tr>
				<tr id='shared_user' style='display: none'>
					<td align='right'><label class='Validform_label'> 人员: </label></td>
					<td class='value' nowrap>
						<input name='userids'  type='hidden' value='${id}' id='userid'>
						<input name='roleName' class='inputxt' value='${realName }' id='realName'	readonly='readonly'  /> 
						<t:choose hiddenName='userid' hiddenid='id' url='userController.do?sharedUser' name='userList' icon='icon-search' title='人员列表' textname='realName' isclear='true'></t:choose>
						<span class='Validform_checktip'></span>
					</td>
				</tr>
				 
				 
					 
			</table>
		</t:formvalid>
 </body>
 <script type="text/javascript">
 
   function getDate(v){
	   var value = v;
	   
	   if(value=="shared_dep"){// 共享至部门		  		   
		   $('#dep').show();
		   $('#depIds').attr("name","depid");
		   $('#realName').removeAttr("datatype");	   
		   $('#shared_user').css('display','none');
		   
		  
 	   }else if(value=="shared_user"){ //贡献至某个人
		   $('#dep').css('display','none'); 		    
		   $('#shared_user').show();
		   $('#realName').attr("datatype","*");
		   $('#depIds').attr("name","");
	   }else{
		   $('#shared_user').css('display','none');
		   $('#dep').css('display','none');
		   $('#realName').removeAttr("datatype");
		   $('#depIds').attr("name","");
		   
	   }
   }
 
 </script>  
  
  
  
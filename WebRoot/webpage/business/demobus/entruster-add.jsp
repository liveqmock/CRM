<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>委托人</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="activitiController.do?doEntrust" tiptype="4">
					<input id="taskId" name="taskId" type="hidden" value="${taskId }">
		<table style="width: 450px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户名:
						</label>
					</td>
					<td class="value" nowrap><input name="id" value="${id}" id="id" readonly="readonly" style="width: 150px" datatype="*">  <t:choose hiddenName="id" hiddenid="id" url="activitiController.do?goEntrust" name="entrusterList" icon="icon-search" title="用户列表" textname="last" isclear="true"></t:choose>
			<span class="Validform_checktip"></span></td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							真实姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="last" name="last" readonly="readonly" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">真实姓名</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/book/tBBook.js"></script>		
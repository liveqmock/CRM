<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>用户集合</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid name="userList" title="选择人员" actionUrl="userController.do?sharedUserDatagrid" idField="id" checkbox="true" showRefresh="false">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="用户名称" field="realName" width="50"></t:dgCol>
</t:datagrid>
</body>
</html>

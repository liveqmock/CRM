<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>委托人员</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid name="entrusterList" title="选择委托人" actionUrl="activitiController.do?datagridEntruster" idField="id" queryMode="single" checkbox="false" showRefresh="true">
	<t:dgCol title="用户名" field="id" hidden="true" query="true" queryMode="single"></t:dgCol>
	<t:dgCol title="真实姓名" hidden="true" field="last" query="true" queryMode="single" width="50"></t:dgCol>
</t:datagrid>
</body>
</html>


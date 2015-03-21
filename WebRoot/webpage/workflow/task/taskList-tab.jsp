<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:tabs id="tt" iframe="false">
	<t:tab href="taskController.do?goMyTaskList" icon="icon-search" title="我的任务" id="default"></t:tab>
	<t:tab href="taskController.do?goGroupTaskList" icon="icon-search" title="组任务" id="autocom"></t:tab>
	<t:tab href="taskController.do?goHistoryTaskList" icon="icon-search" title="历史任务" id="autoSelect"></t:tab>
</t:tabs>


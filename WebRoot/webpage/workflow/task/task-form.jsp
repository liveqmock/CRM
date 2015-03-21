<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<c:if test="${not empty nodeStart }">
<iframe src="${nodeStart}" width="100%" height="100%" FRAMEBORDER=0></iframe>
</c:if>
<c:if test="${empty  nodeStart }">
无法显示附加页面,因为该流程没有配置起始节点:nodeStart
</c:if>
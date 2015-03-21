<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$(function() {
		$('#processtree').tree({
			animate : true,
			onClick : function(node) {
				$('#process-panelss').panel("refresh", "processController.do?processList&typeid=" + node.id);
			}
		});
	});
	function processcofig(id) {
		addOneTab('流程配置', 'processController.do?processTabs&processid=' + id);
	}
</script>

<div class="easyui-layout" fit="true">
 <div region="center" style="padding: 1px;" id="process-panelss">
  <t:datagrid name="processList" title="流程管理" queryMode="single" actionUrl="processController.do?processGrid&typeid=${typeid}" idField="id">
	 <t:dgCol title="流程id" field="id" width="100" hidden="false"></t:dgCol>
	 <t:dgCol title="流程名称" field="processname" query="true" width="70"></t:dgCol>
	 <t:dgCol title="流程KEY" field="processkey" width="70"></t:dgCol>
	 <t:dgCol title="流程类型" field="TSType.typename" width="70"></t:dgCol>
	 <t:dgCol title="流程状态" field="processstate" replace="已部署_1,未部署_0" width="70"></t:dgCol>
	 <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	 <t:dgFunOpt funname="processcofig(id)" title="配置"></t:dgFunOpt>
	 <t:dgConfOpt url="processController.do?deployProcess&processid={id}" message="确认发布流程?" title="发布"></t:dgConfOpt>
	 <t:dgDelOpt  exp="processstate#eq#0" url="processController.do?delprocess&id={id}" title="删除"></t:dgDelOpt>
  </t:datagrid>

	<div id="processListtb" style="padding: 3px; height: 25px">
	 <div style="float: left;">
	  <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="openwindow('新建流程','processController.do?processDesigner','processList',800,500)">新建流程</a>
	  <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="editfs('流程编辑','processController.do?processDesigner')">编辑流程</a>
	 </div>
	</div>
</div></div>

 <div region="west" style="width: 150px;" title="类型列表" split="true">
  <div class="easyui-panel" style="padding: 10px;" fit="true" border="false">
   <ul id="processtree" class="">
    <c:forEach items="${typegroupList}" var="typegroup">
     <li id="">
      <span>${typegroup.typegroupname } </span>
      <c:forEach items="${typegroup.TSTypes}" var="type">
       <ul>
        <li id="${type.id }">
         <span>${type.typename}</span>
        </li>
       </ul>
      </c:forEach>
     </li>
    </c:forEach>
   </ul>
  </div>
 </div> 
</div>

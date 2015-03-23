 
 
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
	
	 $(document).ready(function(){
	 		//给时间控件加上样式
	 			$("#bussKnowledgeListtb").find("input[name='creatdate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	 });
</script>

<div class="easyui-layout" fit="true">
 <div region="center" style="padding: 1px;" id="process-panelss">
<t:datagrid name="bussKnowledgeList" checkbox="true" fitColumns="false" title="知识库" actionUrl="bussKnowledgeController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="名称"  field="name"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  hidden="true" query="true" queryMode="single" dictionary="knowledge_type" width="120"></t:dgCol>
   <t:dgCol title="内容"  field="conten"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="creatdate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="creatby"  hidden="true"  queryMode="single" dictionary="t_s_base_user,id,realname" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="bussKnowledgeController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="bussKnowledgeController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="bussKnowledgeController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="bussKnowledgeController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="bussKnowledgeController.do?goUpdate" funname="detail"></t:dgToolBar>
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
  <script src = "webpage/com/service/bussKnowledgeList.js"></script>		
 
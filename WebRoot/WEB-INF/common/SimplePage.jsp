<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!-- 分页参数 -->
<input type="hidden" id="pageNo" name="simplePage.pageNo" value="${simplePage.pageNo }"/>
<div class="page"> 
	<ul>
	第${simplePage.pageNo}页 共${simplePage.totalPage}页
		<c:if test="${simplePage.pageNo != 1}">
			<li class="previous-next"><a href="javascript:void(0);" onclick="gotopage('${simplePage.pageNo-1}')"><span>上一页</span></a></li>
		</c:if>
		
		<c:if test="${simplePage.pageNo <= 6}">
			<c:if test="${simplePage.totalPage<=6}">
				<c:forEach begin="1" end="${simplePage.totalPage}" step="1" var="p">
					<li><a href="javascript:void(0);" <c:if test="${simplePage.pageNo == p}">class="current"</c:if> onclick="gotopage('${p}')"><span>${p}</span></a></li> 
				</c:forEach>
			</c:if>
			<c:if test="${simplePage.totalPage>6}">
				<c:forEach begin="1" end="6" step="1" var="p">
					<li><a href="javascript:void(0);" <c:if test="${simplePage.pageNo == p}">class="current"</c:if> onclick="gotopage('${p}')"><span>${p}</span></a></li> 
				</c:forEach>
				...
			</c:if>
		</c:if>
		<c:if test="${simplePage.pageNo > 6}">
			<li><a href="javascript:void(0);" onclick="gotopage('1')"><span>1</span></a></li> 
			<li><a href="javascript:void(0);" onclick="gotopage('2')"><span>2</span></a></li>
			<c:if test="${simplePage.totalPage-simplePage.pageNo>2}"> 
				...
				<c:forEach begin="${simplePage.pageNo-2}" end="${simplePage.pageNo+2}" step="1" var="p">
					<li><a href="javascript:void(0);" <c:if test="${simplePage.pageNo == p}">class="current"</c:if> onclick="gotopage('${p}')"><span>${p}</span></a></li> 
				</c:forEach>
				...
			</c:if>
			<c:if test="${simplePage.totalPage-simplePage.pageNo<=2}">
				... 
				<c:forEach begin="${simplePage.pageNo-2}" end="${simplePage.totalPage}" step="1" var="p">
					<li><a href="javascript:void(0);" <c:if test="${simplePage.pageNo == p}">class="current"</c:if> onclick="gotopage('${p}')"><span>${p}</span></a></li> 
				</c:forEach>
			</c:if>
		</c:if> 
		
		<c:if test="${simplePage.pageNo != simplePage.totalPage}">
		<li class="previous-next"><a href="javascript:void(0);" onclick="gotopage('${simplePage.pageNo+1}')"><span>下一页</span></a></li> 
		</c:if>
	</ul> 
</div>
<script>
	function gotopage(pageNo){
		$("#pageNo").val(pageNo);
		searchForm.submit();
	}
</script>

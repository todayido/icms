<input type="hidden" id="pageNo" name="pageNo" value="${map.simplePage.pageNo}"/>
<div class="pagination">	
<ul>
	<li>共${map.simplePage.totalCount}条  第${map.simplePage.pageNo}页 共${map.simplePage.totalPage}页  </li>
    <#if map.simplePage.pageNo != 1>
        <li><a class="page-previous" href="javascript:void(0);" onclick="gotopage('${map.simplePage.pageNo-1}')"><span>上一页</span></a></li>
    </#if>
    
    <#list 1..map.simplePage.totalPage as page>
    	<li><a class="page  <#if map.simplePage.pageNo==page>page-current</#if>" href="javascript:void(0);" onclick="gotopage('${page}')"><span>${page}</span></a></li>
    </#list>
    
    <#if map.simplePage.pageNo != map.simplePage.totalPage>
        <li><a class="page-next" href="javascript:void(0);" onclick="gotopage('${map.simplePage.pageNo+1}')"><span>下一页</span></a></li>
    </#if>
</ul> 
</div>
<script>
    function gotopage(pageNo){
        $("#pageNo").val(pageNo);
        searchForm.submit();
    }
</script>
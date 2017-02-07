
<input type="hidden" name="blockId" value="${map.newsProperty.blockid}" />
<form id="searchForm" name="searchForm" action="/news/list/${map.newsProperty.blockid}.htm" method="post">
  <div class="news-list">
      <div class="news-list-title">
      	<span>${map.newsProperty.title}</span>
      </div>
      <div class="news-list-content">
	      <ul>
	        <#list map.newsList as news>
	        <li>
	        	<a href="/news/details.htm?newsid=${news.newsid}">${news.title}</a>
	        	<span class="news-list-date">${news.lastedittime?string("MM-dd")}</span>
	        </li>
	        </#list>
	      </ul>
      </div>
  </div>
  <div style="text-align:center;margin-top:10px;">
	<#include "/classes/com/manager/view/SimplePage.ftl"/>
	</div>
</form>

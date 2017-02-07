<div class="news-block">
    <div class="news-block-title">
        <span class="news-block-title-name"><a href="/news/list/${map.newsProperty.blockid}.htm">${map.newsProperty.title}</a></span>
        <span class="news-block-title-more"><a href="/news/list/${map.newsProperty.blockid}.htm">more...</a></span>
    </div>
    <div class="news-block-content">
        <ul>
            <#list map.newsList as news>
		    <li>
		    	<a href="/news/details.htm?newsid=${news.newsid}" target="_blank">${news.title}</a>
		    	<span class="news-block-date">${news.lastedittime?string("MM-dd")}</span>
		    </li>
		    </#list>
        </ul>
    </div>
</div>
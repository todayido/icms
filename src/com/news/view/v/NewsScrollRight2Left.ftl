<div class="news-block">
    <div class="news-block-title">
        <span class="news-block-title-name"><a href="/news/list/${map.newsProperty.blockid}.htm">${map.newsProperty.title}</a></span>
        <span class="news-block-title-more"><a href="/news/list/${map.newsProperty.blockid}.htm">more...</a></span>
    </div>
    <div class="news-block-content">
        <ul>
            <#list map.newsList as news>
		    <li>
		    	<a style="width:70%;display:block;white-space:nowrap;overflow:hidden; text-overflow:ellipsis;" href="/news/details.htm?newsid=${news.newsid}">${news.title}</a>
		    	<span class="news-block-date" style="margin-top:-15px">${news.lastedittime?string("MM-dd")}</span>
		    </li>
		    </#list>
        </ul>
    </div>
</div>
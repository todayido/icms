<div class="news-details">
	<h3>${news.title}</h3>
	<div>
		<div class="news-details-author">
			${news.createtime?string("yyyy-MM-dd HH:mm:ss")}<br>作者：${news.author?default('佚名')} 编辑：${news.editor?default('佚名')}
			<div class="news-details-share">
				<a class="news-details-share-sina" href=""></a>
				<a class="news-details-share-zone" href=""></a>
				<a class="news-details-share-weixin" href=""></a>
			</div>
			<div style="display:inline-block;float:right"> 评论：${news.commentcount?default(0)} </div>
		</div>
		<div class="news-details-content">${news.content?default('')}</div>
	</div>
</div>

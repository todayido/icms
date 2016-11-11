package com.core.service.impl;

import net.sf.ehcache.Element;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.action.model.Action;
import com.core.service.CommonService;
import com.utils.BeanUtils;
import com.utils.EhcacheUtils;

@Service
public class CommonServiceImpl implements CommonService{
	
	private static final String GET_ACTION_CONF = "getActionConf";
	private static SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 查询动作配置的模板和视图
	 */
	@Transactional
	public Action getActionConfigure(String actonUrl) {
		
		sqlSessionTemplate = (SqlSessionTemplate) BeanUtils.getSpringBean("sqlSessionTemplate");
		
		Action action = null;
		if(EhcacheUtils.actionCache().get(actonUrl)!=null){// 启用缓存
			action = (Action) EhcacheUtils.actionCache().get(actonUrl).getObjectValue();
		}else{
			/**
			 *  查询是否已经配置了视图和摸板
			 */
			synchronized(this){
				action = sqlSessionTemplate.selectOne(GET_ACTION_CONF, actonUrl);
				if(action==null){
					String subString = actonUrl.substring(0, actonUrl.lastIndexOf("/"));
					action = sqlSessionTemplate.selectOne(GET_ACTION_CONF, subString);
					if(action!=null){
						EhcacheUtils.actionCache().put(new Element(actonUrl,action));
					}
				}else{
					//放入缓存
					EhcacheUtils.actionCache().put(new Element(actonUrl,action));
				}
			}
		}
		return action;
	}
	
}


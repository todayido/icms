package com.item.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.item.dao.PayDao;
import com.item.model.Pay;

@Repository
public class PayDaoImpl implements PayDao {

	private final String GET_LIST = "getPayList";
	private final String GET_COUNT = "getPayCount";
	private final String GET_BY_ID = "getPayById";
	private final String MODIFY = "modifyPay";
	private final String SAVE = "savePay";
	private final String DELETE_BY_ID = "deletePayById";
	private final String GET_PAY_BY_USER_NAME = "getPayByUserName";
	private final String MODIFY_WEIGUI_CISHU = "modifyWeiguiCishu";
	private final String KOU_CHU_JIN_E = "kouChuJinE";
	
	//充值成功
	private final String PAY_SUCCESS = "paySuccess";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deletePayById(String pay_id) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, pay_id);
	}

	public List<Pay> getAllPays(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Pay getPayById(String pay_id) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, pay_id);
	}

	public int getPayCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyPay(Pay pay) {
		return sqlSessionTemplate.update(MODIFY, pay);
	}

	public int savePay(Pay pay) {
		return sqlSessionTemplate.insert(SAVE, pay);
	}

	public Pay getPayByUserName(String user_name) {
		return sqlSessionTemplate.selectOne(GET_PAY_BY_USER_NAME, user_name);
	}

	public int paySuccess(Map paramsMap) {
		try{
		return sqlSessionTemplate.update(PAY_SUCCESS, paramsMap);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int modifyWeiguiCishu(Pay pay) {
		return sqlSessionTemplate.update(MODIFY_WEIGUI_CISHU, pay);
	}

	public int kouChuJinE(Pay pay) {
		return sqlSessionTemplate.update(KOU_CHU_JIN_E, pay);
	}

}


package com.taotao.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	
	@Override
	public String createOrder(Order order) {

		//调用taotao-order的服务提交订单（post请求，传递json字符串，使用doPostJson()方法）
		String json = HttpClientUtil.doPostJson(
				ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		//把json转成TaotaoResult对象
		TaotaoResult taotaoResult = TaotaoResult.format(json);
//		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, Order.class);
		if(taotaoResult.getStatus() == 200){
			Object orderId = taotaoResult.getData();
			return orderId.toString();

		}
		
		return "";
	}

}

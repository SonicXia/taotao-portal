package com.taotao.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {
	@Test
	public void doGet() throws Exception{
		//创建一个httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个get对象
		HttpGet get = new HttpGet("http://www.sogou.com");
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//取响应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		//关闭httpclient
		response.close();
		httpClient.close();
	}
	
	@Test
	public void doGetWithParam() throws Exception{
		//创建一个httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个url对象
		URIBuilder uriBuilder = new URIBuilder("http://www.sogou.com/web");
		URIBuilder addParameter = uriBuilder.addParameter("query", "花千骨");
		//创建一个get对象
		HttpGet get = new HttpGet(uriBuilder.build());
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//取响应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		//关闭httpclient
		response.close();
		httpClient.close();
	}
	
//	@Test
//	public void doPost() throws Exception {
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//	
//		//创建一个post对象
//		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.action");
//		//执行post请求
//		CloseableHttpResponse response = httpClient.execute(post);
//		String string = EntityUtils.toString(response.getEntity());
//		System.out.println(string);
//		response.close();
//		httpClient.close();
//		
//	}

}

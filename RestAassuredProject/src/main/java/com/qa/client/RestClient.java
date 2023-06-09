package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;



public class RestClient {
	
	//1.GET Method
	public void get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();//create one client connection
		HttpGet httpGet = new HttpGet(url);//it crete one http get conncetion with url
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet); //hit the GET URL
		
		//a.status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code  :" +statusCode);
		
		//b.Json String
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
//		
		JSONObject responsejson = new JSONObject(responseString);
		//convert string into json format
		System.out.println("Response json from API---->"+responsejson);
		
		//c.all Headers
		Header[] headerArray = closeableHttpResponse.getAllHeaders();
		
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for(Header header:headerArray) {
			allHeaders.put(header.getName(),header.getValue());
			
		}
		System.out.println("Headers Array ---"+allHeaders);
		
	}

}

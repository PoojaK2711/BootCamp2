package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.client.RestClient;

import restApi.TestBase;

public class GetAPITest extends TestBase{
	
	TestBase testBase;
	String serviceUrl;
	//String apiUrl;
	String url;
	RestClient restClient;
	
	@BeforeMethod
	public void setUP() throws IOException {
		testBase = new TestBase();
	     serviceUrl = prop.getProperty("URL");
		 //apiUrl = prop.getProperty(serviceUrl);
		//https://reqres.in/ai/users
		
		url = serviceUrl;
		
		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException {
	    restClient = new RestClient();
		restClient.get(url);
		
	}

}
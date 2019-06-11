package com.app.client;

import org.codehaus.jackson.map.ObjectMapper;

import com.app.entities.UserDetail;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientMain {
	
	private static JSONUtil jsonUtil = new JSONUtil();
	
	public static void main(String[] args) {
		String url = "http://192.168.0.107:8080/Web-Services/web/server1/";
		String input = "Hello User";
		UserDetail user = new UserDetail();
		user.setUserName("Himanshu");
		user.setPassword("passsldfj");
		
		stringParameterClient(input, url+"post/string");
		
		jsonParameterClient(user, url+"post/json");
		
		fullJSONParameterClient(user, url+"post/fulljson");
	}
	
	private static void stringParameterClient(String input, String url){
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.type("application/String").post(ClientResponse.class, input);
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void jsonParameterClient(Object input, String url){
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(input);
			Client client = Client.create();
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void fullJSONParameterClient(Object input, String url){
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(input);
			Client client = Client.create();
			WebResource webResource = client.resource(url);
			json = webResource.type("application/json").post(String.class, json);
			UserDetail user = jsonUtil.getObjetFromJSON(UserDetail.class, json);
			System.out.println("Inside Client fullJSONParameterClient");
			System.out.println(user);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

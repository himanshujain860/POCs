package com.app.client;

import java.lang.reflect.Type;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

import com.app.entities.UserDetail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class JSONUtil {
	
	public <T> T getObjetFromJSON(Class<T> clazz, String json){
		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
			public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				return new Date(jsonElement.getAsJsonPrimitive().getAsLong());
			}
		}).create();
		Type listType = new TypeToken<UserDetail>() {
							}.getType();
		return gson.fromJson(json, listType);
	}
	
	public <T> String getJSONFromObject(T user){
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}

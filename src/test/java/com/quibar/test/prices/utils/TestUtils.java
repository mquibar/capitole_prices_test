package com.quibar.test.prices.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class TestUtils {

	private static final ObjectMapper MAPPER ;
	
	static {
		
		var localDateTimeDeserializer =  new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		var module = new JavaTimeModule();
		module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
		
		
		JsonDeserializer<BigDecimal> bigDecimalDeserializer = new JsonDeserializer<BigDecimal>() {
			@Override
		    public BigDecimal deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		        return jp.getDecimalValue().setScale(2);
		    }
		};
		var simplemodule = new SimpleModule();
		simplemodule.addDeserializer(BigDecimal.class, bigDecimalDeserializer);
		
		MAPPER = new ObjectMapper()
			    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			    .registerModule(module)
			    .registerModule(simplemodule);
	}
	
	public static <T> T parseResponse(MvcResult result, Class<T> responseClass) {
	    try {
	      String contentAsString = result.getResponse().getContentAsString();
	      return MAPPER.readValue(contentAsString, responseClass);
	    } catch (IOException e) {
	      throw new RuntimeException(e);
	    }
	}
}

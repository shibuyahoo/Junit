package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ResponseTest {
	@Test
	public void responseObjectCreationTest() {
		Response response=new Response();
		response.setMessage("My Message");
		response.setStatus(400);
		assertEquals(400, response.getStatus());
		assertEquals("My Message", response.getMessage());		
	}
}

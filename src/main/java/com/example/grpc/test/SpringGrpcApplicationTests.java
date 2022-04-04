package com.example.grpc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.grpc.HelloWorldClient;

public class SpringGrpcApplicationTests {
	
	@Autowired
	private HelloWorldClient helloWorldClient;

	@Test
	public void testSayHello() {
		assertEquals(helloWorldClient.sayHello("John", "Doe"),true);
	}
}
package com.example.grpc;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.grpc.helloworld.Greeting;
import com.example.grpc.helloworld.Person;

import io.grpc.stub.StreamObserver;

import com.example.grpc.helloworld.HelloWorldServiceGrpc;

@GRpcService
public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldServiceImpl.class);

	@Override
	public void sayHello(Person request, StreamObserver<Greeting> responseObserver) {
		LOGGER.info("server received {}", request);

		String message = "Hello " + request.getFirstName() + " " + request.getLastName() + "!";
		Greeting greeting = Greeting.newBuilder().setMessage(message).build();
		LOGGER.info("server responded {}", greeting);

		responseObserver.onNext(greeting);
		responseObserver.onCompleted();
	}
}
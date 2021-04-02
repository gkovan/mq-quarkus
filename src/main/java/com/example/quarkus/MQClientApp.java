package com.example.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.quarkus.service.MQService;

@Path("/api")
public class MQClientApp {
	
	@Inject
	private MQService mqService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
    
    @Path("/send-hello-world")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloDK() {
    	mqService.sendHelloWorld();
        return "OK";
    }
}
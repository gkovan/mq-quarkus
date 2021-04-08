package com.example.quarkus;

import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.example.quarkus.service.MQService;
import com.example.quarkus.model.ResponseData;

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
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseData sendHelloWorld() {
    	mqService.sendHelloWorld();
    	ResponseData responseData = new ResponseData("OK", "Successfully sent record to MQ", "");
        return responseData;
    }
    
    @Path("/recv")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseData recv() {
    	String bodyOfMessage = mqService.receiveMessage();
    	ResponseData responseData = new ResponseData("OK", "Successfully received record", bodyOfMessage);
    	return responseData;
    }
    
    @Path("/send-json")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseData sendPost(Map<String,Object> requestMap) {
	       String bodyOfMessage = mqService.sendJson(requestMap);
	       ResponseData responseData = new ResponseData("OK", "Successfully received record", bodyOfMessage);
	       return responseData;
		}
}
package com.example.quarkus;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.example.quarkus.exceptions.AppException;
import com.example.quarkus.model.ErrorResponse;

public class ApplicationExceptionHandler {
	
	
	
    public Response toResponse(AppException e) 
    {
    	ErrorResponse error = new ErrorResponse(e.getErrorCode(), e.getLocalizedMessage());
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();  
    }

}

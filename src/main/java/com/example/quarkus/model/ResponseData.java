package com.example.quarkus.model;

public class ResponseData {
	
	public ResponseData(String status, String message, String body) {
		super();
		this.status = status;
		this.message = message;
		this.body = body;
	}

	private String status;
    
    private String message;
    
    private String body;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}

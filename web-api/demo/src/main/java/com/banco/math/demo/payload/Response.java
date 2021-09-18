package com.banco.math.demo.payload;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.http.HttpStatus;

public class Response implements Serializable {
	@JsonProperty("success")
    private Boolean status;

	@JsonProperty("message")
    private String message;
    
	@JsonIgnore
	private HttpStatus httpStatus;

    public Response() {

    }
    
	public Response(Boolean status, String message) {
		this.status = status;
		this.message = message;
	}
}

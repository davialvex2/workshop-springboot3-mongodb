package com.daviaugusto.workshopmongodb.exception;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;



public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestamp;
	private Integer Status;
	private String error;
	private String massage;
	private String path;


	public StandardError() {
		super();
	}

	public StandardError(Instant timestamp, Integer status, String error, String massage, String path) {
		super();
		this.timestamp = timestamp;
		Status = status;
		this.error = error;
		this.massage = massage;
		this.path = path;
	}


	public Instant getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}


	public Integer getStatus() {
		return Status;
	}


	public void setStatus(Integer status) {
		Status = status;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMassage() {
		return massage;
	}


	public void setMassage(String massage) {
		this.massage = massage;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
}

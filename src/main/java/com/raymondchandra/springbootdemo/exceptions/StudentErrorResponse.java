package com.raymondchandra.springbootdemo.exceptions;

public class StudentErrorResponse {
	private int status;
	private String message;
	private long timestamp;
	
	public StudentErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentErrorResponse(int status, String message, long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}
	
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}

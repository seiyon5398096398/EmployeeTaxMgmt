package com.imaginnovate.EmployeeTaxManagement;

public class ApiResponse {
	
	private String message;
	private String errorCode;
	
	
	public ApiResponse() {
		super();
	}


	public ApiResponse(String message, String errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", errorCode=" + errorCode + "]";
	}
	
	

}
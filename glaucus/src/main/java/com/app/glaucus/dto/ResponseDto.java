package com.app.glaucus.dto;

public class ResponseDto {
	private int responseCode;
	private String responseMessage;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public static ResponseDto getSuccessReponse(String message) {
		ResponseDto response = new ResponseDto();
		response.setResponseCode(200);
		response.setResponseMessage(message);
		return response;
	}
	public static ResponseDto getErrorReponse(String message,int errorCode) {
		ResponseDto response = new ResponseDto();
		response.setResponseCode(errorCode);
		response.setResponseMessage(message);
		return response;
	}
	
	
	
}

package com.email;

public class EmailandPassword {
	private String emailId;
	private String password;
	private String sendername;
	
	
	public EmailandPassword(String emailId, String password, String sendername) {
		
		this.emailId = emailId;
		this.password = password;
		this.sendername = sendername;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSendername() {
		return sendername;
	}
	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	

}

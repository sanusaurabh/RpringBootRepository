package com.email;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.sun.mail.util.MailConnectException;

public class MailMan {
	private Session session = null;
	private String form;
	private String password;
	
	


	public MailMan(String form, String password) throws MailConnectException {
		this.form = form;
		this.password = password;
	    if (session == null) {
	        init(form,password);
	    }
	}
	
	
	public void init(String from, String password) throws MailConnectException {
Properties props = new Properties();    
 props.put("mail.smtp.user", from);
 props.put("mail.smtp.host", "smtp.gmail.com");
 props.put("mail.smtp.port", "25");
 props.put("mail.debug", "true");
 props.put("mail.smtp.auth", "true");
 props.put("mail.smtp.starttls.enable", "true");
 props.put("mail.smtp.EnableSSL.enable", "true");
 props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 props.setProperty("mail.smtp.socketFactory.fallback", "false");
 props.setProperty("mail.smtp.port", "587");//465
 props.setProperty("mail.smtp.socketFactory.port", "587");
 props.put("mail.transport.protocol", "smtp");
 //get Session   
  session = Session.getInstance(props,    
  new javax.mail.Authenticator() {    
  protected PasswordAuthentication getPasswordAuthentication() {    
  return new PasswordAuthentication(from,password);  
  }    
 });   
if (session != null) {
  //  System.out.println("[OK]");
} else {
   // System.out.println("[NOK]");
}
	}
	
	public Session getSession(){
		return session;
		
	}


}

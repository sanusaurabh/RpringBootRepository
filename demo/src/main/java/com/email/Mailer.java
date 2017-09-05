package com.email;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailConnectException;
import com.util.InternetConnectionCheck;

public class Mailer {
	private static Boolean flag;
	
	 public  static Boolean getFlag() {
		return flag;
	}

	public  void send(String from,String password,String to,String sub,String msg){  
         //Get properties object    
//         Properties props = new Properties();    
//         props.put("mail.smtp.user", from);
//         props.put("mail.smtp.host", "smtp.gmail.com");
//         props.put("mail.smtp.port", "25");
//         props.put("mail.debug", "true");
//         props.put("mail.smtp.auth", "true");
//         props.put("mail.smtp.starttls.enable", "true");
//         props.put("mail.smtp.EnableSSL.enable", "true");
//         props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//         props.setProperty("mail.smtp.socketFactory.fallback", "false");
//         props.setProperty("mail.smtp.port", "465");
//         props.setProperty("mail.smtp.socketFactory.port", "465");
//         //get Session   
//         Session session = Session.getDefaultInstance(props,    
//          new javax.mail.Authenticator() {    
//          protected PasswordAuthentication getPasswordAuthentication() {    
//          return new PasswordAuthentication(from,password);  
//          }    
//         });  
		 MailMan mailMan=null;
		 Session session=null;
		 mailMan = checkConnectionOfMailId(from, password, mailMan);
		 if(mailMan!=null)
			 session=mailMan.getSession();
         //compose message    
         try {    
       	//  for(String to1 : mailList1()){
         // 	   for(int i=1; i<=10;i++){
        if(session!=null){
          MimeMessage message = new MimeMessage(session);    
                    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
          message.setSubject(sub);
          message.setText(msg, null, "html");    
          //send message 
          while(true){
          if(checkNetworkConnection()){
        	
          Transport.send(message);
        	 
           session=null;
          
          flag=true;
          System.out.println("message sent successfully");
          break;
          }else{
        	  continue;
          }
          
        
//          session=null;
//          
//          flag=true;
//          System.out.println("message sent successfully"); 
          }
        //  }
        //  }
}
         } catch (MessagingException e) {
       	  e.printStackTrace();
       	 flag=false;
       	  throw new RuntimeException(e);
       	  }    
            
   }

	private boolean checkNetworkConnection() {
		while(true){
		try {
			InternetConnectionCheck connectionCheck= new InternetConnectionCheck() ;
			connectionCheck.maincheckInternet();
			return connectionCheck.isFlagConnection();
		} catch ( UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			continue;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			continue;
		}
		}
		// TODO Auto-generated method stub
		 
	}

	private  MailMan checkConnectionOfMailId(String from, String password, MailMan mailMan) {
		int count=1;
		while(count!=5){
		try {
			mailMan = new MailMan(from, password);
			return mailMan;
		} catch (MailConnectException e1) {
			// TODO Auto-generated catch block
			count++;
//			try {
//				Thread.currentThread().sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		//	System.out.println(count +" get the connection using  email Id "+from +" and Password "+  password );
			e1.printStackTrace();
		}
		continue;
		}
		return null;
	}  


}

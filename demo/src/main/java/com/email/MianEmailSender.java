package com.email;

import java.io.InputStream;
import java.security.Security;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.mail.MessagingException;

 

public class MianEmailSender {
	 
	
	 public void sendMailCall( String subject1,String htmlemailtemplatefile1,String receiverfile1,String senderIdandPassword1, List<InputStream> list) {
		 //Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());	
		 String subject  =subject1;//subjectTextfield.getText();
	    	String greetingText  ="";//greetingTextField.getText();
	    	String msgbody ="";//htmlEditor.getHtmlText();
	    	String sign= "";//signatureTextArea.getText();
	    	String receiverfile= receiverfile1;//lblreceiverfile.getText();
	    	String senderIdandPassword =senderIdandPassword1;//lblsenderIdandPassword.getText();
	    	String htmlemailtemplatefile11 = htmlemailtemplatefile1;//lblhtmlEmailTemplate.getText();
	    	String htmlemailtemplatefile=EmailTemplate.gettemplatedata(list.get(0));
	    	ReadExcel.main(receiverfile,"receiverfile",list.get(1));
	    	List<String> emailIdList=ReadExcel.getemailIdList();
	    	LinkedHashMap<String,String> emaildrecivers=ReadExcel.getsendernameListinmap();
	    	ReadExcel.main(senderIdandPassword,"senderIdandPassword",list.get(2));
	    	LinkedHashMap<String,EmailandPassword> emaildnadPwd1=ReadExcel.getemailIdandPassword();
	    	ConcurrentHashMap<String,EmailandPassword>	emaildnadPwd = new ConcurrentHashMap<String,EmailandPassword>(emaildnadPwd1);
	    	final InputStream templatestream = list.get(0);
	    	 
	    	List<String> sendernameList=ReadExcel.getsendernameList();
	    	 
	    		for(Map.Entry<String,EmailandPassword> enteryemailidandsensdername : emaildnadPwd.entrySet()){
	    			String sensderemailId =enteryemailidandsensdername.getKey();
	    			EmailandPassword sensderpaswodandNmae =enteryemailidandsensdername.getValue();
	    			int count =1;
	    			try{
	    		sendmailToSender(subject, htmlemailtemplatefile, emaildrecivers, sensderpaswodandNmae, count,templatestream);
	    			}catch(Exception e){
	    				if( e.getMessage().contains("Daily user sending quota exceeded")){   
						     // break;
						      emaildnadPwd.remove(enteryemailidandsensdername.getKey());
						 }


	    			}
	    			
	    		//System.out.println("***************************************"+sensderemailId);
	    	}
	    	
	    	 
	          
	    }

	 /**
		 * @param subject
		 * @param htmlemailtemplatefile
		 * @param emaildrecivers
		 * @param sensderpaswodandNmae
		 * @param count
		 */
		private void sendmailToSender(String subject, String htmlemailtemplatefile,
				LinkedHashMap<String, String> emaildrecivers, EmailandPassword sensderpaswodandNmae, int count,InputStream object) {
		//	for(Map.Entry<String,String> entery : emaildrecivers.entrySet()){
			for(Iterator<Map.Entry<String, String>> it = emaildrecivers.entrySet().iterator(); it.hasNext(); ) {
			      Map.Entry<String, String> entery = it.next();

				
				 String keydomainName =entery.getKey();
				 String valuedomainName= entery.getValue();
				 //subject=subject+" "+keydomainName;
				// System.out.println(keydomainName +"88888888888 "+keydomainName);
				 String newsubject = subject.replace("domainUrl",keydomainName);
			//}
			//for(String domainName :emailIdList){
				
				if(count ==31) {
					 
					break;
					}
				else{
			  String template = EmailTemplate.createtemplate(keydomainName, sensderpaswodandNmae.getSendername(), htmlemailtemplatefile,object);
			 // Mailer.send("neva.webdeveloper@gmail.com","shfpen4ui9",valuedomainName,newsubject,template);
			  //System.out.println(sensderpaswodandNmae.getEmailId() +"  "+sensderpaswodandNmae.getPassword() +"  "+valuedomainName +" " +newsubject);
			 // System.out.println(template);
			  Mailer mailer = new Mailer();
			  checkErrorCouldnotConnectAndSendmail(sensderpaswodandNmae, valuedomainName, newsubject, template, mailer);
			  mailer=null;
			  count++;
			  if(entery.getKey().equals(keydomainName)) {
			        it.remove();
			      }
			   
				}
			}
		}

		/**
		 * @param sensderpaswodandNmae
		 * @param valuedomainName
		 * @param newsubject
		 * @param template
		 * @param mailer
		 */
		private void checkErrorCouldnotConnectAndSendmail(EmailandPassword sensderpaswodandNmae, String valuedomainName,
				String newsubject, String template, Mailer mailer) {
			while(true){
				try{
			mailer.send(sensderpaswodandNmae.getEmailId(),sensderpaswodandNmae.getPassword(),valuedomainName,newsubject,template);
			break;
				}catch(Exception e){
					if(e instanceof MessagingException){
						continue;
					}
					else {
						 
						  throw new RuntimeException(e);
					}
				}
			}
		}


}

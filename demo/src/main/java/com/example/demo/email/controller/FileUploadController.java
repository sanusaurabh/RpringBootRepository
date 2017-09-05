package com.example.demo.email.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.email.MianEmailSender;
@Controller
public class FileUploadController {
	 @RequestMapping(value="/multipleUpload")
	    public ModelAndView multiUpload(){
	    	return  new ModelAndView("multipleUpload");
	    }
	    @RequestMapping(value="/multipleSave", method=RequestMethod.POST )
	    public @ResponseBody String multipleSave(@RequestParam("subject")String subject,@RequestParam("file") MultipartFile[] files){
	    	String[] fileName = new String[3];
	    	List<InputStream> list =new ArrayList<InputStream>();
	    	String msg = "";
	    	if (files != null && files.length >0) {
	    		for(int i =0 ;i< files.length; i++){
		            try {
		                fileName[i] = files[i].getOriginalFilename();
		                list.add(files[i].getInputStream());
		               
		                msg += "You have successfully uploaded " + fileName +"<br/>";
		            } catch (Exception e) {
		                return "You failed to upload " + fileName + ": " + e.getMessage() +"<br/>";
		            }
	    		}
	    		 MianEmailSender  mianEmailSender= new MianEmailSender(); 
	    		 String subject1=subject;
	    		 String htmlemailtemplatefile1=fileName[0];
	    		 String receiverfile1=fileName[1];
	    		 String senderIdandPassword1=fileName[2];
	                mianEmailSender.sendMailCall(subject1,htmlemailtemplatefile1,receiverfile1, senderIdandPassword1,list);
	    		return msg;
	        } else {
	            return "Unable to upload. File is empty.";
	        }
	    }

}

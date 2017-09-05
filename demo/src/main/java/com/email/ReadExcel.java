package com.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static final List<String> emailIdList= new ArrayList<String>();
	public static final List<String> sendernameList= new ArrayList<String>();
	public static final LinkedHashMap<String,EmailandPassword> emaildnadPwd=new LinkedHashMap<String,EmailandPassword>();	
	public static final LinkedHashMap<String,String> sendernameList1=new LinkedHashMap<String,String>();
	public List<EmailandPassword> listEmailandPassword=  new ArrayList<>();
   // public static void main(String[] args,String flag) 
    public static void main(String args,String flag,  InputStream object) 
    {
    	//flag="senderIdandPassword";
        try
        {
        	//File f=new File(args);
        	 
           // FileInputStream file = new FileInputStream(f);
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(object);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            if(flag.equals("receiverfile"))
            getEmailidsforsend(rowIterator);
            if(flag.equals("senderIdandPassword"))
            getEmailidsandpaswordforsend(rowIterator);
            
     //file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }	

    private static void getEmailidsandpaswordforsend(Iterator<Row> rowIterator) {
    	
    	while (rowIterator.hasNext()) 
    {
        Row row = rowIterator.next();
        //For each row, iterate through all the columns
        Iterator<Cell> cellIterator = row.cellIterator();
        int count =1;
         String emailId="";
         String password="";
         String senderName="";
        
        while (cellIterator.hasNext()) 
        { 
            Cell cell = cellIterator.next();
            //Check the cell type and format accordingly
            switch (cell.getCellType()) 
            {
//                case Cell.CELL_TYPE_NUMERIC:
//                    System.out.print(cell.getNumericCellValue() + "t");
//                    break;
                case Cell.CELL_TYPE_STRING:
                   // System.out.print(cell.getStringCellValue() + "t");
//                    if("emailIds".equals("emailId")){
//                    	emailIdList.add(cell.getStringCellValue());
//                    }
                    if( count ==1){
                    	 emailId = cell.getStringCellValue();
                    	
                    }
                    if( count ==2){
                    	  password = cell.getStringCellValue();
                    	
                    }
                    if( count ==3){
                    	senderName = cell.getStringCellValue();
                    	sendernameList.add(senderName);
                  }
                    count++;
                    break;
            }
            
        }
      //  System.out.println("");
        if(!emailId.isEmpty()&& !password.isEmpty() && !senderName.isEmpty() )
         emaildnadPwd.put(emailId, new EmailandPassword(emailId,password,senderName));
         
        System.out.println("Email id " +emailId +"and Password "+password);
    }
   }

	private static void getEmailidsforsend(Iterator<Row> rowIterator) { while (rowIterator.hasNext()) 
    {
        Row row = rowIterator.next();
        //For each row, iterate through all the columns
        Iterator<Cell> cellIterator = row.cellIterator();
         int count =1;
         String domainName="";
         String domainUrl="";
//         if( count<4 && "emailIdsandPassword".equals("emailIdsandPassword") )
        while (cellIterator.hasNext()) 
        {
            Cell cell = cellIterator.next();
            //Check the cell type and format accordingly
            switch (cell.getCellType()) 
            {
//                case Cell.CELL_TYPE_NUMERIC:
//                    System.out.print(cell.getNumericCellValue() + "t");
//                    break;
                case Cell.CELL_TYPE_STRING:
                    
                    if( count ==1){
                    	domainName = cell.getStringCellValue();
                   	
                   }
                   if( count ==2){
                	   domainUrl = cell.getStringCellValue();
                   	
                   }
                   
                   count++;
                   break;
            }
            
        }
        System.out.println("domain  "+domainName +"    domain url  "+domainUrl);
        sendernameList1.put(domainName, domainUrl);
    }
   }

	public static List<String> getemailIdList(){
    	return emailIdList;
    }
    
    public static LinkedHashMap<String,EmailandPassword> getemailIdandPassword(){
    	return emaildnadPwd;
    }
    public static LinkedHashMap<String,String> getsendernameListinmap(){
    	return sendernameList1;
    }
    public static List<String> getsendernameList(){
    	return sendernameList;
    }
   
}

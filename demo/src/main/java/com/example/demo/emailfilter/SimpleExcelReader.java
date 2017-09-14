package com.example.demo.emailfilter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class SimpleExcelReader {
	 //Delimiter used in CSV file
    private static final String NEW_LINE_SEPARATOR = "\n";
     
    //CSV file header
    private static final Object [] FILE_HEADER = {"Domain"};
 

	 
		 
//		public static void main(String args[]) throws FileNotFoundException, IOException {
//	       // System.out.println("Reading from CSV file using BufferedReader and String Split");
//	      //  List nations = readCSV();
//	      //  System.out.print(nations);
//	        System.out.println("Parsing CSV file using CSVParser of Apache commons CSV");
//	      //  parseCSV();
//
//	    }

		/*
	     * Java program to read CVS file using BufferedReader and String split()
	     * method
	     */
	    public static List readCSV() throws FileNotFoundException, IOException {
	        List countries = new ArrayList<>();
	        BufferedReader br = new BufferedReader(new FileReader("domain.csv"));

	        String line = br.readLine(); // Reading header, Ignoring

	        while ((line = br.readLine()) != null && !line.isEmpty()) {
	            String[] fields = line.split(",");
	            String name = fields[0];
	            String capital = fields[1];
	            String currency = fields[2];
	            DomainAndOrganicTraffic nation = new DomainAndOrganicTraffic();
	            nation.setDomain(name);
	           // nation.setTrafficCount((int)fields[5]);
	            countries.add(nation);
	        }
	        br.close();
	        return countries;
	    }




		/*
	     * Method to read CSV file using CSVParser from Apache Commons CSV
	     */
	    public static void parseCSV(InputStream inputStream, String filepath) throws FileNotFoundException, IOException {
	        //CSVParser parser = new CSVParser(new FileReader("C:\\Users\\HP\\Desktop\\merg.csv"), CSVFormat.DEFAULT.withHeader());
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
	        Set<String> list = new HashSet<String>();
	        for (CSVRecord record : parser) {
	        	System.out.println();
	        	try {
	        		  System.out.println(record.get("Domain").toString()+"  "+record.get("Organic Traffic"));
	        		  if(Integer.parseInt(record.get("Organic Traffic"))<500000)
	        		  list.add(record.get("Domain").toString());
				} catch (Exception e) {
					// TODO: handle exception
				}         
	                    
	        }
	        parser.close();
	        
	        //writeCsvFile("C:\\Users\\HP\\Desktop\\domain1.csv",list);
	        writeCsvFile(filepath,list);
	        
	    }

		private static void writeCsvFile(String fileName, Set<String> list) {
			FileWriter fileWriter = null;
				         
				        CSVPrinter csvFilePrinter = null;
				         
				        //Create the CSVFormat object with "\n" as a record delimiter
				        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
				        try {
				        		             
				        		            //initialize FileWriter object
				        		            fileWriter = new FileWriter(fileName);
				        		             
				        		            //initialize CSVPrinter object
				        		            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
				        		             
				        		            //Create CSV file header
				        		            csvFilePrinter.printRecord(FILE_HEADER);
				        		            //Write a new student object list to the CSV file
				        		            	            for (String domain : list) {
				        		            	                List studentDataRecord = new ArrayList();
				        		            	                studentDataRecord.add(domain);
				        		            	                csvFilePrinter.printRecord(studentDataRecord);
				        		            	            }
				        		            	            System.out.println("CSV file was created successfully !!!");
				        } catch (Exception e) {
				        		            System.out.println("Error in CsvFileWriter !!!");
				        		            e.printStackTrace();
				        		        } finally {
				        		            try {
				        		                fileWriter.flush();
				        		                fileWriter.close();
				        		                csvFilePrinter.close();
				        		            } catch (IOException e) {
				        		                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
				        		                e.printStackTrace();
				        		            }
				        		        }
				        		             
				                 
			
			
		}



	
	 
}

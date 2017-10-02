package com.example.demo.emailfilter.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.emailfilter.SimpleExcelReader;
@Controller
public class CsvFileUploadAndDownloadforFilter {
	@RequestMapping(value = "/uploadCsvfileforfilterdata")
	public ModelAndView multiUpload() {
		return new ModelAndView("uploadCsvfileforfilterdata");
	}
	@RequestMapping(value = "/downloadcsvfileforfilterdata", method = RequestMethod.POST)
	public void downloadcsvfile(HttpServletRequest request,HttpServletResponse response, @RequestParam("file") MultipartFile[] files) throws FileNotFoundException, IOException {
		String[] fileName = new String[3];
		List<InputStream> list = new ArrayList<InputStream>();
		String msg = "";
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				try {
					fileName[i] = files[i].getOriginalFilename();
					list.add(files[i].getInputStream());

					msg += "You have successfully uploaded " + fileName + "<br/>";
				} catch (Exception e) {
					// return "You failed to upload " + fileName + ": " +
					// e.getMessage() +"<br/>";
				}
			}
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			File dir = new File(rootPath + File.separator + "uploadedfile");
			if (!dir.exists()) {
				dir.mkdirs();
		}
	
			File serverFile = new File(dir.getAbsolutePath() + File.separator + files[0].getOriginalFilename());
	//
			 SimpleExcelReader.parseCSV(files[0].getInputStream(),dir.getAbsolutePath() + File.separator + files[0].getOriginalFilename());
			 
			 File file = new File(dir.getAbsolutePath() + File.separator + files[0].getOriginalFilename());

			 response.setContentType("application/csv");
			 response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		      BufferedInputStream inStrem = new BufferedInputStream(new FileInputStream(file));
		      BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());
		      
		      byte[] buffer = new byte[1024];
		      int bytesRead = 0;
		      while ((bytesRead = inStrem.read(buffer)) != -1) {
		        outStream.write(buffer, 0, bytesRead);
		      }
		      outStream.flush();
		      inStrem.close();
		      file.deleteOnExit();
		   
			// InputStream templatestream = list.get(0);
		} else {
			// return "Unable to upload. File is empty.";
		}
	}


}

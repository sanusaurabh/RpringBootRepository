package com.example.demo.emailfilter.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public class CsvFileUploadAndDownloadforFilter {
	@RequestMapping(value = "/uploadcsvfileforfilterdata")
	public ModelAndView multiUpload() {
		return new ModelAndView("uploadCsvfileforfilterdata");
	}

	public void downloadcsvfile(HttpServletResponse response, @RequestParam("file") MultipartFile[] files) {
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
			// SimpleExcelReader.parseCSV();
			// InputStream templatestream = list.get(0);
		} else {
			// return "Unable to upload. File is empty.";
		}
	}

//	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
//	public String uploadFile(ModelMap model, @RequestParam MultipartFile file, HttpServletRequest request) {
//
//		if (file.isEmpty()) {
//			model.put("msg", "failed to upload file because its empty");
//			return "mainpage";
//		}
//
//		String rootPath = request.getSession().getServletContext().getRealPath("/");
//		File dir = new File(rootPath + File.separator + "uploadedfile");
//		if (!dir.exists()) {
//			dir.mkdirs();
//		}
//
//		File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
//
//		try {
//			try (InputStream is = file.getInputStream();
//					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
//				int i;
//				// write file to server
//				while ((i = is.read()) != -1) {
//					stream.write(i);
//				}
//				stream.flush();
//			}
//		} catch (IOException e) {
//			model.put("msg", "failed to process file because : " + e.getMessage());
//			return "mainpage";
//		}
//
//		String[] nextLine;
//		try {
//			// read file
//			// CSVReader(fileReader, ';', '\'', 1) means
//			// using separator ; and using single quote ' . Skip first line when
//			// read
//
//			try (FileReader fileReader = new FileReader(serverFile);
//					CSVReader reader = new CSVReader(fileReader, ';', '\'', 1);) {
//				while ((nextLine = reader.readNext()) != null) {
//					System.out.println("content : ");
//					for (int i = 0; i < nextLine.length; i++) {
//						System.out.println(nextLine[i]);
//					}
//				}
//			}
//		} catch (IOException e) {
//			System.out.println("error while reading csv and put to db : " + e.getMessage());
//		}
//
//		model.put("msg", "success upload and process file");
//		return "mainpage";
//	}

}

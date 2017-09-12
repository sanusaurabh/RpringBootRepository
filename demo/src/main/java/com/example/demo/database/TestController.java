package com.example.demo.database;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class TestController {
	@Autowired
	public BookRepojetory bookRepojetory;
	
	
	@RequestMapping("/all")
	public Iterable<Book> getAllBool(){
		return  bookRepojetory.findAll();
	}
}

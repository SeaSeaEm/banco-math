package com.banco.math.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/index")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getAll() {
		return new ResponseEntity<>("All good", HttpStatus.OK);
	}
}

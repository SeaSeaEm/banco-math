package com.banco.math.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import com.banco.math.demo.model.Account;
import com.banco.math.demo.payload.Response;
import com.banco.math.demo.service.AccountService;

@RestController
@RequestMapping("/api/index")
public class IndexController {

	@Autowired
	private AccountService _indexService;

	// @GetMapping
    @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getAll() {
		return new ResponseEntity<>("All good", HttpStatus.OK);
	}

	// @GetMapping
	// public ResponseEntity<Response> getTodo() {
	// Optional<Account> account = _indexService.testResponse(1);

	// if (!account.isPresent())
	// return new ResponseEntity<>(new Response(false, "Not working"),
	// HttpStatus.BAD_REQUEST);

	// Response resp = new Response(true,
	// String.format("%s - %d", account.get().getAccountNumber(),
	// account.get().getAccountId()));

	// return new ResponseEntity<>(resp, HttpStatus.OK);
	// }
}

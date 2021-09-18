package com.banco.math.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.banco.math.demo.payload.AccountResponse;
import com.banco.math.demo.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	private AccountService _accountService;

	@GetMapping("/{id}")
	public ResponseEntity<AccountResponse> getById(@PathVariable(name = "id") Long id) {
		return _accountService.getById(id);
	}

	@GetMapping
	public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        return _accountService.getAll();
	}
}
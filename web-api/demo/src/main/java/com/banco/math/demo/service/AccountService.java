package com.banco.math.demo.service;

import com.banco.math.demo.payload.AccountResponse;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface AccountService {
	ResponseEntity<AccountResponse> getById(long id);
	ResponseEntity<List<AccountResponse>> getAll();
}

package com.banco.math.demo.service.implementation;

import com.banco.math.demo.model.Account;
import com.banco.math.demo.payload.AccountResponse;
import com.banco.math.demo.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService implements com.banco.math.demo.service.AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ModelMapper modelMapper;

    @Override
    public ResponseEntity<AccountResponse> getById(long id) {
        Optional<Account> account = accountRepository.findById(id);

        if (!account.isPresent())
            return null;
            
        AccountResponse accResponse = modelMapper.map(account, AccountResponse.class);

        return new ResponseEntity<>(accResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AccountResponse>> getAll() {
        List<Account> listAccounts = accountRepository.findAll();
        
        List<AccountResponse> accResponse = listAccounts.stream()
                                                        .map(acc -> modelMapper.map(acc, AccountResponse.class))
                                                        .collect(Collectors.toList());

        return new ResponseEntity<>(accResponse, HttpStatus.OK);
    }
}

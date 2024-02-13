package com.banking.manage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.manage.dto.AccountDto;
import com.banking.manage.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	@PostMapping("/account")
	public AccountDto create(@RequestBody AccountDto accountDto) {
		return accountService.createAccount(accountDto);
	}
	
	@GetMapping("/account")
	public List<AccountDto> allBankAccount(){
		return accountService.allAccounts();
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<AccountDto> BankAccountById(@PathVariable long id) {
		AccountDto accountdto = accountService.findById(id);
		return ResponseEntity.ok(accountdto);
	}
	
	@PutMapping("/account/{id}/deposit")
	public AccountDto depositInBank(@PathVariable long id,@RequestBody Map<String, Double> request) {
		
		AccountDto accountDto = accountService.deposit(id, request.get("money"));
		
		return accountDto;
		
		
	}
	
	@PutMapping("/account/{id}/withdrawl")
	public AccountDto withdrawlInBank(@PathVariable long id,@RequestBody Map<String, Double> request) {
		
		AccountDto accountDto = accountService.withdrawl(id, request.get("money"));
		
		return accountDto;
	
	}
	
	@DeleteMapping("/account/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
		accountService.deleteAccountById(id);
		return ResponseEntity.ok("Account Deleted Successfully!");
	}

}

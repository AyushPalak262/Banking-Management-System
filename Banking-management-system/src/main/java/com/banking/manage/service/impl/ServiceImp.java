package com.banking.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.manage.dto.AccountDto;
import com.banking.manage.entity.Account;
import com.banking.manage.mapper.AccountMapper;
import com.banking.manage.repository.AccountRepository;
import com.banking.manage.service.AccountService;

@Service
public class ServiceImp implements AccountService {
	
	private AccountRepository accountRepository;

	public ServiceImp(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountdto) {
		
		Account account = AccountMapper.mapToAccount(accountdto);
		
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
		
		
	}

	@Override
	public List<AccountDto> allAccounts() {
		
		List<Account> findAll = accountRepository.findAll();
		List<AccountDto> dtos = new ArrayList<>();
		for (Account entity : findAll) {
	        dtos.add(AccountMapper.mapToAccountDto(entity));
	    }
		return dtos;
	}

	@Override
	public AccountDto findById(long id) {
		Account accountId = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Doesnot Exist"));
		return AccountMapper.mapToAccountDto(accountId);
	}

	@Override
	public AccountDto deposit(long id, double money) {
	
		Account accountId = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Doesnot Exist"));
		double total_balance=accountId.getAmount() + money;
		accountId.setAmount(total_balance);
		Account savedAccount = accountRepository.save(accountId);
		
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdrawl(long id, Double money) {
		Account accountId = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Doesnot Exist"));
		
		if(accountId.getAmount()<money) {
			throw new RuntimeException("InSufficient Balance");
		}
		
		double total_balance=accountId.getAmount() - money;
		accountId.setAmount(total_balance);
		Account savedAccount = accountRepository.save(accountId);
		
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public void deleteAccountById(long id) {
		accountRepository.deleteById(id);
	}
	
	


	
}

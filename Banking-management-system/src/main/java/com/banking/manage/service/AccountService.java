package com.banking.manage.service;

import java.util.List;

import com.banking.manage.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto account);
	
	List<AccountDto> allAccounts();
	
	AccountDto findById(long id);
	
	AccountDto deposit(long id,double money);

	AccountDto withdrawl(long id, Double money);
	
	void  deleteAccountById(long id);
	

}

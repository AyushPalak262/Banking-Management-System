package com.banking.manage.mapper;

import com.banking.manage.dto.AccountDto;
import com.banking.manage.entity.Account;

public class AccountMapper {
	
	public static Account  mapToAccount(AccountDto accountdto) {
		
		Account account=new Account(
				
				accountdto.getId(),
				accountdto.getName(),
				accountdto.getAmount()
				);
		return account;
	}
	
	
	
public static AccountDto  mapToAccountDto(Account account) {
		
		AccountDto accountdto=new AccountDto(
				
				account.getId(),
				account.getName(),
				account.getAmount()
				);
		return accountdto;
	}

}

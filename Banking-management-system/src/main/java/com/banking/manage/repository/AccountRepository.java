package com.banking.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.manage.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}

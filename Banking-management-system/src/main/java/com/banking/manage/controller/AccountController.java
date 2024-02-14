package com.banking.manage.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.manage.dto.AccountDto;
import com.banking.manage.service.AccountService;


@Controller
@RequestMapping("/")
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	//Home Page
	
	@GetMapping
	public String HomePage() {
		return "welcome";
	}
	//Create Account page
	
	@GetMapping("/create")
	public String showAccountCreatePage(Model model){
		AccountDto dto=new AccountDto();
		model.addAttribute("dto",dto);
		return "create";
	}
	
	
	@PostMapping("/create")
	public String createAccount(@ModelAttribute("dto") AccountDto dto) {
		System.out.println(dto);
		 accountService.createAccount(dto);
		 return "success";
	}
	
	//Display all details
	
	@RequestMapping("/all")
	public  String allBankAccount(ModelMap model){
		List<AccountDto> dto= accountService.allAccounts();
		model.addAttribute("dto",dto);
		 return "all-accounts";
	}
	
	@GetMapping("/bank/account/{id}")
	public ResponseEntity<AccountDto> BankAccountById(@PathVariable long id) {
		AccountDto accountdto = accountService.findById(id);
		return ResponseEntity.ok(accountdto);
	}
	
	//deposit in account
	@GetMapping("/deposit")
    public String showDepositForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "deposit";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam("id") Long id,
                          @RequestParam("amount") double amount,
                          Model model) {
        accountService.deposit(id, amount);
        return "redirect:/all"; // Redirect to the account details page
    }
	
	//withdrawal from account
	
    @GetMapping("/withdrawal")
    public String showWithdrawalForm(@RequestParam("id") Long id,
    		Model model)
    {
        model.addAttribute("id", id);
        return "withdrawal";
    }

    @PostMapping("/withdrawal")
    public String withdrawal(@RequestParam("id") Long id,
                          @RequestParam("amount") double amount) {
    	
            accountService.withdrawl(id, amount);
            return "redirect:/all"; // Redirect to the account details page
        
    }
	
	

	@RequestMapping("delete")
	public String deleteAccount(@RequestParam Long id) {
		accountService.deleteAccountById(id);
		return "redirect:all";
	}

}

package com.ps.springmvc.psbankapp.services;

import java.util.*;

import com.ps.springmvc.psbankapp.model.Account;

public interface AccountService {
		//Insert or save
		public boolean saveAccount(Account account);
		
		//Retrieve
		public List<Account> getAccounts();
		
		//Update purpose
		public Account getAccount(Integer accountNo);
		
		//Delete Service Method
		public boolean deleteAccount(int accountNo);



}

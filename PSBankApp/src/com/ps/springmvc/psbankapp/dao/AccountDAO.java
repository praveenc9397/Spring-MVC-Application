package com.ps.springmvc.psbankapp.dao;

import java.util.List;

import com.ps.springmvc.psbankapp.model.Account;


public interface AccountDAO {
	//Insert Operation
	public boolean saveAccount(Account account);
	
	//Method To retrieve data.
		public List<Account> getAccounts();
		
	//Update purpose
		public Account getAccount(Integer accountNo);
		
		//Delete Service
		public boolean deleteAccount(int accountNo);
		

}

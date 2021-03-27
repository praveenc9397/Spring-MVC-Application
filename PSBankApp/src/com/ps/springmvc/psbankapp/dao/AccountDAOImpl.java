package com.ps.springmvc.psbankapp.dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.springmvc.psbankapp.entity.AccountEntity;
import com.ps.springmvc.psbankapp.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	private SessionFactory sessionFactory;//Hibernate Session Factory

	//Adding record or update Record
	@Override
	public boolean saveAccount(Account account) {
		boolean saveFlag=true;
		AccountEntity accountEntity=new AccountEntity();
		accountEntity.setAccNo(account.getAccountNo());
		accountEntity.setAccHolderName(account.getAccountHolderName());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setDateOfBirth(account.getDateOfBirth());
		accountEntity.setAccountType(account.getAccountType());
		accountEntity.setPsCode(account.getPsCode());
		
		try {
			Session currentSession=sessionFactory.getCurrentSession();
			currentSession.save(accountEntity);
			//If its not Exists it will add otherwise it will update.
		//	currentSession.saveOrUpdate(accountEntity);
			
		}catch(Exception ex){
			ex.printStackTrace();
			saveFlag=false;
		}
		return saveFlag;
	}

	@Override
	public List<Account> getAccounts() {
		List<Account> list=new ArrayList<Account>();
		try {
			Session session=sessionFactory.getCurrentSession();
			//Query To Retrieve data.
			Query<AccountEntity> query=session.createQuery("From AccountEntity",AccountEntity.class);
			List<AccountEntity> accounts=query.getResultList();
			
			//To iterate all objects in Accounts collections.
			for(int i=0;i<accounts.size();i++){
				AccountEntity accountEntity=(AccountEntity) accounts.get(i);
				Account account=new Account();
				account.setAccountNo(accountEntity.getAccNo());
				account.setAccountHolderName(accountEntity.getAccHolderName());
				account.setBalance(accountEntity.getBalance());
				account.setDateOfBirth(accountEntity.getDateOfBirth());
				account.setAccountType(accountEntity.getAccountType());
				account.setPsCode(accountEntity.getPsCode());
				list.add(account);
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public Account getAccount(Integer accountNo) {
		Account account=new Account();
		try {
			Session session=sessionFactory.getCurrentSession();
			//Load return temp object without hitting DB.
			
			//AccountEntity accountEntity=(AccountEntity) session.load(AccountEntity.class,accountNo);
			
			// Get Method will Hit real datbase
			AccountEntity accountEntity=(AccountEntity) session.get(AccountEntity.class,accountNo);
			
			if(accountEntity==null) {
				return null;
			}
			
			
			account.setAccountNo(accountEntity.getAccNo());
			account.setAccountHolderName(accountEntity.getAccHolderName());
			account.setBalance(accountEntity.getBalance());
			account.setDateOfBirth(accountEntity.getDateOfBirth());
			account.setAccountType(accountEntity.getAccountType());
			account.setPsCode(accountEntity.getPsCode());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return account;
	}
	
	
	@Override
	public boolean deleteAccount(int accountNo) {
		boolean deleteFlag=true;
		try {
			Session session=sessionFactory.getCurrentSession();
			AccountEntity accountEntity=(AccountEntity) session.load(AccountEntity.class,accountNo);
			session.delete(accountEntity);
		}catch(Exception ex){
			ex.printStackTrace();
			deleteFlag=false;
		}
		return deleteFlag;
	}

	
}

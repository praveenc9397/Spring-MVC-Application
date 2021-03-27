package com.ps.springmvc.psbankapp.model;


import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.ps.springmvc.psbankapp.validations.PSCode;

public class Account {
	
	@NotNull(message="Account Can't be blank")
	private Integer accountNo;
	
	@NotNull
	@Size(min=2,max=50,message="Invalid length for Account Name")
	@Pattern(regexp = "[A-za-z(\\s)]+", message="Invalid Account Holder Name")
	private String accountHolderName;
	
	@NotNull(message="Balance Amount is Required")
	@Min(value=5000,message="Minimum Balance must not be less than 5000")
	private Integer balance;
	
	@NotNull(message="Account Type Can't be blank")
	private String accountType;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull(message="Date Of Birth Can't be blank")
	@Past(message="Account Can't be created for a person not born")
	private Date dateOfBirth;
	

	@NotNull(message="PS Code is Required")
	@PSCode(value="PSPKC", message="Security Code should Starts with PSPKC")
	private String psCode;
	


	public Account() {
		
		accountNo =0;
		accountHolderName ="";
		balance =0;
		accountType="";
		dateOfBirth=new Date();
		psCode="";
		
	}
	
	
	public Account(Integer accountNo, String accountHolderName, Integer balance, String accountType, Date dateOfBirth,
			String psCode) {
		super();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.accountType = accountType;
		this.dateOfBirth = dateOfBirth;
		this.psCode = psCode;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPsCode() {
		return psCode;
	}


	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}


	public Integer getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public Integer getBalance() {
		return balance;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}

}

 
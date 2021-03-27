package com.ps.springmvc.psbankapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import com.ps.springmvc.psbankapp.model.Account;
import com.ps.springmvc.psbankapp.services.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	AccountService accountService;
	

	//Register Custom Editor
		/*Once the method has been created, now the second step
		 *  we need to perform is to add the @InitBinder annotation.*/
		@InitBinder
		public void initBinder(WebDataBinder dataBinder)
		{
			//Trim or remove leading white space
			// And trailing white space, so we use string trimmer editor
			//Pass value true means if all the character present in the input is white space
			//then the value will be trimmed to null; 
			StringTrimmerEditor ste=new StringTrimmerEditor(true);
			//Once the object has been created, then we need to use the data binder 
			//and need to register this as a custom editor.
			dataBinder.registerCustomEditor(String.class,ste);
			
		}

	
	/*Home Page Method*/
	@RequestMapping("/")
	public String showHomePage(){
		return "index";
		
	}
	

	/*ControllerMethod for Create New Account*/	
	@RequestMapping("/new")
	public String newAccount(Model model){
		model.addAttribute("account",new Account());
		return "account-form";
	}

	
	
	/*Whenever the user click on the create account submit button then data will be posted to showAccount() method */
	@RequestMapping("/showAccount")
	public String showAccount()
	{
		return "showAccount";
	}

	/* Controller Method for save data */
	/* Controller Method for save data */
	@RequestMapping(value="/saveAccount",method=RequestMethod.GET)
	public String saveAccount(@Valid @ModelAttribute("account") Account account, BindingResult result,Model model)
	{		
//		if(result.hasErrors())
//			return "account-form";
//		else{
//			accountService.saveAccount(account);
//			return "redirect:/list";
//		}
		if(result.hasErrors())
			return "account-form";
		else {
			String message="";
			boolean flag=true;
			try {
				flag=accountService.saveAccount(account);
			}
			catch(Exception ex) {
				message=ex.getMessage();
				flag=false;
			}
			if(!flag) {
				model.addAttribute("message",message);
				return "account-form";
			}
			model.addAttribute("message",message);
			return "redirect:/list";
			}
		
	}

	
	/* Controller Method for Retrieve data */
	@GetMapping("/list")
	public String listAccounts(Model model) {
		List<Account> accounts=accountService.getAccounts();
		model.addAttribute("accounts",accounts);
		return "listAccounts";
	}


	/* Controller Method For Update Data */
	@GetMapping("/edit")
	//public String updateAccount(@PathParam("accountNo") int accountNo, Model model) {
		public String updateAccount(@RequestParam("accountNo") int accountNo, Model model) {
	// public String updateAccount(@PathVariable("accountNo") int accountNo, Model model) {
		Account account=accountService.getAccount(new Integer(accountNo));
		model.addAttribute("account",account);
		return "account-form";
		
	}
	
	/* Controller Method For Delete Data */
	@GetMapping("/delete")
	public String deleteAccount(@RequestParam("accountNo") int accountNo, Model model) {
		accountService.deleteAccount(accountNo);
		return "redirect:/list";
		
	}

	

}

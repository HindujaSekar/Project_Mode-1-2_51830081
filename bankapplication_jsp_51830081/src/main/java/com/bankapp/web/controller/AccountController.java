package com.bankapp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.service.AccountServiceImpl;
import com.bankapp.web.formbeans.FundTransferBean;
import com.bankapp.web.formbeans.DepositWithdrawBean;

@Controller
@RequestMapping("/clerk")
public class AccountController {
	private AccountServiceImpl aService;
	@Autowired
	public AccountController(AccountServiceImpl aService) {
		this.aService = aService;
	}
	
	@GetMapping(path="accmgt")
	public String accountManagement(){
		return "accmgt";
	}

	@GetMapping(path="allaccount")
	public ModelAndView getAllAccounts(ModelAndView mv){
		mv.addObject("accounts",aService.getAllAccounts());
		mv.setViewName("allaccounts");
		return mv;
	}
	
	
	@GetMapping(path = "withdraw")
	public String withdrawGet(Model model) {
		model.addAttribute("moneyForm", new DepositWithdrawBean());
		return "withdraw_form";

	}

	@PostMapping(path = "withdraw")
	public String withdrawPost(
			@Valid  @ModelAttribute(value = "moneyForm") DepositWithdrawBean moneyForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "withdraw_form";
		}
		aService.withdraw(moneyForm.getFromAccount(),moneyForm.getAmount());

		return "redirect:allaccount";
	}
	@GetMapping(path = "deposit")
	public String depositGet(Model model) {
		model.addAttribute("moneyForm", new DepositWithdrawBean());
		return "deposit_form";

	}

	@PostMapping(path = "deposit")
	public String depositPost(
			@Valid @ModelAttribute(value = "moneyForm") DepositWithdrawBean moneyForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "deposit_form";
		}
		aService.deposit(moneyForm.getFromAccount(),moneyForm.getAmount());

		return "redirect:allaccount";
	}
	@GetMapping(path = "transfer")
	public String transferGet(Model model) {
		model.addAttribute("fundForm", new FundTransferBean());
		return "fund_transfer";

	}
	@PostMapping(value = "transfer")
	public String transferPost(
			@Valid @ModelAttribute(value = "fundForm") FundTransferBean accountForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "fund_transfer";
		}
		aService.transfer(accountForm.getFromAccount(),
				accountForm.getToAccount(), accountForm.getAmount());
		return "redirect:allaccount";

	}
	
}

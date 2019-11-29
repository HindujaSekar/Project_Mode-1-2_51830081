package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountServiceImpl;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.model.service.UserService;
import com.bankapp.web.formbeans.AccountForm;

@Controller
@RequestMapping("/admin")
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private TransactionLogService tService;
	private AccountServiceImpl aService;
	@Autowired
	public UserController(AccountServiceImpl aService) {
		super();
		this.aService = aService;
	}

	@GetMapping(path="addaccount")
	public ModelAndView addAccountGet(ModelAndView mv){
		mv.addObject("accountform",new AccountForm());
		mv.setViewName("addAccount");
		return mv;
		
	}
	
	
	@PostMapping(path="addaccount")
	public String addAccountPost(AccountForm accountform){
		Customer customer=new Customer(accountform.getName(),
				accountform.getEmail(),
				accountform.getPhone(), accountform.getAddress(),
				accountform.getCity(), accountform.getCountry());
		Account account=new Account(accountform.getBalance(), customer, accountform.isBlocked());
		customer.setAccount(account);
		aService.createAccount(account);
		return "redirect:/clerk/allaccount";
		
	}
	@GetMapping(path="allusers")
	public ModelAndView getAllUsers(ModelAndView mv){
		mv.addObject("users",uService.findAll());
		mv.setViewName("allusers");
		return mv;
	}
	@GetMapping(path="usermgt")
	public ModelAndView userManagement(ModelAndView mv){
		mv.setViewName("usermgt");
		return mv;
		
	}
	/*@GetMapping(path="transaction")
	public ModelAndView transactionByTimeGet(ModelAndView mv){
		mv.addObject("timeforms",new TimeStampForm());
		mv.setViewName("txsform");
		return mv;
		
	}
	@PostMapping(path="transaction")
	public ModelAndView transactionByTimePost(
			@Valid  @ModelAttribute(value = "timeforms") TimeStampForm timeforms){
		ZonedDateTime d = ZonedDateTime.parse(timeforms.getFromTimestring());
		ZonedDateTime d2 = ZonedDateTime.parse(timeforms.getToTimestring());
		LocalDateTime fromTime=d.toLocalDateTime();
		LocalDateTime toTime=d2.toLocalDateTime();
		List<TransactionLog> info=tService.findByTimeStampBetween
				(timeforms.getFromTime(),timeforms.getToTime());
		ModelAndView mv=new ModelAndView();
		mv.setViewName("txs");
		mv.addObject("transactions",info);
		return mv;
		
	}*/
	@GetMapping(path="alltransaction")
	public ModelAndView allTransaction(ModelAndView mv){
		mv.setViewName("txs");
		mv.addObject("transactions",tService.getAllTransactionLogs());
		return mv;
		
	}
}

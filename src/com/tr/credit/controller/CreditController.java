package com.tr.credit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tr.credit.model.Customer;
import com.tr.credit.service.CreditControlService;
import com.tr.credit.service.InputControlService;


@Controller
@RequestMapping("/")
public class CreditController {
	
	@Autowired
	private CreditControlService creditControllerService;

	@Autowired
	private InputControlService inputControlService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showForm() {
		ModelAndView modelAndView = new ModelAndView("welcome", "customer", new Customer());
		modelAndView.addObject("message", "Hoşgeldiniz, Lütfen İstenilen Bilgileri Giriniz");
		return modelAndView;
	}
	
	 @RequestMapping(value = "/creditControl", method = RequestMethod.POST)
     public String creditControl(@ModelAttribute("customer") Customer customer, 
    	      BindingResult result, ModelMap model) {
		 if (result.hasErrors()) {
			 model.addAttribute("message", "İşleminizi gerçekleştiremiyoruz.");
	            return "error";
	        }
		 
		if(!inputControlService.checkInputs(customer)) {
			 model.addAttribute("message", "Lütfen girdiğiniz bilgileri kontrol ediniz.");
	            return "welcome";
		}
		 Integer customerCreditScore = creditControllerService.checkCreditScore(customer.getTckn());
		 Integer returnedCredit = creditControllerService.returnCreditForCustomer(customerCreditScore, customer.getIncome());
		 
		 
		 model.addAttribute("name", customer.getName());
		 if(returnedCredit==null) {
			 model.addAttribute("message", "Kredi başvurunuz olumsuz sonuçlanmıştır.");
		 }
		 else {
			 model.addAttribute("message", "Kredi başvurunuz olumlu sonuçlanmıştır.");
			 model.addAttribute("creditAmount","Kredi limitiniz : "+ returnedCredit + ". Bilgilendirme sms'i girmiş olduğunuz telefon numarasına gönderilmiştir.");
		 }
		 return "result";
	 }
	 
	 
}

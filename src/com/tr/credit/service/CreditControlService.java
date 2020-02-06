package com.tr.credit.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.credit.dao.CreditCustomerDao;
import com.tr.credit.dao.CreditCustomerDaoImpl;
import com.tr.credit.model.Customer;

@Service
public class CreditControlService {
	
	private final static Integer CS_REJECTION_CRITERION = 500;
	private final static Integer CS_ACCEPTANCE_CRITERION = 1000;
	private final static Integer INCOME_REJECTION_CRITERION = 5000;
	private final static Integer CREDIT_LIMIT_MULTIPLER = 4;
	
	
	
	@Autowired
	private CreditCustomerDaoImpl creditCustomerDaoImpl;
	
	public Integer checkCreditScore(String tckn) {
		//yazıldığı varsayılan dendiği için random bir değer döndürdüm. 
		//Db yada farklı bir servisten bu değer alınabilirdi.
		Random randomGenerator = new Random();
		int random = randomGenerator.nextInt(1900) + 1;
		System.out.println(random + " : for tckn : "+ tckn);
		return random;
	}
	
	public Integer returnCreditForCustomer(Integer creditScore, Customer customer) {
		if(creditScore<CS_REJECTION_CRITERION) {
			return null;
		}
		if(creditScore<CS_ACCEPTANCE_CRITERION) {
			if(customer.getIncome() < 5000) {
				return null;
			}
			creditCustomerDaoImpl.addCreditCustomerToDB(customer);
			return 10000;
		}
		creditCustomerDaoImpl.addCreditCustomerToDB(customer);
		return customer.getIncome()*CREDIT_LIMIT_MULTIPLER;
		
	}
}

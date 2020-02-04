package com.tr.credit.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class CreditControlService {
	
	private final static Integer CS_REJECTION_CRITERION = 500;
	private final static Integer CS_ACCEPTANCE_CRITERION = 1000;
	private final static Integer INCOME_REJECTION_CRITERION = 5000;
	private final static Integer CREDIT_LIMIT_MULTIPLER = 4;
	
	
	
	
	
	public Integer checkCreditScore(String tckn) {
		//yazıldığı varsayılan dendiği için random bir değer döndürdüm. 
		//Db yada farklı bir servisten bu değer alınabilirdi.
		Random randomGenerator = new Random();
		int random = randomGenerator.nextInt(1900) + 1;
		System.out.println(random + " : for tckn : "+ tckn);
		return random;
	}
	
	public Integer returnCreditForCustomer(Integer creditScore, Integer income) {
		if(creditScore<CS_REJECTION_CRITERION) {
			return null;
		}
		if(creditScore<CS_ACCEPTANCE_CRITERION) {
			if(income < 5000) {
				return null;
			}
			return 10000;
		}
		return income*CREDIT_LIMIT_MULTIPLER;
		
	}
}

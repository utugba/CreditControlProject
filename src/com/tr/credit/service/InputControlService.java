package com.tr.credit.service;

import org.springframework.stereotype.Service;

import com.tr.credit.model.Customer;

@Service
public class InputControlService {
	public boolean checkInputs(Customer customer) {
		 return isValidTckn(customer.getTckn()) && isValidNameAndSurname(customer.getName(), customer.getSurname())
				 &&isValidIncome(customer.getIncome()); 
	 }
	 
	private boolean isValidNameAndSurname(String name, String surname) {
		return !name.isEmpty()&&!surname.isEmpty();
	}
	
	private boolean isValidIncome(Integer income) {
		return income!=null && income!=0;
	}
	 
	 private boolean isValidTckn(Long tckn) {
			try {
				String tmp = tckn.toString();
		 
				if (tmp.length() == 11) {
					int totalOdd = 0;
		 
					int totalEven = 0;
		 
					for (int i = 0; i < 9; i++) {
						int val = Integer.valueOf(tmp.substring(i, i + 1));
		 
						if (i % 2 == 0) {
							totalOdd += val;
						} else {
							totalEven += val;
						}
					}
		 
					int total = totalOdd + totalEven + Integer.valueOf(tmp.substring(9, 10));
		 
					int lastDigit = total % 10;
		 
					if (tmp.substring(10).equals(String.valueOf(lastDigit))) {
						int check = (totalOdd * 7 - totalEven) % 10;
		 
						if (tmp.substring(9, 10).equals(String.valueOf(check))) {
							return true;
						}
					}
				}
			} catch (Exception e) {
				
			}
		 
			return false;
		}
	 
	 public boolean isValidTckn(String tckn) {
			if (null!=tckn && tckn.matches("^([1-9]{1}[0-9]{10})$")) {
				return isValidTckn(Long.valueOf(tckn));
			}
		 
			return false;
		}
	
}

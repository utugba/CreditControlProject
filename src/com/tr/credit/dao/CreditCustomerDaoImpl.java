package com.tr.credit.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.hibernate.Session;

import com.tr.credit.model.Customer;

@Repository
public class CreditCustomerDaoImpl implements CreditCustomerDao {
	
	protected SessionFactory sessionFactory;
	@Override
	public void addCreditCustomerToDB(Customer customer) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	
	
}

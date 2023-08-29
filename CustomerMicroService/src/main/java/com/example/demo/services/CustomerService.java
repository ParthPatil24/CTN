package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired CustomerRepository crepo;
	
	@Autowired MongoTemplate mtem;
	
	public List<Customer> getCustomers()
	{
		return crepo.findAll();
	}
	
	public Customer saveCustomer(Customer c)
	{
		return crepo.save(c);
	}
	
	public boolean updateCustomer(String name, String number)
	{
		Query query = Query.query(Criteria.where("name").is(name));
		Update updateDefinition = new Update().set("telno", number);
		mtem.updateFirst(query, updateDefinition, Customer.class);
		return true;
	}
	
	public boolean deleteCustomer(String name)
	{

		Query query = Query.query(Criteria.where("name").is(name));
		mtem.remove(query, Customer.class);
		return true;
	}
}

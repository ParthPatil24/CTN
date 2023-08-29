package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired CustomerService cservice;
	
	
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return cservice.getCustomers();
	}
	
	@PostMapping("/save-customer")
	public ResponseEntity<?> saveCustomer(@RequestBody Customer c)
	{
		Customer customer = cservice.saveCustomer(c);
		return ResponseEntity.ok(customer);
	}
	
	@PatchMapping("/update-customer")
	public boolean updateCustomer(@RequestParam("name") String name,@RequestParam("number") String number)
	{
		return cservice.updateCustomer(name, number);
	}
	
	@DeleteMapping("/delete-customer")
	public boolean deleteCustomer(@RequestParam("name") String name)
	{
		return cservice.deleteCustomer(name);
	}
}

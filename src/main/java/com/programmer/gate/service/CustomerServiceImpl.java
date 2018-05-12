package com.programmer.gate.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.programmer.gate.model.Customer;
import com.programmer.gate.model.Timer;
import com.programmer.gate.repository.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService, CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private TimerService timerService;

	private Map<String, Long> timers = new HashMap<>();

	@Override
	public void executar(int quantidade) {
		prepararAmbiente(quantidade);
		editarCustomers();
	}

	@Transactional
	public void prepararAmbiente(int quantidade) {
		customerRepo.deleteAll();
		createNRandomCustomer(quantidade);
	}

	@Transactional
	private void editAllCustomers() {
		
		List<Customer> customers = null;
		
		do {
			
			customers = customerRepo.findByLimitGreaterThanEqual(100.0);
			
			for (Customer customer : customers) {
				editOneCustomer(customer.getId(), customer);
			}
			
		}while(customers.size() > 0);
		
		
	}

	@Transactional
	@Async
	public void editOneCustomer(Long id, Customer customer) {
		customer = customerRepo.findOne(customer.getId());
		if(customer.getLimit() > 100) {
			debitCustomer(customer, (double) 100);
		}
	}
	
	@Transactional
	@Async
	public CompletableFuture<List<Customer>> find(){
		return CompletableFuture.completedFuture(customerRepo.findByLimitGreaterThanEqual(100.0));
	}
	
	@Transactional	
	private void debitCustomer(Customer customer, Double value) {
		customer.setLimit(customer.getLimit() - value);
		customerRepo.save(customer);
	}

	private void createNRandomCustomer(int n) {
		for (int i = 0; i < n; i++) {
			createRandomCustomer();
		}
	}

	@Transactional
	private void createRandomCustomer() {
		Customer customer = new Customer(generateRandomWord(), 12099);
		customerRepo.save(customer);
	}

	private String generateRandomWord() {
		Random random = new Random();
		char[] word = new char[random.nextInt(8) + 3];
		for (int j = 0; j < word.length; j++) {
			word[j] = (char) ('a' + random.nextInt(26));
		}
		return new String(word) + " by Casseb";
	}

	@Override
	public void run(String... arg0) throws Exception {
		
	}

	@Override
	public void editarCustomers() {
		// TODO Auto-generated method stub
		
	}
}

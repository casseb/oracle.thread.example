package com.programmer.gate.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.programmer.gate.model.Customer;

public interface CustomerService {
	
	public void executar(int quantidade);
	
	public void prepararAmbiente(int quantidade);
	
	public void editarCustomers();
	
	public void editOneCustomer(Long id, Customer customer);
	
	public CompletableFuture<List<Customer>> find();
	
}

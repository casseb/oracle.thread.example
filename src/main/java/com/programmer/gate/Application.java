package com.programmer.gate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.programmer.gate.model.Customer;
import com.programmer.gate.model.Timer;
import com.programmer.gate.repository.CustomerRepository;
import com.programmer.gate.service.CustomerService;
import com.programmer.gate.service.TimerService;
import com.programmer.gate.utils.ThreadConfig;

@SpringBootApplication
@EnableAsync
public class Application {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private TimerService timerService;

	private Map<String, Long> timers = new HashMap<>();

	@Autowired
	private CustomerService customerService;
    
    private String isolation = null;
    private String threadNumber = null;
    private int thread = 0;



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	/*
	@PostConstruct
	@Transactional
	private void inicio() {
		customerService.prepararAmbiente(600);
		isolation = "READ_UNCOMMITTED";
		thread = 10;
		threadNumber = thread+ " Thread - READ_UNCOMMITTED";
	}
	
	
	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		startTimer(threadNumber);

		CompletableFuture<List<Customer>> customers = null;

		do {
			customers = customerService.find();
			for (Customer customer : customers.get()) {
				customerService.editOneCustomer(customer.getId(), customer);
			}
		} while (customers.get().size() > 0);

		stopTimer(threadNumber);
	}
	*/
	

	private void startTimer(String i) {
		Long time = System.currentTimeMillis();
		timers.put(i, time);
	}

	private void stopTimer(String i) {
		Long time = System.currentTimeMillis();
		Timer timer = new Timer(i,isolation, thread,time - timers.get(i));
		timerService.save(timer);
	}


	/*
	 * @Bean(name = "fileExecutor") public Executor asyncExecutor() { final
	 * ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	 * executor.setCorePoolSize(4); executor.setMaxPoolSize(4);
	 * executor.initialize(); return executor; }
	 */
}
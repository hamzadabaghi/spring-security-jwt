package com.youssefi;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.youssefi.entities.AppRole;
import com.youssefi.entities.AppUser;
import com.youssefi.entities.Task;
import com.youssefi.repositories.TaskRepository;
import com.youssefi.service.AccountService;

@SpringBootApplication

public class Application implements CommandLineRunner{

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	AccountService accountService;
	
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		/* users */
		
		accountService.saveUser(new AppUser(null,"admin","1234",null));
		accountService.saveUser(new AppUser(null,"user","1234",null));
		
		/* roles */
		
		accountService.saveRole(new AppRole(null,"ADMIN"));
		accountService.saveRole(new AppRole(null,"USER"));

		
		/* Affectation */ 
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("user", "USER");
		
		
		/* tasks seeder */
		
		Stream.of("T1","T2","T3").forEach(t->{
			
			taskRepository.save(new Task(null,t));
		});
		
		
	}
	
	@Bean
	
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

}

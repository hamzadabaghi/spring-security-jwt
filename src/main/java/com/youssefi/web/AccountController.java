package com.youssefi.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.youssefi.entities.AppUser;
import com.youssefi.service.AccountService;
import com.youssefi.web.requests.RegisterRequest;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterRequest user) {
	
		
		if(!user.getPassword().equals(user.getRepassword())) 
		throw new RuntimeException("les mots de passe ne sont pas pareils");
	
		AppUser oldUser = accountService.findUserByUsername(user.getUsername());
		
		if(oldUser!=null) 
		throw new RuntimeException("l\'utilisateur deja existe");
		
		
		AppUser appuser = new AppUser();
		BeanUtils.copyProperties(user, appuser);
		accountService.addRoleToUser(appuser.getUsername() , "USER");
		return accountService.saveUser(appuser);
		
		
	}
	

	

}

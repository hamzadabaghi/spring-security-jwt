package com.youssefi.web.requests;

import lombok.Data;

@Data
public class RegisterRequest {
	
	private String username;
	private String password;
	private String repassword;
	

}

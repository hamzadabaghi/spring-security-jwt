package com.youssefi.service;

import com.youssefi.entities.AppRole;
import com.youssefi.entities.AppUser;

public interface AccountService {
	
	
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username , String roleName);
	public AppUser findUserByUsername(String username);
	
	
	
}

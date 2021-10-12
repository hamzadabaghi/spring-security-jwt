package com.youssefi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youssefi.entities.AppRole;


@Repository
public interface RoleRepository  extends JpaRepository<AppRole, Long>{
	
	public AppRole findByRoleName(String roleName);
	
	
}

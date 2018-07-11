package com.agile.aggrement.invoice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agile.aggrement.invoice.model.UserRole;

/**
 * Query operations related to roles
 * 
 * @author shekhar
 *
 */
@Repository
public interface RoleRepository extends CrudRepository<UserRole, String>{

	
	
}

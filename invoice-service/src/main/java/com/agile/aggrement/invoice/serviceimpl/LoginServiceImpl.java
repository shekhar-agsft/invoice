package com.agile.aggrement.invoice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agile.aggrement.invoice.model.User;
import com.agile.aggrement.invoice.model.UserRole;
import com.agile.aggrement.invoice.repo.RoleRepository;
import com.agile.aggrement.invoice.repo.UserRepository;
import com.agile.aggrement.invoice.services.LoginService;

@Component
public class LoginServiceImpl implements LoginService {

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Override
	public User login(User user) {

		User userResponse = userRepository.findOne(user.getUsername());
		if(userResponse==null)
			return null; 
		UserRole userRole = userResponse.getUserRole();
		
		UserRole  userRoles=roleRepository.findOne(userRole.getRoleId());
		if(userRole.getRoleName().compareTo("admin")==0){
			return userResponse;
		}
		return null;
	}

}

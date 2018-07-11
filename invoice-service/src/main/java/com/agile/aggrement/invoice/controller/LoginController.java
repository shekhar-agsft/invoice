package com.agile.aggrement.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agile.aggrement.invoice.model.User;
import com.agile.aggrement.invoice.services.LoginService;
import com.agile.aggrement.invoice.util.HttpStatusCodes;
import com.agile.aggrement.invoice.util.InvoiceUtility;

import lombok.extern.java.Log;

/**
 * @author shekhar
 *
 */
@RestController
@CrossOrigin
@Log
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	InvoiceUtility invoiceUtility;
	
	@RequestMapping(value="/login", method = {RequestMethod.POST },produces={"application/json"})
	public ResponseEntity<?> login(@RequestBody User user) {
log.info("in login api"+user.toString());
User response =loginService.login(user);
		if(response!=null)
			return ResponseEntity.ok(invoiceUtility.createResponseEntityDTO(HttpStatusCodes.OK,
					"User logged in succesfully", response));
		else
			return ResponseEntity.ok(invoiceUtility.createResponseEntityDTO(HttpStatusCodes.VALIDATION_ERROR,
					"Login failed", response));
	}

}

package com.example.retry;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryController {

	@Autowired
	BillingService bb;
	
	@GetMapping(value="/test")
	public String getRetryTest() throws SQLException {
		return bb.callService();
	}
}

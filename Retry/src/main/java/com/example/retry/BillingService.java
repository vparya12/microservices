package com.example.retry;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
	private static final Logger log = LoggerFactory.getLogger(BillingService.class);

	int count = 0;
	
	@Retryable(maxAttempts=3, value= {SQLException.class}, backoff=@Backoff(delay=2000))
	public String callService() throws SQLException {
		count++;
		log.info("Fail count "+count);
		throw new SQLException("Manual SQL Exception");
	}
	
	@Recover
	public String recover() {
		log.info("Recover method");
		return "Recovering from failure";
	}
}

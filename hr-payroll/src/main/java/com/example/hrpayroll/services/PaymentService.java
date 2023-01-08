package com.example.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.example.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workedId, int days) {
		return new Payment("Bob",200.0,days);
	}
}

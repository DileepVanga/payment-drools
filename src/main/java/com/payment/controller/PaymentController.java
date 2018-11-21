package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.beans.PaymentDetailsDTO;
import com.payment.service.PaymentService;


@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/generatePaymentSlip", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentDetailsDTO> getQuestions(@RequestBody PaymentDetailsDTO paymentDetailsDTO) {
		return new ResponseEntity<PaymentDetailsDTO>(paymentService.applyRulesAfterPayment(paymentDetailsDTO), HttpStatus.OK);
	}

}

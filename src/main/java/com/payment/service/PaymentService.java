package com.payment.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.beans.PaymentDetailsDTO;

@Service
public class PaymentService {

	private final KieContainer kieContainer;

	@Autowired
	public PaymentService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public PaymentDetailsDTO applyRulesAfterPayment(PaymentDetailsDTO paymentDetailsDTO) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(paymentDetailsDTO);
		kieSession.fireAllRules();
		kieSession.dispose();
		return paymentDetailsDTO;
	}
}
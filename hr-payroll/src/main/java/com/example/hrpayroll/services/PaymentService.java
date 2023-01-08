package com.example.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;
import com.example.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	/* Utilizando RestTemplate
	 * @Value("${hr-worker.host}") private String workerHost;
	 * 
	 * @Autowired private RestTemplate restTemplate;
	 * hr-worker.host=http://localhost:8001
	

	public Payment getPayment(long workerdId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id",""+workerdId);
		Worker worker = restTemplate.getForObject(workerHost+ "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(),worker.getDailyIncome(),days);
	}
	*/
	 
	
		@Autowired
		private WorkerFeignClient workerFeignClient;
		
		public Payment getPayment(long workerId, int days) {
			
			Worker worker = workerFeignClient.findById(workerId).getBody();
			return new Payment(worker.getName(),worker.getDailyIncome(),days);
		}
		
}

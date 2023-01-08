package com.devsuperior.hrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;
	
	public List<Worker> findAll(){
		return repository.findAll();
	}
	
	public Worker findById(Long id) {
		Optional<Worker> obj = repository.findById(id);
		//O ideal seria criar o tratamento
		return obj.get();
	}
}

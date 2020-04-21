package com.anselmo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anselmo.workshopmongo.domain.User;
import com.anselmo.workshopmongo.repository.UserRepository;
import com.anselmo.workshopmongo.services.exception.ObjectNotFoudException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoudException("Objeto não encontrado"));		}
}

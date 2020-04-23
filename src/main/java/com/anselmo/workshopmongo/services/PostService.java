package com.anselmo.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anselmo.workshopmongo.domain.Post;
import com.anselmo.workshopmongo.repository.PostRepository;
import com.anselmo.workshopmongo.services.exception.ObjectNotFoudException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoudException("Objeto não encontrado"));
	}

}

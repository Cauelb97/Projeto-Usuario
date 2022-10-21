package com.example.ProjetoUsuariosBackend.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetoUsuariosBackend.exceptions.UserNotFoundException;
import com.example.ProjetoUsuariosBackend.models.User;
import com.example.ProjetoUsuariosBackend.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	public User save (User user) {		
		return userRepository.save(user);
	}


	public List<User> getUsers(){
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

	 public User getUser(Long id){
	        return userRepository.findById(id).orElseThrow(() ->
	                new UserNotFoundException(id));
	    }

	
	public User deleteUser(Long id) {
		User user = getUser(id);
		userRepository.delete(user);	
		return user;
	}

	@Transactional 
	public User editUser(Long id, User user) {
		User userToEdit = getUser(id);
		return userRepository.save(userToEdit);
	}
	 
}

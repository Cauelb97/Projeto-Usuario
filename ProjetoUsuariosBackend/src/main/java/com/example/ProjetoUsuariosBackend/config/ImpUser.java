package com.example.ProjetoUsuariosBackend.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.example.ProjetoUsuariosBackend.models.User;
import com.example.ProjetoUsuariosBackend.repository.UserRepository;

@Transactional
@Repository
public class ImpUser implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(name);
		if (user == null) {
			throw new UsernameNotFoundException("User " + name + " not found.");
		}
		return user;
	}

}

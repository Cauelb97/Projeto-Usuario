package com.example.ProjetoUsuariosBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjetoUsuariosBackend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String name);

}

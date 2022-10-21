package com.example.ProjetoUsuariosBackend.exceptions;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(Long id) {
		super(MessageFormat.format("Could not find user with id: {0}", id));
	}
}

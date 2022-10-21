package com.example.ProjetoUsuariosBackend.models;

import javax.validation.constraints.Email;

public class UserRequestModel {

private long id;
	
	private String username;
	
	private String cargo;
		
	@Email
	private String email;
	
	public static UserRequestModel from(User user) {
		UserRequestModel userRequestModel = new UserRequestModel();
		userRequestModel.setId(user.getId());
		userRequestModel.setUsername(user.getUsername());
		userRequestModel.setCargo(user.getCargo());
		userRequestModel.setEmail(user.getEmail());
		return userRequestModel;
		
	}

	public UserRequestModel() {}


	public UserRequestModel(long id, String username, String cargo,  String email) {
		this.id = id;
		this.username = username;
		this.cargo = cargo;
		this.email = email;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

package com.example.ProjetoUsuariosBackend.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


	@Entity
	@Table(name = "user")
	public class User implements Serializable, UserDetails{
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name="username")
		private String username;
		
		@Column(name="cargo")
		private String cargo;
		
		@Column(name="email")
		private String email;
		
		
		public User(long id, String username, String cargo, String email) { 
			super();
			this.id = id;
			this.cargo = cargo;
			this.email = email;
			this.username = username;

		}

		public static User from(UserRequestModel userRequestModel) {
			User user = new User();
			user.setUsername(userRequestModel.getUsername());
			user.setCargo(userRequestModel.getCargo());
			user.setEmail(userRequestModel.getEmail());
			return user;
		}

		public User() {}


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


		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return id == other.id;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}
	}

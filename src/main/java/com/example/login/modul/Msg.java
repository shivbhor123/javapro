package com.example.login.modul;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="ConMsg")
public class Msg {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	@Column(name="name")
	 private String name;
	@Column(name="email")
	    private String email;
	@Column(name="companyname")
	    private String company;
	@Column(name="msg")
	    private String message;
	
		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			return "Msg [id=" + id + ", name=" + name + ", email=" + email + ", company=" + company + ", message="
					+ message + "]";
		}
		

}

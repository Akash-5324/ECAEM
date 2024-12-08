package com.klef.jfsd.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "club_table")
public class Club 
{
	@Id // primary key = unique + not null
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	@Column(name = "club_id")
	private int id;
	@Column(name = "club_name", nullable = false, length=100)
	private String name;
	@Column(name = "club_email", nullable = false, unique = true, length=100)
	private String email;
	@Column(name = "club_password", nullable = false, unique = true, length=100)
	private String password;
	@Column(name = "club_description", nullable = false, length=300)
	private String description;
	@Column(name = "club_color", nullable = false, length=10)
	private String color;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}

package com.employee;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Table
public class Employee {

	@PrimaryKey
	private UUID id;

	private String firstName;
	private String lastName;
	private Set<String> specialties;
	private int department;
	private int section;
	private int post;
	private String username;
	private String password;

	public Employee(UUID id, String firstName, String lastName, Set<String> specialties, int department, int section, int post, String username, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialties = specialties;
		this.username = username;
		String encoded = new BCryptPasswordEncoder().encode(password);
		this.password = encoded;
	}

	public Employee(UUID id, String firstName, String lastName, Set<String> specialties, String username, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialties = specialties;
		this.department = 0;
		this.section = 0;
		this.post = 0;
		this.username = username;
		String encoded = new BCryptPasswordEncoder().encode(password);
		this.password = encoded;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getDepartment() {
		return this.department;
	}

	public int getSection() {
		return this.section;
	}

	public int getPost() {
		return this.post;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<String> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<String> specialties) {
		this.specialties = specialties;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		String encoded = new BCryptPasswordEncoder().encode(password);
		this.password = encoded;
	}
}

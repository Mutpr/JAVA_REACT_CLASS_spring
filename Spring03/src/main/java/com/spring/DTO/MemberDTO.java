package com.spring.DTO;

public class MemberDTO {
	private int id;
	private String username;
	private String password;
	private String name;
	
	public MemberDTO() {
		super();
	}
	
	public MemberDTO(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public MemberDTO (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

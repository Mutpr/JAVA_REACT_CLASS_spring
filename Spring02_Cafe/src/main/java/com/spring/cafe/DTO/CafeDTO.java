package com.spring.cafe.DTO;

public class CafeDTO {
	
	
	public CafeDTO() {
		super();
	}
	
	public CafeDTO(int id, String pname, int price) {
		this.id = id;
		this.pname = pname;
		this.price = price;
	}
	
	public CafeDTO(String pname, int price) {
		this.pname = pname;
		this.price = price;
	}
	private int id;
	private String pname;
	private int price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}

package com.spring.mybatis.dto;

public class FileDTO {
	private int seq; //seq.nextval
	private String oriname; //service 에서 추출
	private String sysname; //service 에서 생성
	private int parent_seq; //0
	public int getSeq() {
		return seq;
	}
	
	public FileDTO() {
		super();
	}
	
	public FileDTO(int seq, String oriname, String sysname, int parent_seq) {
		this.seq = seq;
		this.oriname = oriname;
		this.sysname = sysname;
		this.parent_seq = parent_seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSysname() {
		return sysname;
	}
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	
	
}

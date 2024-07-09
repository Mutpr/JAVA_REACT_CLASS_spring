package com.spring.DTO;

import java.sql.*;

public class BoardDTO {
	private int seq;
	private String title;
	private String contents;
	private int writer_seq;
	private Timestamp write_date;
	
	
	public BoardDTO() {
		super();
	}
	
	public BoardDTO(String title, String contents, int seq) {
		this.title=title;
		this.contents=contents;
		this.seq=seq;
	}
	
	public BoardDTO(int seq, String title, String contents, int writer_seq, Timestamp write_date) {
		this.seq=seq;
		this.title=title;
		this.contents=contents;
		this.writer_seq=writer_seq;
		this.write_date=write_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getWriter_seq() {
		return writer_seq;
	}
	public void setWriter_seq(int writer_seq) {
		this.writer_seq = writer_seq;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
}

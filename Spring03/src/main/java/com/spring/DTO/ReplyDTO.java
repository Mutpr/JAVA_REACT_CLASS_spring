package com.spring.DTO;

import java.sql.Timestamp;

public class ReplyDTO {
	private int seq;
	private String contents;
	private int writer_seq;
	private Timestamp write_date;
	private int post_seq;
	
	public ReplyDTO() {
		super();
	}
	
	public ReplyDTO(int seq, String contents, int writer_seq, Timestamp write_date, int post_seq) {
		this.seq = seq;
		this.contents = contents;
		this.writer_seq = writer_seq;
		this.write_date = write_date;
		this.post_seq = post_seq;
	}
	public int getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public void setWriter_date(Timestamp write_date) {
		this.write_date = write_date;
	}
}

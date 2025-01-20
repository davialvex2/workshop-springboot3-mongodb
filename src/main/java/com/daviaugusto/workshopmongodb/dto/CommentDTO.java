package com.daviaugusto.workshopmongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String text;
	private Date data;
	private PostDTO autor;
	
	public CommentDTO() {
	}

	public CommentDTO(String id, String text, Date data, PostDTO autor) {
		super();
		this.id = id;
		this.text = text;
		this.data = data;
		this.autor = autor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public PostDTO getAutor() {
		return autor;
	}

	public void setAutor(PostDTO autor) {
		this.autor = autor;
	}

}

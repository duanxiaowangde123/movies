package com.duan.pojo;

import java.util.List;

public class Type {

	private int id;
	private String name;
	private List<Movie> movies;
	
	
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
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
	
	
	public Type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", movies=" + movies + "]";
	}
	
	
}

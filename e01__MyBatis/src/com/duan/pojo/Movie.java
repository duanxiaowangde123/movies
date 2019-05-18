package com.duan.pojo;

import java.sql.Date;
public class Movie {

	private int movieId;
	private String movieName;
	private String movieDirector;
	private String movieChifeActor;
	private Date movieDate;
	private Type movieType;
	
	
	
	public Type getMovieType() {
		return movieType;
	}
	public void setMovieType(Type movieType) {
		this.movieType = movieType;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public String getMovieChifeActor() {
		return movieChifeActor;
	}
	public void setMovieChifeActor(String movieChifeActor) {
		this.movieChifeActor = movieChifeActor;
	}
	public Date getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}
	public Movie(int movieId, String movieName, String movieDirector, String movieChifeActor, Date movieDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieChifeActor = movieChifeActor;
		this.movieDate = movieDate;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDirector=" + movieDirector
				+ ", movieChifeActor=" + movieChifeActor + ", movieDate=" + movieDate + ", movieType=" + movieType
				+ "]";
	}
	
	
	
	
	
}

package com.hashedin;

import java.util.ArrayList;

public class movie {
	
	private int id;
	private String name;
	private String releaseDate;
	
	private ArrayList<Integer>genre;
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public ArrayList<Integer> getGenre() {
		return genre;
	}
	public void setGenre(ArrayList<Integer> genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "movie [id=" + id + ", name=" + name + ", releaseDate="
				+ releaseDate + ",genre=" + genre + "]";
	}
	
	
	
	
}

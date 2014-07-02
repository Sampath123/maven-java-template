package com.hashedin;

import java.util.ArrayList;
import java.util.Map;

public class movieFreak {
	Map<String, movie> movies;
	Map<String, userData> users;
	ArrayList<rating> ratings;
	
	public movieFreak(Map<String, movie> movies, Map<String, userData> users,
			ArrayList<rating> ratings) {
		this.movies=movies;
		this.users=users;
		this.ratings=ratings;
		System.out.println(movies);
		System.out.println(users);
		}
}

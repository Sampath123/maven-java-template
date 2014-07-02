package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class rating {
private int userId;
private int movieId;
private int ratingValue;

@Override
public String toString() {
	return "rating ["+ userId + "," + movieId + ","
			+ ratingValue + "]";
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getMovieId() {
	return movieId;
}
public void setMovieId(int movieId) {
	this.movieId = movieId;
}
public int getRatingValue() {
	return ratingValue;
}
public void setRatingValue(int ratingValue) {
	this.ratingValue = ratingValue;
}

public ArrayList<rating> getRatingArray(InputStream ratingStream) throws IOException {
	ArrayList<rating> ratings = new ArrayList<rating>();
		
		List<String> lines = IOUtils.readLines(ratingStream);
	     
		 
		for(String line : lines)
		{
			rating r =parseRatings(line);
			
		    ratings.add(r);
		}		 
		return ratings;
}

public rating parseRatings(String line) {
	 StringTokenizer st = new StringTokenizer(line,"\t");
  	
	rating r=new rating();
	
	  r.setUserId(Integer.parseInt(st.nextToken()));
	  r.setMovieId(Integer.parseInt(st.nextToken()));
	  r.setRatingValue(Integer.parseInt(st.nextToken()));
	   return r;   	
}

}

package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class movie {	
	private int id;
	private String name;
	private String releaseDate;
	private int totalRating;
	private int countOfRating;	
	private float avaragerating;
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
	
	public int getTotalRating() {
		return totalRating;
	}
	
	public void setTotalRating(int totalRating) {
		this.totalRating += totalRating;
	}
	
	public int getCountOfRating() {
		return countOfRating;
	}
	public void setCountOfRating(int countOfRating) {
		this.countOfRating += countOfRating;
	}
	
	@Override
	public String toString() {
		return "movie [id=" + id + ", name=" + name + ", releaseDate="
				+ releaseDate + ", totalRating=" + totalRating
				+ ", countOfRating=" + countOfRating + ", avaragerating="
				+ avaragerating + ", genre=" + genre + "]";
	}

	public Map<String,movie> getMovieMap(InputStream movieStream) throws IOException{
		 Map <String,movie> movies = new HashMap<>() ;
		 List<String> lines = IOUtils.readLines(movieStream);
	    for(String line : lines){
		 	movie m=parseMovie(line);
		    movies.put(Integer.toString(m.getId()), m);
		 }		 
		return movies;		 
	 }	 
	
   public movie parseMovie(String movie){		 
		 StringTokenizer st = new StringTokenizer(movie,"|");	
	        	  movie m=new movie();	        	
	        	  m.setId(Integer.parseInt(st.nextToken()));
    	          m.setName(st.nextToken());
    	          m.setReleaseDate(st.nextToken());
                  st.nextToken();
    	          
	       ArrayList<Integer>genreList=new ArrayList<>();	        	 
	        	while (st.hasMoreTokens()) {	        		
	        		genreList.add(Integer.parseInt(st.nextToken()));
	        	 }
	               m.setGenre(genreList);
    	         return m;   	                	 
		 
	 }

public float getAvaragerating() {
	return avaragerating;
}

public void setAvaragerating(float avaragerating) {
	this.avaragerating = avaragerating;
}
	 
	
	
}

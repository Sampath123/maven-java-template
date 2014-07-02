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
	private ArrayList<String>genre;
	
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
	
	public ArrayList<String> getGenre() {
		return genre;
	}
	public void setGenre(ArrayList<String> genre) {
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
                  int i=0;
	       ArrayList<String>genreList=new ArrayList<>();	        	 
	        	while (st.hasMoreTokens()) {	
	        		
	        		
	        		if(Integer.parseInt(st.nextToken())==1){
	                switch (i) {
	                    case 0:  genreList.add("unknown");
	                             break;
	                    case 1:  genreList.add("Action");
	                             break;
	                    case 2:  genreList.add("Adventure");
	                             break;
	                    case 3:  genreList.add("Animation");
	                             break;
	                    case 4:  genreList.add("Children");
	                             break;
	                    case 5:  genreList.add("Comedy");
	                             break;
	                    case 6:  genreList.add("Crime");
	                             break;
	                    case 7:  genreList.add("Documentary");
	                             break;
	                    case 8:  genreList.add("Drama");
	                             break;
	                    case 9:  genreList.add("Fantasy");
	                             break;
	                    case 10: genreList.add("Film-Noir");
	                             break;
	                    case 11: genreList.add("Horror");
	                             break;
	                    case 12: genreList.add("Musical|12");
	                             break;
	                    case 13: genreList.add("Mystery");
                                 break;
	                    case 14: genreList.add("Romance");
                                 break;
	                    case 15: genreList.add("Sci-Fi");
                                 break;
	                    case 16: genreList.add("Thriller");
                                 break;
	                    case 17: genreList.add("War");
                                 break;
	                    case 18: genreList.add("Western");
                                 break;
	                 }
	        		}
	        		i++;
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

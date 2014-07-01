package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class movieManager {
	
	
	 
	 public Map<String,movie> getMovieMap(InputStream movieStream) throws IOException{
			
		 Map <String,movie> movies = new HashMap<>() ;
		
		List<String> lines = IOUtils.readLines(movieStream);
	     
		 
		for(String line : lines)
		{
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
     	          st.nextToken();
     	          
 	        	 ArrayList<Integer>genreList=new ArrayList<>();
 	        	 
 	        	while (st.hasMoreTokens()) {
 	        		
 	        		genreList.add(Integer.parseInt(st.nextToken()));
 	        	}
 	   m.setGenre(genreList);
     	          
     	         return m;   	                	 
		 
	 }
	 
	 
	 private Map<String, userData> getUserMap(InputStream userDataStream) throws IOException {
			
		 Map<String, userData> users = new HashMap<>() ;
			
			List<String> lines = IOUtils.readLines(userDataStream);
		     
			 
			for(String line : lines)
			{
				userData u=parseUser(line);
			    users.put(Integer.toString(u.getuId()), u);
			}
			 
			return users;
			 
			
		}  
	
	
	
	private userData parseUser(String line) {
		 StringTokenizer st = new StringTokenizer(line,"|");
       	
     	userData u=new userData();
     	
     	  u.setuId(Integer.parseInt(st.nextToken()));	         	                   
	         return u;   
		
	}

	
	private ArrayList<rating> getRatingArray(InputStream ratingStream) throws IOException {
		ArrayList<rating> ratings = new ArrayList<rating>();
			
			List<String> lines = IOUtils.readLines(ratingStream);
		     
			 
			for(String line : lines)
			{
				rating r =parseRatings(line);
				
			    ratings.add(r);
			}
			 
			return ratings;
			 
		
		
	}
	
	private rating parseRatings(String line) {
		 StringTokenizer st = new StringTokenizer(line,"\t");
      	
    	rating r=new rating();
    	
    	  r.setUserID(Integer.parseInt(st.nextToken()));
    	  r.setItemID(Integer.parseInt(st.nextToken()));
    	  r.setRatingValue(Integer.parseInt(st.nextToken()));
    	  
	         return r;   
		
	}


	
	
	
	
	public static void main( String[] args ) throws ClassNotFoundException, IOException
    { 
		
        movieManager mm=new movieManager();
    
        // for movie data
     InputStream movieStream = mm.getClass().getClassLoader().getResourceAsStream("movie.data");   
   
     Map<String, movie> movies =mm.getMovieMap(movieStream);
     System.out.println(movies);
     
     System.out.println("\n");
     System.out.println("\n");
     
     
     // For user data
     
     InputStream userDataStream = mm.getClass().getClassLoader().getResourceAsStream("user.data");
      Map<String, userData> users =mm.getUserMap(userDataStream);
     System.out.println(users);
     System.out.println("\n");
     
     //for Rating
     
     InputStream ratingStream = mm.getClass().getClassLoader().getResourceAsStream("ratings.data");
     ArrayList<rating> ratings =mm.getRatingArray(ratingStream);
    System.out.println(ratings);
     
	
    System.out.println("\n");
    
}

	

	
}
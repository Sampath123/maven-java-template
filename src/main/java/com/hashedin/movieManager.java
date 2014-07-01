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
			movie m=parse(line);
		    movies.put(Integer.toString(m.getId()), m);
		}
		 
		return movies;
		 
	 }
	 
	 public movie parse(String movie){
		 
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
 	   
     	          
     	         return m;
     	          
         
	        	 
		 
	 }
	 
	 
	
	
	
	public static void main( String[] args ) throws ClassNotFoundException, IOException
    { 
		
        movieManager mm=new movieManager();
      // input stream
     InputStream movieStream = mm.getClass().getClassLoader().getResourceAsStream("movie.data");
     
   
     Map<String, movie> movies =mm.getMovieMap(movieStream);
     System.out.println(movies);
   
	
	
}
}
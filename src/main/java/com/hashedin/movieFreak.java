package com.hashedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
		//System.out.println(movies);
		//System.out.println(users);
		}

	public userData getActiveUser() {
		List<userData> userList = new ArrayList<userData>(users.values());  
	    
	    userData mostActiveUser = Collections.max(userList, new Comparator<userData>() {
	        @Override
	        public int compare(userData first,userData second) {
	            if (first.getRatingCount() > second.getRatingCount())
	                return 1;
	            else if (first.getRatingCount() < second.getRatingCount())
	                return -1;
	            return 0;
	        }
	    });
		return mostActiveUser; 
	}	
	public movie getWatchedMovie() {
    List<movie> movieList = new ArrayList<movie>(movies.values());   
    movie mostWatchedMovie = Collections.max(movieList, new Comparator<movie>() {
	        @Override
	        public int compare(movie first,movie second) {
	            if (first.getCountOfRating() > second.getCountOfRating())
	                return 1;
	            else if (first.getCountOfRating() < second.getCountOfRating())
	                return -1;
	            return 0;
	        }
	    });
		return mostWatchedMovie; 
	}

	public movie getTopMovie() {
		List<movie> movieList = new ArrayList<movie>(movies.values());   
	     movie topMovie = Collections.max(movieList, new Comparator<movie>() {
		        @Override
		        public int compare(movie first,movie second) {
		         if (first.getAvaragerating() > second.getAvaragerating())
		              return 1;
		            else if (first.getAvaragerating() < second.getAvaragerating())
		                return -1;
		            return 0;
		        }
		    });
			return topMovie; 
	}

	public movie getTopMovie(List<movie> yearWiseList) {
	List<movie> movieList = new ArrayList<movie>(yearWiseList);	   
     movie topMovie = Collections.max(movieList, new Comparator<movie>() {
	        @Override
	        public int compare(movie first,movie second) {
	            if (first.getAvaragerating() > second.getAvaragerating())
	                return 1;
	            else if (first.getAvaragerating() < second.getAvaragerating())
                 return -1;
	            return 0;
		        }
		    });
			return topMovie; 
	}

	public movie getTopMovieByGenre(String genreType) {
		String thisGenre=genreType;

		List<movie> movieListForGenre = new ArrayList<movie>(movies.values());
	  
	    
	       List<movie>genreWiseList=new ArrayList<>();         	  
	        	    	  
	        	for(movie movieByGenre:movieListForGenre){
	    		if(movieByGenre.getGenre().contains(thisGenre)){
	    			genreWiseList.add(movieByGenre);
	    		 }
	    	    }
	        	if (genreWiseList != null && !genreWiseList.isEmpty()){
	               return getTopMovie(genreWiseList);
	        	}
	        	else	        	
				return null;
	}
}

package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class movieManager {

	public static void main( String[] args ) throws ClassNotFoundException, IOException
    { 
		
        movieManager mm=new movieManager();       
     // for movie data
     movie m=new movie();
     InputStream movieStream = mm.getClass().getClassLoader().getResourceAsStream("movie.data");   
     Map<String, movie> movies =m.getMovieMap(movieStream);
    // System.out.println(movies);
        
     // For user data
     userData u= new userData();     
     InputStream userDataStream = mm.getClass().getClassLoader().getResourceAsStream("user.data");
     Map<String, userData> users =u.getUserMap(userDataStream);
     //System.out.println(users);
    
     //for Rating
     rating r=new rating();     
     InputStream ratingStream = mm.getClass().getClassLoader().getResourceAsStream("ratings.data");
     ArrayList<rating> ratings =r.getRatingArray(ratingStream);
     // System.out.println(ratings);

     
    //for genre      
//    genreClass g=new genreClass();
//    InputStream genreStream = mm.getClass().getClassLoader().getResourceAsStream("genre.data");
//    Map<String, String> genres =g.getGenreMap(genreStream);
//    System.out.println(genres);
//    System.out.println("\n");
  
     
    
    // now we have movies,users,rating
    //use ratings add ratingCount for user and add totalRating & countOfRating to movie
    
    for(rating ratingObj :ratings ) {
    	movie movieObj=movies.get(Integer.toString(ratingObj.getMovieId()));
    	movieObj.setCountOfRating(1);
    	movieObj.setTotalRating(ratingObj.getRatingValue());
    	userData ud=users.get(Integer.toString(ratingObj.getUserId()));
    	ud.setRatingCount(1);
    }
   //  System.out.println(movies);
    //System.out.println(users);
    
    movieFreak mf=new movieFreak(movies,users,ratings);
    //mf.getActiveUser();
   
    

}	
}
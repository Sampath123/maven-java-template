package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class movieManager {

	private static movie movieObj1;

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
     movie movieObj;
    for(rating ratingObj :ratings ) {
    	movieObj=movies.get(Integer.toString(ratingObj.getMovieId()));
    	movieObj.setCountOfRating(1);
    	movieObj.setTotalRating(ratingObj.getRatingValue());
    	userData ud=users.get(Integer.toString(ratingObj.getUserId()));
    	ud.setRatingCount(1);
    }
   //System.out.println(movies);
    //System.out.println(users);
    
    //pass movies,users list,rating list to movie freak
    movieFreak mf=new movieFreak(movies,users,ratings);
    
    
    List<movie> movieList = new ArrayList<movie>(movies.values());
	   for(movie mList:movieList){
		   mList.setAvaragerating((float)(mList.getTotalRating())/mList.getCountOfRating());;
		   
	   }
    
    //call activeUser function and get most active user
    userData mostActiveUser=mf.getActiveUser();
    //display Most Active User
    System.out.println("1.Most Active User:Unknown");
    System.out.println("ID:"+mostActiveUser.getuId()+ " and Total Ratings made:"+mostActiveUser.getRatingCount());
    
    
    //get most watched movie
    movie mostWatchedMovie=mf.getWatchedMovie();
    System.out.println("\n2.Most watched movie="+mostWatchedMovie.getName());
    System.out.println("Movie Id : "+mostWatchedMovie.getId());
    System.out.println("Movie Release Date :"+mostWatchedMovie.getReleaseDate());
    System.out.println("Total rating :"+mostWatchedMovie.getTotalRating()+" made by "+mostWatchedMovie.getCountOfRating());
    System.out.println("Genre : "+ mostWatchedMovie.getGenre());
    System.out.println("Average Rating : "+mostWatchedMovie.getAvaragerating());
    
    //Top Movie
    movie topMovie=mf.getTopMovie();
    System.out.println("\n3.Top Movie : "+topMovie.getName()+ " Id : "+topMovie.getId());
    System.out.print("Average Rating : "+topMovie.getAvaragerating());
    System.out.println(" made by "+topMovie.getCountOfRating()+" users");
    System.out.println("Genre :"+topMovie.getGenre());
    
    
      //top movie by year
    // am taking only  movies between 1990 to 2000
    System.out.println("\nTop year By Year");
    List<movie> movieListForYear = new ArrayList<movie>(movies.values());
    int year=1970;
    for(int i=0;i<30;i++)
    {    List<movie>yearWiseList=new ArrayList<>(); 
        	  
        	   year++;
        	  
        	for(movie movieByYear:movieListForYear){
    		if(movieByYear.getName().contains(Integer.toString(year))){
    			yearWiseList.add(movieByYear);
    		 }
    	    }
        	if (yearWiseList != null && !yearWiseList.isEmpty()){
         movie topMovieByYear=mf.getTopMovie(yearWiseList);
         System.out.println("Year "+year+" : \nName : "+topMovieByYear.getName());
         System.out.println("Total rating :"+topMovieByYear.getTotalRating()+" made by "+topMovieByYear.getCountOfRating());
         System.out.println("Genre : "+ topMovieByYear.getGenre());
         System.out.println("Average Rating : "+topMovieByYear.getAvaragerating());
         
        	}
    	
    }

}	
}
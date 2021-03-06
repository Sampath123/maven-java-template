package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void testApp() throws IOException
    {
       movieManager mm=new movieManager();
       movie m=new movie();    	    
          // for movie data
       InputStream movieStream = mm.getClass().getClassLoader().getResourceAsStream("movie.data");   
       Map<String, movie> movies =m.getMovieMap(movieStream);
       assertEquals(2,movies.size());
       
    }
    public void testApp1() throws IOException
    {
    	movie m=new movie();
    	movieManager mm=new movieManager();    	
       // For user data
       userData u= new userData();     
       InputStream userDataStream = mm.getClass().getClassLoader().getResourceAsStream("user.data");
       Map<String, userData> users =u.getUserMap(userDataStream);
       assertEquals(943, users.size());
          
    }
   
}

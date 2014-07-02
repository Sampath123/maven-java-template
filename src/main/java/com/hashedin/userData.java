package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.io.IOUtils;

public class userData {
	private int uId;
	private int ratingCount; 

	@Override
	public String toString() {
		return "userData [uId=" + uId + ", ratingCount=" + ratingCount + "]";
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int i) {
		this.uId = i;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount += ratingCount;
	}
		
	public  Map<String, userData> getUserMap(InputStream userDataStream) throws IOException {
		
		 Map<String, userData> users = new HashMap<>() ;
			
			List<String> lines = IOUtils.readLines(userDataStream);	     
			 
			for(String line : lines)
			{
				userData u=parseUser(line);
			    users.put(Integer.toString(u.getuId()), u);
			}			 
			return users;
			 		
		}  		
	public userData parseUser(String line) {
		 StringTokenizer st = new StringTokenizer(line,"|");
       	 userData u=new userData();
    	 u.setuId(Integer.parseInt(st.nextToken()));	         	                   
	        return u;   
		
	}
}

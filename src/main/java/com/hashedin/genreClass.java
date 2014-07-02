package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class genreClass {
	private int genreId;
	private String genreName;
	
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	@Override
	public String toString() {
		return "genreClass [genreId=" + genreId + ", genreName=" + genreName
				+ "]";
	}	
	public Map<String, String> getGenreMap(InputStream genreStream) throws IOException {
		Map<String,String> genres=new HashMap<>();
		List<String>lines=IOUtils.readLines(genreStream);
		for (String line: lines){
		genreClass g=parseGenre(line);
		genres.put(Integer.toString(g.getGenreId()),g.getGenreName());			
		}
		return genres;					
	}	
	public genreClass parseGenre(String line) {
		StringTokenizer st=new StringTokenizer(line, "|");
		genreClass g=new genreClass();
		g.setGenreId(Integer.parseInt(st.nextToken()));
		g.setGenreName(st.nextToken());
		return g;
	}

}

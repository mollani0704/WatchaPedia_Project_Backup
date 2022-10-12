package com.project.watchapedia.domain.contents;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentsRepository {
	public List<Movie> getMovieLists() throws Exception;
	public List<Movie> getMovie(Map<String, Object> map) throws Exception;
	public List<Movie> getMoviePeopleList(Map<String, Object> map) throws Exception;
	public List<Movie> getSimilarMovieList(Map<String, Object> map) throws Exception;
	
	public List<Drama> getDramaLists() throws Exception;
	public List<Drama> getDrama(Map<String, Object> map) throws Exception;
	public List<Drama> getDramaPeopleList(Map<String, Object> map) throws Exception;
	public List<Drama> getSimilarDramaList(Map<String, Object> map) throws Exception;
	
	public List<Book> getBookLists() throws Exception;
	public List<Book> getBook(Map<String, Object> map) throws Exception;

}

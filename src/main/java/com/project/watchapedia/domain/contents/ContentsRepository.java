package com.project.watchapedia.domain.contents;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentsRepository {
	public List<Movie> getMovieLists() throws Exception;
	public List<Movie> getMovie(Map<String, Object> map) throws Exception;
	public List<Movie> getMoviePeopleList(Map<String, Object> map) throws Exception;
	public List<Drama> getDramaLists() throws Exception;
}

package com.project.watchapedia.domain.movie;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieRatingRepository {
	public int insertMovieRating(MovieRating movieRating) throws Exception;
	public MovieRating getMovieRating(Map<String, Object> map) throws Exception;
}

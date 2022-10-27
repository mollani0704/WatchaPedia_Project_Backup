package com.project.watchapedia.service.movie;

import com.project.watchapedia.web.controller.dto.movie.MovieRatingReqDto;

public interface MovieRatingService {
	public boolean insertMovieRating(MovieRatingReqDto movieRatingReqDto) throws Exception;
	public MovieRatingReqDto getMovieRating(int movieCode, int userCode) throws Exception;
}

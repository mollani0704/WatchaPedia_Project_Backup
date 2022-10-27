package com.project.watchapedia.domain.movie;

import com.project.watchapedia.web.controller.dto.movie.MovieRatingReqDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieRating {
	private int movie_code;
	private int user_code;
	private float rating_score;
	
	public MovieRatingReqDto toMovieRatingReqDto() {
		return MovieRatingReqDto.builder()
					.movieCode(movie_code)
					.userCode(user_code)
					.ratingScore(rating_score)
					.build();
	}
}

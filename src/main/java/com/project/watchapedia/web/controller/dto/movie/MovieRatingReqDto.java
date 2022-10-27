package com.project.watchapedia.web.controller.dto.movie;

import com.project.watchapedia.domain.movie.MovieRating;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieRatingReqDto {
	private int movieCode;
	private int userCode;
	private float ratingScore;
	
	public MovieRating toMovieRatingEntity() {
		return MovieRating.builder()
					.movie_code(movieCode)
					.user_code(userCode)
					.rating_score(ratingScore)
					.build();
	}
}

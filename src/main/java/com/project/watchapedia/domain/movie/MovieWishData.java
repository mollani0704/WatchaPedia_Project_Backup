package com.project.watchapedia.domain.movie;

import com.project.watchapedia.web.controller.dto.movie.GeMovietWishDataRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieWishData {
	private int user_code;
	private int movie_code;
	private String movie_title;
	private String movie_year;
	private String movie_origin;
	private String movie_poster;
	
	public GeMovietWishDataRespDto toWishDataDto() {
		return GeMovietWishDataRespDto.builder()
					.userCode(user_code)
					.movieCode(movie_code)
					.movieTitle(movie_title)
					.movieYear(movie_year)
					.movieOrigin(movie_origin)
					.moviePoster(movie_poster)
					.build();
		}
	
}

package com.project.watchapedia.domain.contents;

import com.project.watchapedia.web.controller.dto.contents.GetMovieListResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	private int movie_code;
	private String movie_title;
	private String movie_year;
	private String movie_origin;
	private String movie_sales;
	private float movie_rate;
	private String movie_genre;
	private String movie_age;
	private String movie_content;
	private String movie_poster;
	
	public GetMovieListResponseDto toListDto() {
		return GetMovieListResponseDto.builder()
					.movieCode(movie_code)
					.movieTitle(movie_title)
					.movieYear(movie_year)
					.movieOrigin(movie_origin)
					.movieSales(movie_sales)
					.movieRate(movie_rate)
					.movieGenre(movie_genre)
					.movieAge(movie_age)
					.moviePoster(movie_poster)
					.build();
	}
}

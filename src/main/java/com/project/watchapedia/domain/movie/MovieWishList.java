package com.project.watchapedia.domain.movie;

import com.project.watchapedia.web.controller.dto.movie.GetMovieWishListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieWishList {
	private int user_code;
	private int movie_code;
	
	public GetMovieWishListRespDto toWishListDto() {
		return GetMovieWishListRespDto.builder()
					.userCode(user_code)
					.movieCode(movie_code)
					.build();
	}
	
}

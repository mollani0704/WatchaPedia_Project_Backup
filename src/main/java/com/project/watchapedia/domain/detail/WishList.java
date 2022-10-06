package com.project.watchapedia.domain.detail;

import com.project.watchapedia.web.controller.dto.detail.GetWishListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishList {
	private int user_code;
	private int movie_code;
	
	public GetWishListRespDto toWishListDto() {
		return GetWishListRespDto.builder()
					.userCode(user_code)
					.movieCode(movie_code)
					.build();
	}
	
}

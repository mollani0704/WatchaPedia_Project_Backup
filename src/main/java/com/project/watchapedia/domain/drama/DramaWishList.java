package com.project.watchapedia.domain.drama;

import com.project.watchapedia.web.controller.dto.drama.GetDramaWishListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DramaWishList {
	private int user_code;
	private int drama_code;
	
	public GetDramaWishListRespDto toDramaWishListDto() {
		return GetDramaWishListRespDto.builder()
					.userCode(user_code)
					.dramaCode(drama_code)
					.build();
	}
}

package com.project.watchapedia.domain.drama;

import com.project.watchapedia.web.controller.dto.drama.GetDramaWishDataRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DramaWishData {
	private int user_code;
	private int drama_code;
	private String drama_title;
	private String drama_year;
	private String drama_company;
	private String drama_poster;
	
	public GetDramaWishDataRespDto toDramaWishDataDto() {
		return GetDramaWishDataRespDto.builder()
					.userCode(user_code)
					.dramaCode(drama_code)
					.dramaTitle(drama_title)
					.dramaYear(drama_year)
					.dramaCompany(drama_company)
					.dramaPoster(drama_poster)
					.build();
	}
}

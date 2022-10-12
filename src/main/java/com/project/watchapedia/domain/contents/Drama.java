package com.project.watchapedia.domain.contents;

import com.project.watchapedia.web.controller.dto.contents.GetDramaListResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drama {
	private int drama_code;
	private String drama_title;
	private String drama_year;
	private String drama_company;
	private float drama_rate;
	private String drama_genre;
	private String drama_age;
	private String drama_content;
	private String drama_poster;
	private String drama_banner;
	private int person_code;
	private String person_name;
	private String person_img;
	
	
	public GetDramaListResponseDto toDramaListDto() {
		return GetDramaListResponseDto.builder()
				.dramaCode(drama_code)
				.dramaTitle(drama_title)
				.dramaYear(drama_year)
				.dramaCompany(drama_company)
				.dramaRate(drama_rate)
				.dramaGenre(drama_genre)
				.dramaAge(drama_age)
				.dramaContent(drama_content)
				.dramaPoster(drama_poster)
				.dramaBanner(drama_banner)
				.build();
	}
	
	
}

package com.project.watchapedia.web.controller.dto.contents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMoviePeopleResponseDto {
	private int movieCode;
	private int personCode;
	private String personName;
	private String personImg;
}

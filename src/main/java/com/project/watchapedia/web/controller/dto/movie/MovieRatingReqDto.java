package com.project.watchapedia.web.controller.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieRatingReqDto {
	private String movieCode;
	private String userCode;
	private float ratingScore;
}

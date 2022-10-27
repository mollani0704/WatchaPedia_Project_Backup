package com.project.watchapedia.web.controller.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeMovietWishDataRespDto {
	private int userCode;
	private int movieCode;
	private String movieTitle;
	private String movieYear;
	private String movieOrigin;
	private String moviePoster;
}

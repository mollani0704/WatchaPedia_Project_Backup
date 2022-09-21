package com.project.watchapedia.web.controller.dto.contents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMovieResponseDto {
	private int movieCode;
	private String movieTitle;
	private String movieYear;
	private String movieOrigin;
	private String movieSales;
	private float movieRate;
	private String movieGenre;
	private String movieAge;
	private String movieContent;
	private String moviePoster;
}

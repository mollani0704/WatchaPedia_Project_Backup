package com.project.watchapedia.web.controller.dto.contents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetSimilarDramaListResponseDto {
	private int dramaCode;
	private String dramaTitle;
	private String dramaYear;
	private String dramaCompany;
	private String dramaGenre;
	private String dramaPoster;

}

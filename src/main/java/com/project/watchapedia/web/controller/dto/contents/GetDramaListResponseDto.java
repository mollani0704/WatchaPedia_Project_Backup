package com.project.watchapedia.web.controller.dto.contents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetDramaListResponseDto {
	private int dramaCode;
	private String dramaTitle;
	private String dramaYear;
	private String dramaCompany;
	private float dramaRate;
	private String dramaGenre;
	private String dramaAge;
	private String dramaContent;
	private String dramaPoster;
}

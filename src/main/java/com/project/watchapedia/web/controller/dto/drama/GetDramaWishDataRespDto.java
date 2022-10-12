package com.project.watchapedia.web.controller.dto.drama;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetDramaWishDataRespDto {
	private int userCode;
	private int dramaCode;
	private String dramaTitle;
	private String dramaYear;
	private String dramaCompany;
	private String dramaPoster;
}

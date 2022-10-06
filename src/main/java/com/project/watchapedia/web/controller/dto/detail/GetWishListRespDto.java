package com.project.watchapedia.web.controller.dto.detail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetWishListRespDto {
	private int userCode;
	private int movieCode;
}

package com.project.watchapedia.web.controller.dto.drama;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetDramaWishListRespDto {
	private int userCode;
	private int dramaCode;
}

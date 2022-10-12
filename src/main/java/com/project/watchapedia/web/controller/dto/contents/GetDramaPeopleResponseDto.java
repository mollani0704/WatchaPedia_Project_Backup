package com.project.watchapedia.web.controller.dto.contents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetDramaPeopleResponseDto {
	private int dramaCode;
	private int personCode;
	private String personName;
	private String personImg;
}

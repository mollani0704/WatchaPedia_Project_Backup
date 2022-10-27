package com.project.watchapedia.web.controller.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetMovieCommentListRespDto {
	private int userCode;
	private int movieCode;
	private String userName;
	private String comment;
	
}

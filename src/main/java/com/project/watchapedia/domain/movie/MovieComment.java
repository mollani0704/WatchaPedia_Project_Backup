package com.project.watchapedia.domain.movie;

import com.project.watchapedia.web.controller.dto.movie.GetMovieCommentListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieComment {
	private int user_code;
	private int movie_code;
	private String user_name;
	private String comment;
	
	public GetMovieCommentListRespDto toMovieCommentDataDto() {
		return GetMovieCommentListRespDto.builder()
					.userCode(user_code)
					.movieCode(movie_code)
					.userName(user_name)
					.comment(comment)
					.build();
	}
}

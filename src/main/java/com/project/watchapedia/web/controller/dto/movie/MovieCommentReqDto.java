package com.project.watchapedia.web.controller.dto.movie;

import com.project.watchapedia.domain.movie.MovieComment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieCommentReqDto {
	private int userCode;
	private int movieCode;
	private String comment;
	
	public MovieComment toEntity() {
		return MovieComment.builder()
					.user_code(userCode)
					.movie_code(movieCode)
					.comment(comment)
					.build();
	}
}

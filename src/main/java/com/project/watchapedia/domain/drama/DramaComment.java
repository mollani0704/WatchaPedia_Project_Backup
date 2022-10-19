package com.project.watchapedia.domain.drama;

import com.project.watchapedia.web.controller.dto.drama.DramaCommentReqDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DramaComment {
	private int user_code;
	private int drama_code;
	private String user_name;
	private String drama_comment;
	
	public DramaCommentReqDto toDramaCommentReqDto() {
		return DramaCommentReqDto.builder()
					.userCode(user_code)
					.dramaCode(drama_code)
					.userName(user_name)
					.dramaComment(drama_comment)
					.build();
	}
}

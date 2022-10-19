package com.project.watchapedia.web.controller.dto.drama;

import com.project.watchapedia.domain.drama.DramaComment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DramaCommentReqDto {
	private int userCode;
	private int dramaCode;
	private String userName;
	private String dramaComment;
	
	public DramaComment toDramaCommentEntity() {
		return DramaComment.builder()
				.user_code(userCode)
				.drama_code(dramaCode)
				.user_name(userName)
				.drama_comment(dramaComment)
				.build();
	}
	
}

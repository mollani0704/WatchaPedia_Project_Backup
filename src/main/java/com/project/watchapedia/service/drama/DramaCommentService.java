package com.project.watchapedia.service.drama;

import com.project.watchapedia.web.controller.dto.drama.DramaCommentReqDto;

public interface DramaCommentService {
	public boolean insertDramaComment(DramaCommentReqDto dramaCommentReqDto) throws Exception;
}

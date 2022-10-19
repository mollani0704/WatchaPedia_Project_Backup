package com.project.watchapedia.service.drama;

import java.util.List;

import com.project.watchapedia.web.controller.dto.drama.DramaCommentReqDto;

public interface DramaCommentService {
	public boolean insertDramaComment(DramaCommentReqDto dramaCommentReqDto) throws Exception;
	public List<DramaCommentReqDto> getDramaComment(int dramaCode) throws Exception;
}

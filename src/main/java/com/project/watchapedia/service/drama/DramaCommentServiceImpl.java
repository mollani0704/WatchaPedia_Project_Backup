package com.project.watchapedia.service.drama;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.drama.DramaCommentRepository;
import com.project.watchapedia.web.controller.dto.drama.DramaCommentReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DramaCommentServiceImpl implements DramaCommentService{

	private final DramaCommentRepository dramaCommentRepository;
	
	@Override
	public boolean insertDramaComment(DramaCommentReqDto dramaCommentReqDto) throws Exception {
		
		return dramaCommentRepository.insertDramaComment(dramaCommentReqDto.toDramaCommentEntity()) > 0;
	}

	@Override
	public List<DramaCommentReqDto> getDramaComment(int dramaCode) throws Exception {
		
		List<DramaCommentReqDto> dramaCommentList = new ArrayList<DramaCommentReqDto>();
		
		dramaCommentRepository.getDramaComment(dramaCode).forEach(comment -> {
			dramaCommentList.add(comment.toDramaCommentReqDto());
		});
		
		return dramaCommentList;
	}

}

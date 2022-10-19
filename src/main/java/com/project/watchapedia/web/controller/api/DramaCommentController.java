package com.project.watchapedia.web.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.watchapedia.service.drama.DramaCommentService;
import com.project.watchapedia.web.controller.dto.CMRespDto;
import com.project.watchapedia.web.controller.dto.drama.DramaCommentReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/comment/drama")
@RequiredArgsConstructor
public class DramaCommentController {
	
	private final DramaCommentService dramaCommentService;
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertDramaComment(@RequestBody DramaCommentReqDto dramaCommentReqDto) {
		
		boolean status = false;
		
		try {
			status = dramaCommentService.insertDramaComment(dramaCommentReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "드라마 Comment 입력 실패", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "드라마 Comment 입력 성공", status));
		
	}
	
	@GetMapping("/select/{dramaCode}")
	public ResponseEntity<?> getDramaComment(@PathVariable int dramaCode) {
		
		List<DramaCommentReqDto> dramaCommentList = new ArrayList<DramaCommentReqDto>();
		
		try {
			dramaCommentList = dramaCommentService.getDramaComment(dramaCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "드라마 코멘트 불러오기 실패", dramaCommentList));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "드라마 코멘트 불러오기 성공", dramaCommentList));
	}
	
	
}

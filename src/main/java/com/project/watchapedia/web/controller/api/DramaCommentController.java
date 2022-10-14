package com.project.watchapedia.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.watchapedia.web.controller.dto.drama.DramaCommentReqDto;

@RestController
@RequestMapping("/api/v1/comment/drama")
public class DramaCommentController {
	
	@GetMapping("/insert")
	public ResponseEntity<?> insertDramaComment(@RequestBody DramaCommentReqDto dramaCommentReqDto) {
		
		return ResponseEntity.ok().body(null);
		
	}
	
}

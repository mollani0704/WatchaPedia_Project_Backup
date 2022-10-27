package com.project.watchapedia.web.controller.api.movie;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.watchapedia.service.movie.MovielService;
import com.project.watchapedia.web.controller.dto.CMRespDto;
import com.project.watchapedia.web.controller.dto.movie.GetMovieCommentListRespDto;
import com.project.watchapedia.web.controller.dto.movie.MovieCommentReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class MovieCommentController {
	
	private final MovielService movielService;
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertComment(@RequestBody MovieCommentReqDto movieCommentReqDto) {
		
		boolean status = false;
		
		try {
			status = movielService.insertComment(movieCommentReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "코멘트 입력 실패", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "코멘트 입력 성공", status));
	}
	
	@GetMapping("/select/{movieCode}")
	public ResponseEntity<?> getComment(@PathVariable int movieCode) {
		
		List<GetMovieCommentListRespDto> movieCommentDtoList = null;
		
		try {
			movieCommentDtoList = movielService.getMovieCommentList(movieCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "영화 코멘트 불러오기 실패",movieCommentDtoList ));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "영화 코멘트 불러오기 성공", movieCommentDtoList));
	}
	
}

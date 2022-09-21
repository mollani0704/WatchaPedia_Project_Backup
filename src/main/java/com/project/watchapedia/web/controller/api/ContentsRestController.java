package com.project.watchapedia.web.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.watchapedia.service.ContentsService;
import com.project.watchapedia.web.controller.dto.CMRespDto;
import com.project.watchapedia.web.controller.dto.contents.GetMovieListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMovieResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/content")
@RequiredArgsConstructor
public class ContentsRestController {
	
	private final ContentsService contentsService;
	
	@GetMapping("/movie")
	public ResponseEntity<?> getMovieList() {
		
		List<GetMovieListResponseDto> listDto = null;
		
		try {
			listDto = contentsService.getMovieList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", listDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", listDto));
	}
	
	@GetMapping("/movie/{movieCode}")
	public ResponseEntity<?> getMovieDetail(@PathVariable int movieCode) {
		GetMovieResponseDto getMovieResponseDto = null;
		
		try {
			getMovieResponseDto = contentsService.getMovie(movieCode);
			if(getMovieResponseDto == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getMovieResponseDto));
	}
}

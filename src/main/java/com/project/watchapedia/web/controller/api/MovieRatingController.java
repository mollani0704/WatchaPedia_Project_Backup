package com.project.watchapedia.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.watchapedia.service.movie.MovieRatingService;
import com.project.watchapedia.web.controller.dto.CMRespDto;
import com.project.watchapedia.web.controller.dto.movie.MovieRatingReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieRatingController {

	private final MovieRatingService movieRatingService;
	
	@PostMapping("/rating")
	public ResponseEntity<?> insertMovieRating(@RequestBody MovieRatingReqDto movieRatingReqDto) {
		
		boolean status = false;
		
		try {
			status = movieRatingService.insertMovieRating(movieRatingReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "영화 평점 입력 실패", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "영화 평점 입력 성공", status));
	}
	
	@GetMapping("/rating/select/{movieCode}/{userCode}")
	public ResponseEntity<?> getMovieRating(@PathVariable int movieCode, @PathVariable int userCode) {
		
		MovieRatingReqDto ratingScoreData = null;
		
		try {
			ratingScoreData = movieRatingService.getMovieRating(movieCode, userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "영화 평점 불러오기 실패", ratingScoreData));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "영화 평점 불러오기 성공", ratingScoreData));
		
	}
	
}

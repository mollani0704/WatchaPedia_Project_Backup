package com.project.watchapedia.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.watchapedia.web.controller.dto.movie.MovieRatingReqDto;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieRatingController {

	@PostMapping("/rating")
	public ResponseEntity<?> insertMovieRating(@RequestBody MovieRatingReqDto movieRatingReqDto) {
		return ResponseEntity.ok().body(null);
	}
	
}

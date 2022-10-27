package com.project.watchapedia.service.movie;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.movie.MovieRatingRepository;
import com.project.watchapedia.web.controller.dto.movie.MovieRatingReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieRatingServiceImpl implements MovieRatingService{
	
	private final MovieRatingRepository movieRatingRepository;
	
	@Override
	public boolean insertMovieRating(MovieRatingReqDto movieRatingReqDto) throws Exception {
		
		return movieRatingRepository.insertMovieRating(movieRatingReqDto.toMovieRatingEntity()) > 0;
	}

	@Override
	public MovieRatingReqDto getMovieRating(int movieCode, int userCode) throws Exception {
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("movieCode", movieCode);
		reqMap.put("userCode", userCode);
		
		
		return movieRatingRepository.getMovieRating(reqMap).toMovieRatingReqDto();
	}

}

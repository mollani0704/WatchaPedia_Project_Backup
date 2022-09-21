package com.project.watchapedia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.contents.ContentsRepository;
import com.project.watchapedia.domain.contents.Movie;
import com.project.watchapedia.web.controller.dto.contents.GetMovieListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMovieResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentsServiceImpl implements ContentsService{

	private final ContentsRepository contentsRepository;
	
	@Override
	public List<GetMovieListResponseDto> getMovieList() throws Exception {
		
		List<GetMovieListResponseDto> list = new ArrayList<GetMovieListResponseDto>();
		
		contentsRepository.getMovieLists().forEach(content -> {
			list.add(content.toListDto());
		});
		
		return list;
	}

	@Override
	public GetMovieResponseDto getMovie(int movieCode) throws Exception {
		
		GetMovieResponseDto getMovieResponseDto = null;
		
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		
		reqMap.put("movieCode", movieCode);
		
		System.out.println(reqMap);
		
		List<Movie> movie = contentsRepository.getMovie(reqMap); 
		
		System.out.println(movie);
		
		Movie firstMovie = movie.get(0);
		
		getMovieResponseDto = GetMovieResponseDto.builder()
									.movieCode(movie.get(0).getMovie_code())
									.movieTitle(firstMovie.getMovie_title())
									.movieYear(firstMovie.getMovie_year())
									.movieOrigin(firstMovie.getMovie_origin())
									.movieSales(firstMovie.getMovie_sales())
									.movieRate(firstMovie.getMovie_rate())
									.movieGenre(firstMovie.getMovie_genre())
									.movieAge(firstMovie.getMovie_age())
									.movieContent(firstMovie.getMovie_content())
									.moviePoster(firstMovie.getMovie_poster())
									.build();
		
		return getMovieResponseDto;
	}


}

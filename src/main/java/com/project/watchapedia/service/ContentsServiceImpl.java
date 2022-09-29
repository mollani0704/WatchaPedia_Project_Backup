package com.project.watchapedia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.contents.ContentsRepository;
import com.project.watchapedia.domain.contents.Movie;
import com.project.watchapedia.web.controller.dto.contents.GetDramaListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMovieListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMoviePeopleResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMovieResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetSimilarMovieListReseponseDto;

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
	
	@Override
	public List<GetMoviePeopleResponseDto> getMoviePeople(int movieCode) throws Exception {
		
		List<GetMoviePeopleResponseDto> peopleList = new ArrayList<GetMoviePeopleResponseDto>();
	
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		
		reqMap.put("movieCode", movieCode);
		
		List<Movie> moviePeopleList = contentsRepository.getMoviePeopleList(reqMap);
		
		moviePeopleList.forEach(people -> {
			GetMoviePeopleResponseDto person = GetMoviePeopleResponseDto.builder()
						.movieCode(people.getMovie_code())
						.personCode(people.getPerson_code())
						.personName(people.getPerson_name())
						.personImg(people.getPerson_img())
						.build();
			
			peopleList.add(person);
		});
		
		return peopleList;
	}
	
	@Override
	public List<GetSimilarMovieListReseponseDto> getSimilarMovieList(String movieGenre) throws Exception {
		
		List<GetSimilarMovieListReseponseDto> similarMovie = new ArrayList<GetSimilarMovieListReseponseDto>();
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		
		reqMap.put("movieGenre", movieGenre);
//		reqMap.put("movieCode", movieCode);
		
		List<Movie> similarMovieList = contentsRepository.getSimilarMovieList(reqMap);
		
		similarMovieList.forEach(data -> {
			GetSimilarMovieListReseponseDto movie = GetSimilarMovieListReseponseDto.builder()
					.movieCode(data.getMovie_code())
					.movieTitle(data.getMovie_title())
					.movieYear(data.getMovie_year())
					.movieOrigin(data.getMovie_origin())
					.movieGenre(data.getMovie_genre())
					.moviePoster(data.getMovie_poster())
					.build();
			
			similarMovie.add(movie);
		});
		
		return similarMovie;
	}

	@Override
	public List<GetDramaListResponseDto> getDramaList() throws Exception {
		
		List<GetDramaListResponseDto> list2 = new ArrayList<GetDramaListResponseDto>();
		
		contentsRepository.getDramaLists().forEach(content2 -> {
			list2.add(content2.toDramaListDto());
		});
		
		return list2;
	}

	

	


}

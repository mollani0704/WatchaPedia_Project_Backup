package com.project.watchapedia.service;

import java.util.List;

import com.project.watchapedia.web.controller.dto.contents.GetMovieListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMovieResponseDto;


public interface ContentsService {
	
	public List<GetMovieListResponseDto> getMovieList() throws Exception;
	public GetMovieResponseDto getMovie(int movieCode) throws Exception;
}

package com.project.watchapedia.service;

import java.util.List;

import com.project.watchapedia.web.controller.dto.contents.GetBookListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetDramaListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetDramaPeopleResponseDto;

import com.project.watchapedia.web.controller.dto.contents.GetMovieListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMoviePeopleResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMovieResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetSimilarDramaListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetSimilarMovieListReseponseDto;


public interface ContentsService {
	
	public List<GetMovieListResponseDto> getMovieList() throws Exception;
	public GetMovieResponseDto getMovie(int movieCode) throws Exception;

	public List<GetMoviePeopleResponseDto> getMoviePeople(int movieCode) throws Exception;
	public List<GetSimilarMovieListReseponseDto> getSimilarMovieList(String movieGenre, int movieCode) throws Exception;
	
	public List<GetDramaListResponseDto> getDramaList() throws Exception;
	public GetDramaListResponseDto getDrama(int dramaCode) throws Exception;
	public List<GetDramaPeopleResponseDto> getDramaPeople(int dramaCode) throws Exception;
	public List<GetSimilarDramaListResponseDto> getSimilarDramaList(String dramaGenre, int dramaCode) throws Exception;
	
	public List<GetBookListResponseDto> getBookList() throws Exception;
	public GetBookListResponseDto getBook(int bookCode) throws Exception;

}

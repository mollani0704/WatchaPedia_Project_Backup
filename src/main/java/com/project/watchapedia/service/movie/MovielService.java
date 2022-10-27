package com.project.watchapedia.service.movie;

import java.util.List;

import com.project.watchapedia.web.controller.dto.movie.GeMovietWishDataRespDto;
import com.project.watchapedia.web.controller.dto.movie.GetMovieCommentListRespDto;
import com.project.watchapedia.web.controller.dto.movie.GetMovieWishListRespDto;
import com.project.watchapedia.web.controller.dto.movie.MovieCommentReqDto;

public interface MovielService {
	
	public boolean insertWishList(int userCode, int movieCode) throws Exception;
	public boolean deleteWishList(int userCode, int movieCode) throws Exception;
	public List<GetMovieWishListRespDto> getWishList(int userCode) throws Exception;
	public List<GeMovietWishDataRespDto> getWishData(int userCode) throws Exception;
	
	
	public boolean insertComment(MovieCommentReqDto movieCommentReqDto) throws Exception;
	public List<GetMovieCommentListRespDto> getMovieCommentList(int userCode) throws Exception;
	
}

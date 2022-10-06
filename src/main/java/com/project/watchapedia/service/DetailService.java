package com.project.watchapedia.service;

import java.util.List;

import com.project.watchapedia.web.controller.dto.comment.GetMovieCommentListRespDto;
import com.project.watchapedia.web.controller.dto.comment.MovieCommentReqDto;
import com.project.watchapedia.web.controller.dto.detail.GetWishDataRespDto;
import com.project.watchapedia.web.controller.dto.detail.GetWishListRespDto;

public interface DetailService {
	
	public boolean insertWishList(int userCode, int movieCode) throws Exception;
	public boolean deleteWishList(int userCode, int movieCode) throws Exception;
	public List<GetWishListRespDto> getWishList(int userCode) throws Exception;
	public List<GetWishDataRespDto> getWishData(int userCode) throws Exception;
	
	
	public boolean insertComment(MovieCommentReqDto movieCommentReqDto) throws Exception;
	public List<GetMovieCommentListRespDto> getMovieCommentList(int userCode) throws Exception;
	
}

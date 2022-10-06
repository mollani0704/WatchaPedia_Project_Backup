package com.project.watchapedia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.detail.CommentRepository;
import com.project.watchapedia.domain.detail.DetailRepository;
import com.project.watchapedia.web.controller.dto.comment.GetMovieCommentListRespDto;
import com.project.watchapedia.web.controller.dto.comment.MovieCommentReqDto;
import com.project.watchapedia.web.controller.dto.detail.GetWishDataRespDto;
import com.project.watchapedia.web.controller.dto.detail.GetWishListRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {
	
	private final DetailRepository detailRepository;
	private final CommentRepository commentRepository;
	
	@Override
	public boolean insertWishList(int userCode, int movieCode) throws Exception {
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("userCode", userCode);
		reqMap.put("movieCode", movieCode);
		
		
		
		
		return detailRepository.insertWishList(reqMap) > 0;
	}

	@Override
	public boolean deleteWishList(int userCode, int movieCode) throws Exception {
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("userCode", userCode);
		reqMap.put("movieCode", movieCode);
		
		
		
		return detailRepository.deleteWishList(reqMap) > 0;
	}

	@Override
	public List<GetWishListRespDto> getWishList(int userCode) throws Exception {
		
		List<GetWishListRespDto> wishDtoList = new ArrayList<GetWishListRespDto>();
		
		detailRepository.getWishList(userCode).forEach(wish -> {
			wishDtoList.add(wish.toWishListDto());
		});
		
		return wishDtoList;
	}

	@Override
	public List<GetWishDataRespDto> getWishData(int userCode) throws Exception {
		
		List<GetWishDataRespDto> wishDataDtoList = new ArrayList<GetWishDataRespDto>();
		
		detailRepository.getWishData(userCode).forEach(data -> {
			wishDataDtoList.add(data.toWishDataDto());
		});
		
		return wishDataDtoList;
	}

	@Override
	public boolean insertComment(MovieCommentReqDto movieCommentReqDto) throws Exception {
		
		return commentRepository.insertComment(movieCommentReqDto.toEntity()) > 0;
	}

	@Override
	public List<GetMovieCommentListRespDto> getMovieCommentList(int userCode) throws Exception {
		
		List<GetMovieCommentListRespDto> movieCommentDataDtoList = new ArrayList<GetMovieCommentListRespDto>();
		
		commentRepository.getMovieComment(userCode).forEach(comment -> {
			movieCommentDataDtoList.add(comment.toMovieCommentDataDto());
		});
		
		return movieCommentDataDtoList;
	}

}

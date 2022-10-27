package com.project.watchapedia.service.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.movie.MovieCommentRepository;
import com.project.watchapedia.domain.movie.MovieWishRepository;
import com.project.watchapedia.web.controller.dto.movie.GeMovietWishDataRespDto;
import com.project.watchapedia.web.controller.dto.movie.GetMovieCommentListRespDto;
import com.project.watchapedia.web.controller.dto.movie.GetMovieWishListRespDto;
import com.project.watchapedia.web.controller.dto.movie.MovieCommentReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovielService {
	
	private final MovieWishRepository movieWishRepository;
	private final MovieCommentRepository movieCommentRepository;
	
	@Override
	public boolean insertWishList(int userCode, int movieCode) throws Exception {
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("userCode", userCode);
		reqMap.put("movieCode", movieCode);
		
		
		
		
		return movieWishRepository.insertWishList(reqMap) > 0;
	}

	@Override
	public boolean deleteWishList(int userCode, int movieCode) throws Exception {
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("userCode", userCode);
		reqMap.put("movieCode", movieCode);
		
		
		
		return movieWishRepository.deleteWishList(reqMap) > 0;
	}

	@Override
	public List<GetMovieWishListRespDto> getWishList(int userCode) throws Exception {
		
		List<GetMovieWishListRespDto> wishDtoList = new ArrayList<GetMovieWishListRespDto>();
		
		movieWishRepository.getWishList(userCode).forEach(wish -> {
			wishDtoList.add(wish.toWishListDto());
		});
		
		return wishDtoList;
	}

	@Override
	public List<GeMovietWishDataRespDto> getWishData(int userCode) throws Exception {
		
		List<GeMovietWishDataRespDto> wishDataDtoList = new ArrayList<GeMovietWishDataRespDto>();
		
		movieWishRepository.getWishData(userCode).forEach(data -> {
			wishDataDtoList.add(data.toWishDataDto());
		});
		
		return wishDataDtoList;
	}

	@Override
	public boolean insertComment(MovieCommentReqDto movieCommentReqDto) throws Exception {
		
		return movieCommentRepository.insertComment(movieCommentReqDto.toEntity()) > 0;
	}

	@Override
	public List<GetMovieCommentListRespDto> getMovieCommentList(int userCode) throws Exception {
		
		List<GetMovieCommentListRespDto> movieCommentDataDtoList = new ArrayList<GetMovieCommentListRespDto>();
		
		movieCommentRepository.getMovieComment(userCode).forEach(comment -> {
			movieCommentDataDtoList.add(comment.toMovieCommentDataDto());
		});
		
		return movieCommentDataDtoList;
	}

}

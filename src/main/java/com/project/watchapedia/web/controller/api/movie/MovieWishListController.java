	package com.project.watchapedia.web.controller.api.movie;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.watchapedia.service.movie.MovielService;
import com.project.watchapedia.web.controller.dto.CMRespDto;
import com.project.watchapedia.web.controller.dto.movie.GeMovietWishDataRespDto;
import com.project.watchapedia.web.controller.dto.movie.GetMovieWishListRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/wish")
@RequiredArgsConstructor
public class MovieWishListController {
	
	private final MovielService movielService;
	
	@GetMapping("/insert/{userCode}/{movieCode}")
	public ResponseEntity<?> insertWishList(@PathVariable int userCode, @PathVariable int movieCode) {
		
		boolean status = false;
		
		try {
			status = movielService.insertWishList(userCode, movieCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "위시리스트 등록 실패", status));
		}
		
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "위시리스트 등록 성공", status));
	}
	
	@GetMapping("/delete/{userCode}/{movieCode}")
	public ResponseEntity<?> deleteWishList(@PathVariable int userCode, @PathVariable int movieCode) {
		
		boolean status = false;
		
		try {
			status = movielService.deleteWishList(userCode, movieCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "위시리스트 삭제 실패", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "위시리스트 삭제 성공", status));
	}
	
	@GetMapping("/select/{userCode}")
	public ResponseEntity<?> getWishList(@PathVariable int userCode) {
		
		List<GetMovieWishListRespDto> wishDtoList = null;
		
		try {
			wishDtoList = movielService.getWishList(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "위시리스트 불러오기 실패", wishDtoList));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "위시리스트 불러오기 성공", wishDtoList));
	}
	
	@GetMapping("/data/{userCode}")
	public ResponseEntity<?> getWishData(@PathVariable int userCode) {
		
		List<GeMovietWishDataRespDto> wishDataDtoList = null;
		
		try {
			wishDataDtoList = movielService.getWishData(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "위시리스트 데이터 불러오기 실패", null));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "위시리스트 데이터 불러오기 성공", wishDataDtoList));
	}
}

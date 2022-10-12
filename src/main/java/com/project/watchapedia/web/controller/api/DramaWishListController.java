package com.project.watchapedia.web.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.watchapedia.service.drama.DramaWishListService;
import com.project.watchapedia.web.controller.dto.CMRespDto;
import com.project.watchapedia.web.controller.dto.drama.GetDramaWishDataRespDto;
import com.project.watchapedia.web.controller.dto.drama.GetDramaWishListRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/wish/drama")
@RequiredArgsConstructor
public class DramaWishListController {
	
	private final DramaWishListService dramaWishListService;
	
	@GetMapping("/insert/{userCode}/{dramaCode}")
	public ResponseEntity<?> insertDramaWishList(@PathVariable int userCode, @PathVariable int dramaCode) {
		
		boolean status = false;
		
		try {
			status = dramaWishListService.insertDramaWishList(userCode, dramaCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "드라마 위시리스트 등록 실패", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "드라마 위시리스트 등록 성공", status));
	}
	
	@GetMapping("/select/{userCode}")
	public ResponseEntity<?> getDramaWishList(@PathVariable int userCode) {
		
		List<GetDramaWishListRespDto> dramaWishDtoList = null;
		
		try {
			dramaWishDtoList = dramaWishListService.getDramaWishList(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "드라마 위시리스트 불러오기 실패", dramaWishDtoList));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "드라마 위시리스트 불러오기 성공", dramaWishDtoList));
	}
	
	@GetMapping("/data/{userCode}")
	public ResponseEntity<?> getDramaWishData(@PathVariable int userCode) {
		
		List<GetDramaWishDataRespDto> dramaWishDtoData = null;
		
		try {
			dramaWishDtoData = dramaWishListService.getDramaWishData(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "드라마 위시데이터 불러오기 실패", dramaWishDtoData));
		}
		
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "드라마 위시데이터 불러오기 성공", dramaWishDtoData));
	}
	
	@GetMapping("/delete/{userCode}/{dramaCode}")
	public ResponseEntity<?> deleteDramaWishList(@PathVariable int userCode, @PathVariable int dramaCode) {
		
		boolean status = false;
		
		try {
			status = dramaWishListService.deleteDramaWishList(userCode, dramaCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "드라마 위시리스트 삭제 실패", status));
		}
		
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "드라마 위시리스트 삭제 성공", status));
		
	}
}

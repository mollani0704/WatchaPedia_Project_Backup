package com.project.watchapedia.web.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.oauth2.sdk.Response;
import com.project.watchapedia.service.ContentsService;
import com.project.watchapedia.web.controller.dto.CMRespDto;

import com.project.watchapedia.web.controller.dto.contents.GetBookListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetDramaListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetDramaPeopleResponseDto;

import com.project.watchapedia.web.controller.dto.contents.GetMovieListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMoviePeopleResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMovieResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetSimilarDramaListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetSimilarMovieListReseponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/content")
@RequiredArgsConstructor
public class ContentsRestController {
	
	private final ContentsService contentsService;
	
	
	/* movie */
	
	@GetMapping("/movie")
	public ResponseEntity<?> getMovieList() {
		
		List<GetMovieListResponseDto> listMovieDto = null;
		
		try {
			listMovieDto = contentsService.getMovieList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", listMovieDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", listMovieDto));
	}

	@GetMapping("/movie/{movieCode}")
	public ResponseEntity<?> getMovieDetail(@PathVariable int movieCode) {
		GetMovieResponseDto getMovieResponseDto = null;
		
		try {
			getMovieResponseDto = contentsService.getMovie(movieCode);
			if(getMovieResponseDto == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		 }
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getMovieResponseDto));
	}
	
	@GetMapping("/movieInformation/{movieCode}") 
	public ResponseEntity<?> getInformationDetail(@PathVariable int movieCode) {
		GetMovieResponseDto getMovieResponseDto = null;
		
		try {
			getMovieResponseDto = contentsService.getMovie(movieCode);
			if(getMovieResponseDto == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		 }
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getMovieResponseDto));
	}
	
	
	
	@GetMapping("/moviePeople/{movieCode}")
	public ResponseEntity<?> getMoviePeople(@PathVariable int movieCode) {
		
		List<GetMoviePeopleResponseDto> moviePeopleList = null;
		
		try {
			moviePeopleList = contentsService.getMoviePeople(movieCode);
			if(moviePeopleList == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
			System.out.println(moviePeopleList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", moviePeopleList));
	}
	
	@GetMapping("/similarMovie/{movieGenre}/{movieCode}")
	public ResponseEntity<?> getSimilarMovieList(@PathVariable String movieGenre, @PathVariable int movieCode) {
		
		List<GetSimilarMovieListReseponseDto> similarMovieList = null;
		
		try {
			similarMovieList = contentsService.getSimilarMovieList(movieGenre, movieCode);
			if(similarMovieList == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
			System.out.println(similarMovieList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", similarMovieList));
	}
	
	
	/* drama */

	@GetMapping("/drama")
	public ResponseEntity<?> getDramaList() {
		
		List<GetDramaListResponseDto> listDramaDto = null;
		
		try {
			listDramaDto = contentsService.getDramaList();
		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", listDramaDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", listDramaDto));
	}
		
	
	@GetMapping("/drama/{dramaCode}")
	public ResponseEntity<?> getDramaDetail(@PathVariable int dramaCode) {
		GetDramaListResponseDto getDramaListResponseDto = null;
		
		try {
			getDramaListResponseDto = contentsService.getDrama(dramaCode);
			if(getDramaListResponseDto == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getDramaListResponseDto));
	}
	
	
	@GetMapping("/dramaPeople/{dramaCode}")
	public ResponseEntity<?> getDramaPeople(@PathVariable int dramaCode) {
	
		List<GetDramaPeopleResponseDto> dramaPeopleList = null;
	
		try {
			dramaPeopleList = contentsService.getDramaPeople(dramaCode);
			if(dramaPeopleList == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", dramaPeopleList));
		

	}
	
	
	@GetMapping("/similarDrama/{dramaGenre}/{dramaCode}")
	public ResponseEntity<?> GetSimilarDramaList(@PathVariable String dramaGenre, @PathVariable int dramaCode){
		
		List<GetSimilarDramaListResponseDto> similarDramaList = null;
		
		try {
			similarDramaList = contentsService.getSimilarDramaList(dramaGenre, dramaCode);
			if(similarDramaList == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));	
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", similarDramaList));
	
	}
	

	
	
	
	
	/* book */
	@GetMapping("/book")
	public ResponseEntity<?> getBookList() {
		
		List<GetBookListResponseDto> listBookDto = null;
		
		try {
			listBookDto = contentsService.getBookList();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", listBookDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", listBookDto));
		
	}
	
	@GetMapping("/book/{bookCode}")
	public ResponseEntity<?> getBookDetail(@PathVariable int bookCode) {
		GetBookListResponseDto getBookListResponseDto = null;
		
		try {
			getBookListResponseDto = contentsService.getBook(bookCode);
			if(getBookListResponseDto == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getBookListResponseDto));
	}
	
}

  


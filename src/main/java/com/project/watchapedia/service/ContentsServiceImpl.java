package com.project.watchapedia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.contents.Book;
import com.project.watchapedia.domain.contents.ContentsRepository;
import com.project.watchapedia.domain.contents.Drama;
import com.project.watchapedia.domain.contents.Movie;

import com.project.watchapedia.web.controller.dto.contents.GetBookListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetDramaListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetDramaPeopleResponseDto;

import com.project.watchapedia.web.controller.dto.contents.GetMovieListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMoviePeopleResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetMovieResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetSimilarDramaListResponseDto;
import com.project.watchapedia.web.controller.dto.contents.GetSimilarMovieListReseponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentsServiceImpl implements ContentsService{

	private final ContentsRepository contentsRepository;
	
	/* Movie */
	
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
									.movieBanner(firstMovie.getMovie_banner())
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
	public List<GetSimilarMovieListReseponseDto> getSimilarMovieList(String movieGenre, int movieCode) throws Exception {
		
		List<GetSimilarMovieListReseponseDto> similarMovie = new ArrayList<GetSimilarMovieListReseponseDto>();
		
		Map<String, Object> reqMap2 = new HashMap<String, Object>();
		
		reqMap2.put("movieGenre", movieGenre);
		reqMap2.put("movieCode", movieCode);
		
		List<Movie> similarMovieList = contentsRepository.getSimilarMovieList(reqMap2);
		
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

	
	/* Drama */
	
	@Override
	public List<GetDramaListResponseDto> getDramaList() throws Exception {
		
		List<GetDramaListResponseDto> list2 = new ArrayList<GetDramaListResponseDto>();
		
		contentsRepository.getDramaLists().forEach(content2 -> {
			list2.add(content2.toDramaListDto());
		});
		
		return list2;
	}

	@Override
	public GetDramaListResponseDto getDrama(int dramaCode) throws Exception {
			
		GetDramaListResponseDto getDramaListResponseDto = null;
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("dramaCode", dramaCode);
		
		List<Drama> drama = contentsRepository.getDrama(reqMap);
		
		Drama firstDrama = drama.get(0);
		
		getDramaListResponseDto = GetDramaListResponseDto.builder()
										.dramaCode(drama.get(0).getDrama_code())
										.dramaTitle(firstDrama.getDrama_title())
										.dramaYear(firstDrama.getDrama_year())
										.dramaCompany(firstDrama.getDrama_company())
										.dramaRate(firstDrama.getDrama_rate())
										.dramaGenre(firstDrama.getDrama_genre())
										.dramaAge(firstDrama.getDrama_age())
										.dramaContent(firstDrama.getDrama_content())
										.dramaPoster(firstDrama.getDrama_poster())
										.dramaBanner(firstDrama.getDrama_banner())
										.build();
		
		return getDramaListResponseDto;
	}

	@Override
	public List<GetDramaPeopleResponseDto> getDramaPeople(int dramaCode) throws Exception {
		List<GetDramaPeopleResponseDto> peopleList = new ArrayList<GetDramaPeopleResponseDto>();
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		
		reqMap.put("dramaCode", dramaCode);
		List<Drama> dramaPeopleList = contentsRepository.getDramaPeopleList(reqMap);
		
		dramaPeopleList.forEach(people -> {
			GetDramaPeopleResponseDto person = GetDramaPeopleResponseDto.builder()
					.dramaCode(people.getDrama_code())
					.personCode(people.getPerson_code())
					.personName(people.getPerson_name())
					.personImg(people.getPerson_img())
					.build();
			
			peopleList.add(person);
		});
		;
		return peopleList;
	}

	@Override
	public List<GetSimilarDramaListResponseDto> getSimilarDramaList(String dramaGenre, int dramaCode) throws Exception {
	
		List<GetSimilarDramaListResponseDto> similarDrama = new ArrayList<GetSimilarDramaListResponseDto>();
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("dramaGenre", dramaGenre);
		reqMap.put("dramaCode", dramaCode);
		
		List<Drama> similarDramaList = contentsRepository.getSimilarDramaList(reqMap);
		
		similarDramaList.forEach(data -> {
			GetSimilarDramaListResponseDto drama = GetSimilarDramaListResponseDto.builder()
					.dramaCode(data.getDrama_code())
					.dramaTitle(data.getDrama_title())
					.dramaYear(data.getDrama_year())
					.dramaCompany(data.getDrama_company())
					.dramaGenre(data.getDrama_genre())		
					.dramaPoster(data.getDrama_poster())
					.build();
			
			similarDrama.add(drama);
		});		
		
		return similarDrama;
	}

	@Override
	public List<GetBookListResponseDto> getBookList() throws Exception {
		
		List<GetBookListResponseDto> list = new ArrayList<GetBookListResponseDto>();
		
		contentsRepository.getBookLists().forEach(content -> {
			list.add(content.toBookListDto());		
		});		
		return list;
	}

	@Override
	public GetBookListResponseDto getBook(int bookCode) throws Exception {
		
		GetBookListResponseDto getBookListResponseDto = null;
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("bookCode", bookCode);
		
		List<Book> book = contentsRepository.getBook(reqMap);
		
		Book firstBook = book.get(0);
		
		getBookListResponseDto = GetBookListResponseDto.builder()
									.bookCode(book.get(0).getBook_code())
									.bookTitle(firstBook.getBook_title())
									.bookYear(firstBook.getBook_year())
									.bookAuthor(firstBook.getBook_author())
									.bookPage(firstBook.getBook_page())
									.bookRate(firstBook.getBook_rate())
									.bookContent(firstBook.getBook_content())
									.bookPoster(firstBook.getBook_poster())
									.bookComment(firstBook.getBook_comment())
									.build();
		
		return getBookListResponseDto;
									
	}
}

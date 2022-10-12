package com.project.watchapedia.domain.contents;

import com.project.watchapedia.web.controller.dto.contents.GetBookListResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
	private int book_code;
	private String book_title;
	private String book_year;
	private String book_author;
	private String book_page;
	private float book_rate;
	private String book_genre;
	private String book_content;
	private String book_poster;
	private String book_comment;
	
		public GetBookListResponseDto toBookListDto() {
			return GetBookListResponseDto.builder()
					.bookCode(book_code)
					.bookTitle(book_title)
					.bookYear(book_year)
					.bookAuthor(book_author)
					.bookPage(book_page)
					.bookRate(book_rate)
					.bookGenre(book_genre)
					.bookContent(book_content)
					.bookPoster(book_poster)
					.bookComment(book_comment)
					.build();
		}
}

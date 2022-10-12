package com.project.watchapedia.web.controller.dto.contents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetBookListResponseDto {
	private int bookCode;
	private String bookTitle;
	private String bookYear;
	private String bookAuthor;
	private String bookPage;
	private float bookRate;
	private String bookGenre;
	private String bookContent;
	private String bookPoster;
	private String bookComment;
}

package com.project.watchapedia.domain.detail;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentRepository {
	public int insertComment(MovieComment movieComment) throws Exception;
	public List<MovieComment> getMovieComment(int userCode) throws Exception;
}

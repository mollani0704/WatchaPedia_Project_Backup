package com.project.watchapedia.domain.drama;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DramaCommentRepository {
	public int insertDramaComment(DramaComment dramaComment) throws Exception;
	public List<DramaComment> getDramaComment(int dramaCode) throws Exception;
}

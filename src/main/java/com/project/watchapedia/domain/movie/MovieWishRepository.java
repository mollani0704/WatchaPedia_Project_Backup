package com.project.watchapedia.domain.movie;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieWishRepository {
	public int insertWishList(Map<String, Object> map) throws Exception;
	public int deleteWishList(Map<String, Object> map) throws Exception;
	public List<MovieWishList> getWishList(int userCode) throws Exception;
	public List<MovieWishData> getWishData(int userCode) throws Exception;
}

package com.project.watchapedia.domain.detail;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailRepository {
	public int insertWishList(Map<String, Object> map) throws Exception;
	public int deleteWishList(Map<String, Object> map) throws Exception;
	public List<WishList> getWishList(int userCode) throws Exception;
	public List<WishData> getWishData(int userCode) throws Exception;
}

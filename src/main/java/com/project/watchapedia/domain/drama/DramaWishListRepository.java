package com.project.watchapedia.domain.drama;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DramaWishListRepository {
	public int insertDramaWishList(Map<String, Object> map) throws Exception;
	public int deleteDramaWishList(Map<String, Object> map) throws Exception;
	public List<DramaWishList> getDramaWishList(int userCode) throws Exception;
	public List<DramaWishData> getDramaWishData(int userCode) throws Exception;
}

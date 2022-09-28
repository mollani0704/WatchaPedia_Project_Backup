package com.project.watchapedia.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentRepository {
	public int save(User user) throws Exception;
}

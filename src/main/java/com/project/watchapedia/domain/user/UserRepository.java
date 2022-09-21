package com.project.watchapedia.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	public int save(User user) throws Exception;
}

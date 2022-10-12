package com.project.watchapedia.service.drama;

import java.util.List;

import com.project.watchapedia.web.controller.dto.drama.GetDramaWishDataRespDto;
import com.project.watchapedia.web.controller.dto.drama.GetDramaWishListRespDto;

public interface DramaWishListService {
	
	public boolean insertDramaWishList(int userCode, int dramaCode) throws Exception;
	public boolean deleteDramaWishList(int userCode, int dramaCode) throws Exception;
	public List<GetDramaWishListRespDto> getDramaWishList(int userCode) throws Exception;
	public List<GetDramaWishDataRespDto> getDramaWishData(int userCode) throws Exception;
}

package com.project.watchapedia.service.drama;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.drama.DramaWishListRepository;
import com.project.watchapedia.web.controller.dto.drama.GetDramaWishDataRespDto;
import com.project.watchapedia.web.controller.dto.drama.GetDramaWishListRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DramaWishListServiceImpl implements DramaWishListService{
	
	private final DramaWishListRepository dramaWishListRepository;
	
	@Override
	public boolean insertDramaWishList(int userCode, int dramaCode) throws Exception {
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("userCode", userCode);
		reqMap.put("dramaCode", dramaCode);
		
		
		return dramaWishListRepository.insertDramaWishList(reqMap) > 0;
	}

	@Override
	public List<GetDramaWishListRespDto> getDramaWishList(int userCode) throws Exception {
		
		List<GetDramaWishListRespDto> dramaWishDtoList =  new ArrayList<GetDramaWishListRespDto>();
		
		dramaWishListRepository.getDramaWishList(userCode).forEach(data -> {
			dramaWishDtoList.add(data.toDramaWishListDto());
		});
		
		return dramaWishDtoList;
	}

	@Override
	public List<GetDramaWishDataRespDto> getDramaWishData(int userCode) throws Exception {
		
		List<GetDramaWishDataRespDto> dramaWishDataDtoList = new ArrayList<GetDramaWishDataRespDto>();
		
		dramaWishListRepository.getDramaWishData(userCode).forEach(data -> {
			dramaWishDataDtoList.add(data.toDramaWishDataDto());
		});
		
		return dramaWishDataDtoList;
	}

	@Override
	public boolean deleteDramaWishList(int userCode, int dramaCode) throws Exception {
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("userCode", userCode);
		reqMap.put("dramaCode", dramaCode);
		
		
		
		return dramaWishListRepository.deleteDramaWishList(reqMap) > 0;
	}

}

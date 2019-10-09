package com.mvc.service;

import java.util.*;

import com.mvc.dto.MstBarangAllDto;
import com.mvc.dto.MstBarangDto;



public interface MstBarangSvc {
	
	public List<MstBarangAllDto> findAllBarang();
	public List<MstBarangAllDto> findBarangByParam(String param);
	public void save(MstBarangDto dto);
	public void update(MstBarangDto dto);
	public void delete(String kodeBarang);
	public MstBarangDto findOneBarang(String kodeBarang);

}

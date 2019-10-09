package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstProvinsiDto;


public interface MstProvinsiSvc {
	
	public List<MstProvinsiDto> findAllProvinsi();
	public List<MstProvinsiDto> findProvinsiByParam(String search);
	public void save(MstProvinsiDto dto);
	public void update(MstProvinsiDto dto);
	public void delete(String kodeProvinsi);
}

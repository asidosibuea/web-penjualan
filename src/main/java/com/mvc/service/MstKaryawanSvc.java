package com.mvc.service;

import java.util.*;

import com.mvc.dto.MstKaryawanDto;

public interface MstKaryawanSvc {
	
	public List<MstKaryawanDto> findAllKaryawan();
	public List<MstKaryawanDto> findKaryawanByParam(String search);
	public void save(MstKaryawanDto dto);
	public void update(MstKaryawanDto dto);
	public void delete(String kodeKaryawan);

}

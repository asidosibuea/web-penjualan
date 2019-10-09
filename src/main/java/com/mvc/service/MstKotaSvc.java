package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstKotaDto;
import com.mvc.dto.MstKotaJoinProvinsiDto;

public interface MstKotaSvc {
	
	public List<MstKotaJoinProvinsiDto> findAllKota();
	public List<MstKotaJoinProvinsiDto> findKotaByParam(String search);
	public void save(MstKotaDto dto);
	public void update(MstKotaDto dto);
	public void delete(String kodeKota);

}

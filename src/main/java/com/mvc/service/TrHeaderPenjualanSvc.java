package com.mvc.service;

import java.util.List;
import java.util.Map;

import com.mvc.dto.TrHeaderPenjualanDto;


public interface TrHeaderPenjualanSvc {
	
	public List<TrHeaderPenjualanDto> findAllPenjualan();
	public void save(TrHeaderPenjualanDto dto);
	public void update(TrHeaderPenjualanDto dto);
	public void delete(String noNota);
	public Map<String, Object> searchPenjualan(String cari, int page);
	public TrHeaderPenjualanDto findPenjualanByNoNota(String noNota);
	

}

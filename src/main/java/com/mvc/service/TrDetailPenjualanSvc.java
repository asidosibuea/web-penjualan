package com.mvc.service;

import java.util.List;

import com.mvc.dto.TrDetailPenjualanDto;


public interface TrDetailPenjualanSvc {
	
	public List<TrDetailPenjualanDto> findAllDetailPenjualan(String noNota);
	public void save(TrDetailPenjualanDto dto);
	public void update(TrDetailPenjualanDto dto);
	public void delete(String kodeDetail);
	public void deleteDetail(String noNota);
	
}

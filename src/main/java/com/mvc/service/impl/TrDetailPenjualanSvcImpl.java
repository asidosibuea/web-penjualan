package com.mvc.service.impl;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.MstBarangDao;
import com.mvc.dao.TrDetailPenjualanDao;
import com.mvc.dto.TrDetailPenjualanDto;
import com.mvc.entity.MstBarang;
import com.mvc.entity.TrDetailPenjualan;
import com.mvc.entity.TrHeaderPenjualan;
import com.mvc.entity.pk.TrDetailPenjualanPK;
import com.mvc.service.TrDetailPenjualanSvc;


@Transactional
@Service
public class TrDetailPenjualanSvcImpl implements TrDetailPenjualanSvc{

	@Autowired
	private TrDetailPenjualanDao dao;
	
	@Autowired
	private MstBarangDao barangDao;
	
	@Override
	public List<TrDetailPenjualanDto> findAllDetailPenjualan(String noNota) {
		List<Object[]> objects = dao.findAllDetailPenjualan(noNota);
		List<TrDetailPenjualanDto> list = new LinkedList<>();
		for(Object[] object: objects){
			TrDetailPenjualan detail = (TrDetailPenjualan) object[0];
			TrHeaderPenjualan header = (TrHeaderPenjualan) object[1];
			MstBarang barang = (MstBarang) object[2];
			
			TrDetailPenjualanDto dto = new TrDetailPenjualanDto();
			dto.setKodeDetail(detail.getKodeDetail());
			dto.setKodeBarang(detail.getKodeBarang());
			dto.setNamaBarang(barang.getNamaBarang());
			dto.setHargaSatuan(detail.getHargaSatuan());
			dto.setQty(detail.getQty());
			dto.setDiskon(detail.getDiskon());
			dto.setSubtotal(detail.getSubtotal());
			dto.setNoNota(header.getNoNota());
			list.add(dto);
		}
		
		return list;
	}

	@Override
	public void save(TrDetailPenjualanDto dto) {
		TrDetailPenjualan entity = new TrDetailPenjualan();
		entity.setKodeDetail(dto.getKodeDetail());
		entity.setNoNota(dto.getNoNota());
		entity.setKodeBarang(dto.getKodeBarang());
		entity.setQty(dto.getQty());
		entity.setHargaSatuan(dto.getHargaSatuan());
		entity.setDiskon(dto.getDiskon());
		entity.setSubtotal(dto.getSubtotal());
		dao.save(entity);
	}

	@Override
	public void update(TrDetailPenjualanDto dto) {
		TrDetailPenjualanPK pk = new TrDetailPenjualanPK();
		pk.setKodeDetail(dto.getKodeDetail());
		
		TrDetailPenjualan entity = dao.findOne(pk);
		entity.setKodeDetail(dto.getKodeDetail());
		entity.setKodeBarang(dto.getKodeBarang());
		entity.setQty(dto.getQty());
		entity.setHargaSatuan(dto.getHargaSatuan());
		entity.setDiskon(dto.getDiskon());
		entity.setSubtotal(dto.getSubtotal());
		dao.save(entity);
		
	}

	@Override
	public void delete(String kodeDetail) {
		TrDetailPenjualanPK pk = new TrDetailPenjualanPK();
		pk.setKodeDetail(kodeDetail);
		dao.delete(pk);
		
	}

	@Override
	public void deleteDetail(String noNota) {
		dao.deleteDetail(noNota);
	}

}

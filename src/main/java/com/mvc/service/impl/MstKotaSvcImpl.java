package com.mvc.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstKotaDao;
import com.mvc.dto.MstKotaDto;
import com.mvc.dto.MstKotaJoinProvinsiDto;
import com.mvc.entity.MstKota;
import com.mvc.entity.MstProvinsi;
import com.mvc.entity.pk.MstKotaPK;
import com.mvc.service.MstKotaSvc;


@Service
@Transactional
public class MstKotaSvcImpl implements MstKotaSvc{

	@Autowired
	private MstKotaDao dao;
	
	@Override
	public List<MstKotaJoinProvinsiDto> findAllKota() {
		List<Object[]> listKota = dao.findAllKotaJoinProvinsi();
		List<MstKotaJoinProvinsiDto> listKotaDto = new LinkedList<>();
		for(Object[] objects : listKota){
			MstKota kota = (MstKota) objects[0];
			MstProvinsi provinsi = (MstProvinsi) objects[1];
			
			MstKotaJoinProvinsiDto dto = new MstKotaJoinProvinsiDto();
			dto.setKodeKota(kota.getKodeKota());
			dto.setNamaKota(kota.getNamaKota());
			dto.setKodeProvinsi(kota.getKodeProvinsi());
			dto.setNamaProvinsi(provinsi.getNamaProvinsi());
			
			listKotaDto.add(dto);
		}
		return listKotaDto;
	}

	@Override
	public List<MstKotaJoinProvinsiDto> findKotaByParam(String search) {
		List<Object[]> listKota = dao.findKotaJoinProvinsiByParam(search);
		List<MstKotaJoinProvinsiDto> listKotaDto = new LinkedList<>();
		for(Object[] objects : listKota){
			MstKota kota = (MstKota) objects[0];
			MstProvinsi provinsi = (MstProvinsi) objects[1];
			
			MstKotaJoinProvinsiDto dto = new MstKotaJoinProvinsiDto();
			dto.setKodeKota(kota.getKodeKota());
			dto.setNamaKota(kota.getNamaKota());
			dto.setKodeProvinsi(kota.getKodeProvinsi());
			dto.setNamaProvinsi(provinsi.getNamaProvinsi());
			
			listKotaDto.add(dto);
		}
		return listKotaDto;
	}

	@Override
	public void save(MstKotaDto dto) {
		MstKota kota = new MstKota();
		kota.setKodeKota(dto.getKodeKota());
		kota.setKodeProvinsi(dto.getKodeProvinsi());
		kota.setNamaKota(dto.getNamaKota());
		
		dao.save(kota);
	}

	@Override
	public void update(MstKotaDto dto) {
		MstKotaPK id = new MstKotaPK();
		id.setKodeKota(dto.getKodeKota());
		MstKota kota = dao.findOne(id);
		kota.setNamaKota(dto.getNamaKota());
		kota.setKodeProvinsi(dto.getKodeProvinsi());
		dao.save(kota);
	}

	@Override
	public void delete(String kodeKota) {
		MstKotaPK id = new MstKotaPK();
		id.setKodeKota(kodeKota);
		dao.delete(id);
	}

}

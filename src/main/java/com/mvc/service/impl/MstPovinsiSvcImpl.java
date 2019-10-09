package com.mvc.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstProvinsiDao;
import com.mvc.dto.MstProvinsiDto;
import com.mvc.entity.MstProvinsi;
import com.mvc.entity.pk.MstProvinsiPK;
import com.mvc.service.MstProvinsiSvc;


@Service
@Transactional
public class MstPovinsiSvcImpl implements MstProvinsiSvc{

	@Autowired
	private MstProvinsiDao dao;
	
	@Override
	public List<MstProvinsiDto> findAllProvinsi() {
		List<MstProvinsi> listProvinsi = dao.findAll();
		List<MstProvinsiDto> listProvinsiDto = new LinkedList<MstProvinsiDto>();
		for(MstProvinsi provinsi : listProvinsi){
			MstProvinsiDto dto = new MstProvinsiDto();
			dto.setKodeProvinsi(provinsi.getKodeProvinsi());
			dto.setNamaProvinsi(provinsi.getNamaProvinsi());
			listProvinsiDto.add(dto);
		}
		return listProvinsiDto;
	}

	@Override
	public List<MstProvinsiDto> findProvinsiByParam(String search) {
		List<MstProvinsi> listProvinsi = dao.findProvinsiByParam(search);
		List<MstProvinsiDto> listProvinsiDto = new LinkedList<MstProvinsiDto>();
		for(MstProvinsi provinsi : listProvinsi){
			MstProvinsiDto dto = new MstProvinsiDto();
			dto.setKodeProvinsi(provinsi.getKodeProvinsi());
			dto.setNamaProvinsi(provinsi.getNamaProvinsi());
			listProvinsiDto.add(dto);
		}
		return listProvinsiDto;
	}

	@Override
	public void save(MstProvinsiDto dto) {
		MstProvinsi provinsi = new MstProvinsi();
		provinsi.setKodeProvinsi(dto.getKodeProvinsi());
		provinsi.setNamaProvinsi(dto.getNamaProvinsi());
		dao.save(provinsi);
	}

	@Override
	public void update(MstProvinsiDto dto) {
		MstProvinsiPK id = new MstProvinsiPK();
		id.setKodeProvinsi(dto.getKodeProvinsi());
		MstProvinsi provinsi = dao.findOne(id);
		provinsi.setNamaProvinsi(dto.getNamaProvinsi());
		dao.save(provinsi);
	}

	@Override
	public void delete(String kodeProvinsi) {
		MstProvinsiPK id = new MstProvinsiPK();
		id.setKodeProvinsi(kodeProvinsi);
		dao.delete(id);
		
	}

}

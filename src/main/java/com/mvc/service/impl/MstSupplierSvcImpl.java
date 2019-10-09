package com.mvc.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstSupplierDao;
import com.mvc.dto.MstSupplierDto;
import com.mvc.dto.MstSupplierJoinKotaDto;
import com.mvc.entity.MstKota;
import com.mvc.entity.MstSupplier;
import com.mvc.entity.pk.MstSupplierPK;
import com.mvc.service.MstSupplierSvc;


@Service
@Transactional
public class MstSupplierSvcImpl implements MstSupplierSvc{

	@Autowired
	private MstSupplierDao dao;
	
	@Override
	public List<MstSupplierJoinKotaDto> findAllSupplier() {
		List<Object[]> listKota = dao.findAllSupplierJoinKota();
		List<MstSupplierJoinKotaDto> listKotaDto = new LinkedList<MstSupplierJoinKotaDto>();
		for(Object[] objects : listKota){
			MstSupplier supplier = (MstSupplier) objects[0];
			MstKota kota = (MstKota) objects[1];
			
			MstSupplierJoinKotaDto dto = new MstSupplierJoinKotaDto();
			dto.setKodeSupplier(supplier.getKodeSupplier());
			dto.setNamaSupplier(supplier.getNamaSupplier());
			dto.setAlamatSupplier(supplier.getAlamatSupplier());
			dto.setEmailSupplier(supplier.getEmailSupplier());
			dto.setTelpSupplier(supplier.getTelpSupplier());
			dto.setKodeKota(supplier.getKodeKota());
			dto.setNamaKota(kota.getNamaKota());
			
			listKotaDto.add(dto);
		}
		return listKotaDto;
	}

	@Override
	public List<MstSupplierJoinKotaDto> findAllSupplierByParam(String search) {
		List<Object[]> listKota = dao.findAllSupplierJoinKotaByParam(search);
		List<MstSupplierJoinKotaDto> listKotaDto = new LinkedList<MstSupplierJoinKotaDto>();
		for(Object[] objects : listKota){
			MstSupplier supplier = (MstSupplier) objects[0];
			MstKota kota = (MstKota) objects[1];
			
			MstSupplierJoinKotaDto dto = new MstSupplierJoinKotaDto();
			dto.setKodeSupplier(supplier.getKodeSupplier());
			dto.setNamaSupplier(supplier.getNamaSupplier());
			dto.setAlamatSupplier(supplier.getAlamatSupplier());
			dto.setEmailSupplier(supplier.getEmailSupplier());
			dto.setTelpSupplier(supplier.getTelpSupplier());
			dto.setKodeKota(supplier.getKodeKota());
			dto.setNamaKota(kota.getNamaKota());
			
			listKotaDto.add(dto);
		}
		return listKotaDto;
	}

	@Override
	public void save(MstSupplierDto dto) {
		MstSupplier supplier = new MstSupplier();
		supplier.setKodeSupplier(dto.getKodeSupplier());
		supplier.setNamaSupplier(dto.getNamaSupplier());
		supplier.setAlamatSupplier(dto.getAlamatSupplier());
		supplier.setEmailSupplier(dto.getEmailSupplier());
		supplier.setTelpSupplier(dto.getTelpSupplier());
		supplier.setKodeKota(dto.getKodeKota());
		
		dao.save(supplier);
	}

	@Override
	public void update(MstSupplierDto dto) {
		MstSupplierPK id = new MstSupplierPK();
		id.setKodeSupplier(dto.getKodeSupplier());
		MstSupplier supplier = dao.findOne(id);
		supplier.setNamaSupplier(dto.getNamaSupplier());
		supplier.setAlamatSupplier(dto.getAlamatSupplier());
		supplier.setEmailSupplier(dto.getAlamatSupplier());
		supplier.setTelpSupplier(dto.getTelpSupplier());
		supplier.setKodeKota(dto.getKodeKota());
		dao.save(supplier);
	}

	@Override
	public void delete(String kodeSupplier) {
		MstSupplierPK pk = new MstSupplierPK();
		pk.setKodeSupplier(kodeSupplier);
		dao.delete(pk);
	}

}

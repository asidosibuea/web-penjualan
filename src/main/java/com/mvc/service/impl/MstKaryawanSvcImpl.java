package com.mvc.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstKaryawanDao;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.entity.MstKaryawan;
import com.mvc.entity.pk.MstKaryawanPK;
import com.mvc.service.MstKaryawanSvc;

@Service
@Transactional
public class MstKaryawanSvcImpl implements MstKaryawanSvc {

	@Autowired
	private MstKaryawanDao karyawanDao;
	
	@Override
	public List<MstKaryawanDto> findAllKaryawan() {
		List<MstKaryawan> listKaryawan = karyawanDao.findAll();
		List<MstKaryawanDto> listKaryawanDto = new LinkedList<MstKaryawanDto>();
		for(MstKaryawan karyawan : listKaryawan){
			MstKaryawanDto dto = new MstKaryawanDto();
			dto.setKodeKaryawan(karyawan.getKodeKaryawan());
			dto.setNamaKaryawan(karyawan.getNamaKaryawan());
			dto.setUsername(karyawan.getUsername());
			dto.setPassword(karyawan.getPassword());
			listKaryawanDto.add(dto);
		}
		return listKaryawanDto;
	}

	@Override
	public List<MstKaryawanDto> findKaryawanByParam(String search) {
		List<MstKaryawan> listKaryawan = karyawanDao.findKaryawanByParam(search);
		List<MstKaryawanDto> listKaryawanDto = new LinkedList<MstKaryawanDto>();
		for(MstKaryawan karyawan : listKaryawan){
			MstKaryawanDto dto = new MstKaryawanDto();
			dto.setKodeKaryawan(karyawan.getKodeKaryawan());
			dto.setNamaKaryawan(karyawan.getNamaKaryawan());
			dto.setUsername(karyawan.getUsername());
			dto.setPassword(karyawan.getPassword());
			listKaryawanDto.add(dto);
		}
		return listKaryawanDto;
	}

	@Override
	public void save(MstKaryawanDto dto) {
		MstKaryawan karyawan = new MstKaryawan();
		karyawan.setKodeKaryawan(dto.getKodeKaryawan());
		karyawan.setNamaKaryawan(dto.getNamaKaryawan());
		karyawan.setUsername(dto.getUsername());
		karyawan.setPassword(dto.getPassword());
		karyawanDao.save(karyawan);
		
	}

	@Override
	public void update(MstKaryawanDto dto) {
		MstKaryawanPK id = new MstKaryawanPK();
		id.setKodeKaryawan(dto.getKodeKaryawan());
		MstKaryawan karyawan = karyawanDao.findOne(id);
		karyawan.setNamaKaryawan(dto.getNamaKaryawan());
		karyawan.setUsername(dto.getUsername());
		karyawan.setPassword(dto.getPassword());
		karyawanDao.save(karyawan);
	}

	@Override
	public void delete(String kodeKaryawan) {
		MstKaryawanPK id = new MstKaryawanPK();
		id.setKodeKaryawan(kodeKaryawan);
		karyawanDao.delete(id);
		
	}

}

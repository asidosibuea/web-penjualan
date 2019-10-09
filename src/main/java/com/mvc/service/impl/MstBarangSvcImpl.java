package com.mvc.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstBarangDao;
import com.mvc.dao.MstSupplierDao;
import com.mvc.dto.MstBarangAllDto;
import com.mvc.dto.MstBarangDto;
import com.mvc.entity.MstBarang;
import com.mvc.entity.MstSupplier;
import com.mvc.entity.pk.MstBarangPK;
import com.mvc.service.MstBarangSvc;



@Service
@Transactional
public class MstBarangSvcImpl implements MstBarangSvc{
	
	@Autowired
	private MstBarangDao barangDao;
	
	@Autowired
	private MstSupplierDao supplierDao;

	@Override
	public List<MstBarangAllDto> findAllBarang() {
		List<Object[]> listBarang = barangDao.findAllBarang();
		List<MstBarangAllDto> listBarangDto = new LinkedList<>();
		for(Object[] object : listBarang){
			MstBarang barang = (MstBarang) object[0];
			MstSupplier supplier = (MstSupplier) object[1];
			
			MstBarangAllDto dto = new MstBarangAllDto();
			dto.setKodeBarang(barang.getKodeBarang());
			dto.setNamaBarang(barang.getNamaBarang());
			dto.setStokBarang(barang.getStokBarang());
			dto.setKodeSupplier(barang.getKodeSupplier());
			dto.setNamaSupplier(supplier.getNamaSupplier());
			listBarangDto.add(dto);
		}
		return listBarangDto;
	}

	@Override
	public List<MstBarangAllDto> findBarangByParam(String param) {
		List<Object[]> listBarang = barangDao.findBarangByParam(param);
		List<MstBarangAllDto> listBarangDto = new LinkedList<>();
		for(Object[] object : listBarang){
			MstBarang barang = (MstBarang) object[0];
			MstSupplier supplier = (MstSupplier) object[1];
			
			MstBarangAllDto dto = new MstBarangAllDto();
			dto.setKodeBarang(barang.getKodeBarang());
			dto.setNamaBarang(barang.getNamaBarang());
			dto.setStokBarang(barang.getStokBarang());
			dto.setKodeSupplier(barang.getKodeSupplier());
			dto.setNamaSupplier(supplier.getNamaSupplier());
			listBarangDto.add(dto);
		}
		return listBarangDto;
	}

	@Override
	public void save(MstBarangDto dto) {
		MstBarang barang = new MstBarang();
		barang.setKodeBarang(dto.getKodeBarang());
		barang.setNamaBarang(dto.getNamaBarang());
		barang.setStokBarang(dto.getStokBarang());
		barang.setKodeSupplier(dto.getKodeSupplier());
		barangDao.save(barang);
	}

	@Override
	public void update(MstBarangDto dto) {
		MstBarangPK pk = new MstBarangPK();
		pk.setKodeBarang(dto.getKodeBarang());
		MstBarang barang = barangDao.findOne(pk);
		barang.setNamaBarang(dto.getNamaBarang());
		barang.setStokBarang(dto.getStokBarang());
		barang.setKodeSupplier(dto.getKodeSupplier());
		barangDao.save(barang);
	}

	@Override
	public void delete(String kodeBarang) {
		MstBarangPK pk = new MstBarangPK();
		pk.setKodeBarang(kodeBarang);
		barangDao.delete(pk);
	}

	@Override
	public MstBarangDto findOneBarang(String kodeBarang) {
		MstBarangPK id = new MstBarangPK();
		id.setKodeBarang(kodeBarang);
		MstBarang brg = barangDao.findOne(id);
		MstBarangDto dto = new MstBarangDto();
		dto.setNamaBarang(brg.getNamaBarang());
		dto.setKodeBarang(brg.getKodeBarang());
		dto.setStokBarang(brg.getStokBarang());
		dto.setKodeSupplier(brg.getKodeSupplier());
		return dto;
	}
	


}

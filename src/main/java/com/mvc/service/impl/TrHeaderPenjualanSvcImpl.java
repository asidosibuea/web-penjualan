package com.mvc.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mvc.dao.TrHeaderPenjualanDao;
import com.mvc.dto.TrHeaderPenjualanDto;
import com.mvc.entity.MstCustomer;
import com.mvc.entity.MstKaryawan;
import com.mvc.entity.TrHeaderPenjualan;
import com.mvc.entity.pk.TrHeaderPenjualanPK;
import com.mvc.service.TrHeaderPenjualanSvc;


@Service
@Transactional
public class TrHeaderPenjualanSvcImpl implements TrHeaderPenjualanSvc{
	
	@Autowired
	private TrHeaderPenjualanDao dao;
	
	@Override
	public List<TrHeaderPenjualanDto> findAllPenjualan() {
		List<Object[]> objects = dao.findAllHeaderPenjualan();
		List<TrHeaderPenjualanDto> list = new LinkedList<>();
		for(Object[] object : objects){
			TrHeaderPenjualan header= (TrHeaderPenjualan) object[0];
			MstCustomer customer = (MstCustomer) object[1];
			MstKaryawan karyawan = (MstKaryawan) object[2];
			
			TrHeaderPenjualanDto dto = new TrHeaderPenjualanDto();
			dto.setNoNota(header.getNoNota());
			dto.setNamaCustomer(customer.getNamaCustomer());
			dto.setNamaKaryawan(karyawan.getNamaKaryawan());
			dto.setTanggalTransaksi(header.getTanggalTransaksi());
			dto.setGlobalDiskon(header.getGlobalDiskon());
			dto.setHargaTotal(header.getHargaTotal());
			list.add(dto);
		}
		
		return list;
	}

	@Override
	public void save(TrHeaderPenjualanDto dto) {
		TrHeaderPenjualan entity = new TrHeaderPenjualan();
		entity.setNoNota(dto.getNoNota());
		entity.setKodeCustomer(dto.getKodeCustomer());
		entity.setKodeKaryawan(dto.getKodeKaryawan());
		entity.setTanggalTransaksi(dto.getTanggalTransaksi());
		entity.setGlobalDiskon(dto.getGlobalDiskon());
		entity.setHargaTotal(dto.getHargaTotal());
		dao.save(entity);
		
	}

	@Override
	public void update(TrHeaderPenjualanDto dto) {
		TrHeaderPenjualanPK id = new TrHeaderPenjualanPK();
		id.setNoNota(dto.getNoNota());
		
		TrHeaderPenjualan entity = dao.findOne(id);
//		entity.setNoNota(dto.getNoNota());
		entity.setKodeCustomer(dto.getKodeCustomer());
		entity.setKodeKaryawan(dto.getKodeKaryawan());
		entity.setTanggalTransaksi(dto.getTanggalTransaksi());
		entity.setGlobalDiskon(dto.getGlobalDiskon());
		entity.setHargaTotal(dto.getHargaTotal());
		dao.save(entity);
		
	}

	@Override
	public void delete(String noNota) {
		TrHeaderPenjualanPK id = new TrHeaderPenjualanPK();
		id.setNoNota(noNota);
		
		dao.delete(id);
		
	}
	
	@Override
	public Map<String, Object> searchPenjualan(String cari, int page) {
		Map<String, Object> map = new HashMap<>();
		int sizePerPage = 5;
		Sort sort = new Sort(new Sort.Order(Direction.fromString("asc"), "tanggalTransaksi"));
		Pageable pageable = new PageRequest(page-1, sizePerPage, sort);
		List<Object[]> listObject = dao.search(cari, pageable);
		List<TrHeaderPenjualanDto> listDto = new LinkedList<>();
		for(Object[] object : listObject){
			TrHeaderPenjualan header= (TrHeaderPenjualan) object[0];
			MstCustomer customer = (MstCustomer) object[1];
			MstKaryawan karyawan = (MstKaryawan) object[2];
			
			TrHeaderPenjualanDto dto = new TrHeaderPenjualanDto();
			dto.setNoNota(header.getNoNota());
			dto.setNamaCustomer(customer.getNamaCustomer());
			dto.setNamaKaryawan(karyawan.getNamaKaryawan());
			dto.setTanggalTransaksi(header.getTanggalTransaksi());
			dto.setGlobalDiskon(header.getGlobalDiskon());
			dto.setHargaTotal(header.getHargaTotal());
			listDto.add(dto);
		}
		
		int jumlahHalaman = 0;
		int jumlahData = dao.countSearch(cari);
		jumlahHalaman = jumlahData/sizePerPage;
		if(jumlahData%sizePerPage > 0){
			jumlahHalaman++;
		}
		map.put("list", listDto);
		map.put("jumlahHalaman", jumlahHalaman);
		
		return map;
	}

	@Override
	public TrHeaderPenjualanDto findPenjualanByNoNota(String noNota) {
		TrHeaderPenjualanPK pk = new TrHeaderPenjualanPK();
		pk.setNoNota(noNota);
		
		TrHeaderPenjualan entity = dao.findOne(pk);
		TrHeaderPenjualanDto dto = new TrHeaderPenjualanDto();
		
		dto.setNoNota(entity.getNoNota());
		dto.setKodeCustomer(entity.getKodeCustomer());
		dto.setKodeKaryawan(entity.getKodeKaryawan());
		dto.setTanggalTransaksi(entity.getTanggalTransaksi());
		dto.setGlobalDiskon(entity.getGlobalDiskon());
		dto.setHargaTotal(entity.getHargaTotal());
		return dto;
	}

}

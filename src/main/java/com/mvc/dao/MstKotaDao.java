package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.MstKota;
import com.mvc.entity.pk.MstKotaPK;


public interface MstKotaDao extends JpaRepository<MstKota, MstKotaPK>{
	
	@Query("Select kota, provinsi from MstKota kota, MstProvinsi provinsi "
			+ "where kota.kodeProvinsi = provinsi.kodeProvinsi "
			+ "and kota.kodeKota like %:param% or kota.namaKota like %:param%")
	public List<Object[]> findKotaJoinProvinsiByParam(@Param("param") String search);
	
	@Query("Select kota, provinsi from MstKota kota, MstProvinsi provinsi "
			+ "where kota.kodeProvinsi = provinsi.kodeProvinsi")
	public List<Object[]> findAllKotaJoinProvinsi();

}

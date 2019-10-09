package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.MstProvinsi;
import com.mvc.entity.pk.MstProvinsiPK;


public interface MstProvinsiDao extends JpaRepository<MstProvinsi, MstProvinsiPK> {
	
	@Query("Select provinsi from MstProvinsi provinsi "
			+ "where provinsi.kodeProvinsi like %:param% or provinsi.namaProvinsi like %:param%")
	public List<MstProvinsi> findProvinsiByParam(@Param("param") String search);

}

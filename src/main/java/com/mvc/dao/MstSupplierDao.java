package com.mvc.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.MstSupplier;
import com.mvc.entity.pk.MstSupplierPK;


public interface MstSupplierDao extends JpaRepository<MstSupplier, MstSupplierPK>{
	
	@Query("Select supplier, kota from MstSupplier supplier, MstKota kota "
			+ "where supplier.kodeKota = kota.kodeKota ")
	public List<Object[]> findAllSupplierJoinKota();
	
	@Query("Select supplier, kota from MstSupplier supplier, MstKota kota "
			+ "where supplier.kodeKota = kota.kodeKota "
			+ "and supplier.kodeSupplier like %:param% or supplier.namaSupplier like %:param%")
	public List<Object[]> findAllSupplierJoinKotaByParam(@Param("param") String search);

}

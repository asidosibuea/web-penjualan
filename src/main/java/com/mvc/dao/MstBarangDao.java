package com.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mvc.entity.MstBarang;
import com.mvc.entity.pk.MstBarangPK;


@Repository
public interface MstBarangDao extends JpaRepository<MstBarang, MstBarangPK> {
	
	@Query("Select barang, supplier from MstBarang barang, MstSupplier supplier "
			+ "where barang.kodeSupplier = supplier.kodeSupplier "
			+ "and (barang.kodeBarang like %:param% or barang.namaBarang like %:param%)")
	public List<Object[]> findBarangByParam(@Param("param") String param);
	
	@Query("Select barang, supplier from MstBarang barang, MstSupplier supplier "
			+ "where barang.kodeSupplier = supplier.kodeSupplier ")
	public List<Object[]> findAllBarang();

}

package com.mvc.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.TrHeaderPenjualan;
import com.mvc.entity.pk.TrHeaderPenjualanPK;


public interface TrHeaderPenjualanDao extends JpaRepository<TrHeaderPenjualan, TrHeaderPenjualanPK>{

	@Query("Select a, b, c from TrHeaderPenjualan a, MstCustomer b, MstKaryawan c "
			+ "where a.kodeCustomer = b.kodeCustomer and "
			+ "a.kodeKaryawan = c.kodeKaryawan ")
	public List<Object[]> findAllHeaderPenjualan();
	
	@Query("Select a, b, c from TrHeaderPenjualan a, MstCustomer b, MstKaryawan c "
			+ "where a.kodeCustomer = b.kodeCustomer and "
			+ "a.kodeKaryawan = c.kodeKaryawan "
			+ "and a.noNota = :noNota")
	public Object[] findPenjualanByNoNota(@Param("noNota") String noNota);
	
	@Query("Select a, b, c from TrHeaderPenjualan a, MstCustomer b, MstKaryawan c "
			+ "where a.kodeCustomer = b.kodeCustomer and "
			+ "a.kodeKaryawan = c.kodeKaryawan "
			+ "and (b.namaCustomer like %:cari% or c.namaKaryawan like %:cari%)")
	public List<Object[]> search(@Param("cari") String cari, Pageable pageable);
	
	@Query("Select count(a.noNota) from TrHeaderPenjualan a, MstCustomer b, MstKaryawan c "
			+ "where a.kodeCustomer = b.kodeCustomer and "
			+ "a.kodeKaryawan = c.kodeKaryawan "
			+ "and (b.namaCustomer like %:cari% or c.namaKaryawan like %:cari%)")
	public int countSearch(@Param("cari") String cari);
}

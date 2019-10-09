package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.TrDetailPenjualan;
import com.mvc.entity.pk.TrDetailPenjualanPK;


public interface TrDetailPenjualanDao extends JpaRepository<TrDetailPenjualan, TrDetailPenjualanPK> {
	
	@Query("select a, b, c from TrDetailPenjualan a, TrHeaderPenjualan b, MstBarang c "
			+ "where a.noNota = b.noNota "
			+ "and a.kodeBarang = c.kodeBarang "
			+ "and a.noNota like :noNota")
	public List<Object[]> findAllDetailPenjualan(@Param("noNota") String noNota);
	
	@Modifying
	@Query("delete TrDetailPenjualan td where td.noNota = :noNota")
	public void deleteDetail(@Param("noNota") String noNota);
	
	
}

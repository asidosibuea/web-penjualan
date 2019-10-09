package com.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.MstCustomer;
import com.mvc.entity.pk.MstCustomerPK;

import java.util.*;

public interface MstCustomerDao extends JpaRepository<MstCustomer, MstCustomerPK> {
	
	@Query("select customer, kota from MstCustomer customer, MstKota kota "
			+ "where customer.kodeKota = kota.kodeKota")
	public List<Object[]> findAllCustomer();
	
	@Query("select customer, kota from MstCustomer customer, MstKota kota "
			+ "where customer.kodeKota = kota.kodeKota "
			+ "and customer.kodeCustomer like %:param% or customer.namaCustomer like %:param%")
	public List<Object[]> findAllCustomerByParam(@Param("param") String search);
}

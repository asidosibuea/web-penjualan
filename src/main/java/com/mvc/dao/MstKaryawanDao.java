package com.mvc.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.MstKaryawan;
import com.mvc.entity.pk.MstKaryawanPK;

public interface MstKaryawanDao extends JpaRepository<MstKaryawan, MstKaryawanPK> {
	
	@Query("Select karyawan from MstKaryawan karyawan "
			+ "where karyawan.kodeKaryawan like %:param% or karyawan.namaKaryawan like %:param%")
	public List<MstKaryawan> findKaryawanByParam(@Param("param") String search);

}

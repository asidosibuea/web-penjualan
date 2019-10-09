package com.mvc.service;

import java.util.*;

import com.mvc.dto.MstSupplierDto;
import com.mvc.dto.MstSupplierJoinKotaDto;

public interface MstSupplierSvc {
	
	public List<MstSupplierJoinKotaDto> findAllSupplier();
	public List<MstSupplierJoinKotaDto> findAllSupplierByParam(String search);
	public void save(MstSupplierDto dto);
	public void update(MstSupplierDto dto);
	public void delete(String kodeSupplier);

}

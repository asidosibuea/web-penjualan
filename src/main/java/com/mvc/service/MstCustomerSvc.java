package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstCustomerAllDto;
import com.mvc.dto.MstCustomerDto;


public interface MstCustomerSvc {
	
	public List<MstCustomerAllDto> findAllCustomer();
	public List<MstCustomerAllDto> findCustomerByParam(String search);
	public void save(MstCustomerDto dto);
	public void update(MstCustomerDto dto);
	public void delete(String kodeCustomer);

}

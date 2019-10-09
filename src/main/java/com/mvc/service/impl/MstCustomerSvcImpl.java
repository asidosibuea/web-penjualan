package com.mvc.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstCustomerDao;
import com.mvc.dao.MstKotaDao;
import com.mvc.dto.MstCustomerAllDto;
import com.mvc.dto.MstCustomerDto;
import com.mvc.entity.MstCustomer;
import com.mvc.entity.MstKota;
import com.mvc.entity.pk.MstCustomerPK;
import com.mvc.service.MstCustomerSvc;


@Service
@Transactional
public class MstCustomerSvcImpl implements MstCustomerSvc{
	
	@Autowired
	private MstCustomerDao customerDao;

	@Autowired
	private MstKotaDao kotaDao;
	
	@Override
	public List<MstCustomerAllDto> findAllCustomer() {
		List<Object[]> listCustomer = customerDao.findAllCustomer();
		List<MstCustomerAllDto> listCustomerDto = new LinkedList<>();
		for(Object[] object : listCustomer){
			MstCustomer customer = (MstCustomer) object[0];
			MstKota kota = (MstKota) object[1];
			
			MstCustomerAllDto dto = new MstCustomerAllDto();
			dto.setKodeCustomer(customer.getKodeCustomer());
			dto.setNamaCustomer(customer.getNamaCustomer());
			dto.setAlamatCustomer(customer.getAlamatCustomer());
			dto.setEmailCustomer(customer.getEmailCustomer());
			dto.setJenisKelamin(customer.getJenisKelamin());
			dto.setKodeKota(customer.getKodeKota());
			dto.setNamaKota(kota.getNamaKota());
			listCustomerDto.add(dto);
		}
		return listCustomerDto;
	}

	@Override
	public List<MstCustomerAllDto> findCustomerByParam(String search) {
		List<Object[]> listCustomer = customerDao.findAllCustomerByParam(search);
		List<MstCustomerAllDto> listCustomerDto = new LinkedList<>();
		for(Object[] object : listCustomer){
			MstCustomer customer = (MstCustomer) object[0];
			MstKota kota = (MstKota) object[1];
			
			MstCustomerAllDto dto = new MstCustomerAllDto();
			dto.setKodeCustomer(customer.getKodeCustomer());
			dto.setNamaCustomer(customer.getNamaCustomer());
			dto.setAlamatCustomer(customer.getAlamatCustomer());
			dto.setEmailCustomer(customer.getEmailCustomer());
			dto.setJenisKelamin(customer.getJenisKelamin());
			dto.setKodeKota(customer.getKodeKota());
			dto.setNamaKota(kota.getNamaKota());
			listCustomerDto.add(dto);
		}
		return listCustomerDto;
	}

	@Override
	public void save(MstCustomerDto dto) {
		MstCustomer customer = new MstCustomer();
		customer.setKodeCustomer(dto.getKodeCustomer());
		customer.setNamaCustomer(dto.getNamaCustomer());
		customer.setAlamatCustomer(dto.getAlamatCustomer());
		customer.setEmailCustomer(dto.getEmailCustomer());
		customer.setJenisKelamin(dto.getJenisKelamin());
		customer.setKodeKota(dto.getKodeKota());
		customerDao.save(customer);
		
	}

	@Override
	public void update(MstCustomerDto dto) {
		MstCustomerPK pk = new MstCustomerPK();
		pk.setKodeCustomer(dto.getKodeCustomer());
		MstCustomer customer = customerDao.findOne(pk);
		customer.setNamaCustomer(dto.getNamaCustomer());
		customer.setAlamatCustomer(dto.getAlamatCustomer());
		customer.setEmailCustomer(dto.getEmailCustomer());
		customer.setJenisKelamin(dto.getJenisKelamin());
		customer.setKodeKota(dto.getKodeKota());
		customerDao.save(customer);
	}

	@Override
	public void delete(String kodeCustomer) {
		MstCustomerPK id = new MstCustomerPK();
		id.setKodeCustomer(kodeCustomer);
		customerDao.delete(id);
		
	}
	
	

}

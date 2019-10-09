package com.mvc.dto;

import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

public class TrHeaderPenjualanDto {
	
	private String noNota;
	private int globalDiskon;
	private int hargaTotal;
	private String kodeCustomer;
	private String kodeKaryawan;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date tanggalTransaksi;
	private String namaCustomer;
	private String namaKaryawan;
	private List<TrDetailPenjualanDto> listDetilDto;
	
	public List<TrDetailPenjualanDto> getListDetilDto() {
		return listDetilDto;
	}

	public void addListDetilDto(TrDetailPenjualanDto detilDto) {
		this.listDetilDto.add(detilDto);
	}

	public String getNamaCustomer() {
		return namaCustomer;
	}

	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}

	public String getNamaKaryawan() {
		return namaKaryawan;
	}

	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}

	public String getNoNota() {
		return noNota;
	}
	
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	
	public int getGlobalDiskon() {
		return globalDiskon;
	}
	
	public void setGlobalDiskon(int globalDiskon) {
		this.globalDiskon = globalDiskon;
	}
	
	public int getHargaTotal() {
		return hargaTotal;
	}
	
	public void setHargaTotal(int hargaTotal) {
		this.hargaTotal = hargaTotal;
	}
	
	public String getKodeCustomer() {
		return kodeCustomer;
	}
	
	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}
	
	public String getKodeKaryawan() {
		return kodeKaryawan;
	}
	
	public void setKodeKaryawan(String kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}
	
	public Date getTanggalTransaksi() {
		return tanggalTransaksi;
	}
	
	public void setTanggalTransaksi(Date tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}
	
}

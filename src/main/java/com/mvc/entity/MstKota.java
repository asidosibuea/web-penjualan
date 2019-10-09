package com.mvc.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.mvc.entity.pk.MstKotaPK;


/**
 * The persistent class for the MST_KOTA database table.
 * 
 */
@Entity
@Table(name="MST_KOTA")
@IdClass(MstKotaPK.class)
@NamedQuery(name="MstKota.findAll", query="SELECT m FROM MstKota m")
public class MstKota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="KODE_KOTA")
	private String kodeKota;

	@Column(name="KODE_PROVINSI")
	private String kodeProvinsi;

	@Column(name="NAMA_KOTA")
	private String namaKota;

	public MstKota() {
	}

	public String getKodeKota() {
		return this.kodeKota;
	}

	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
	}

	public String getKodeProvinsi() {
		return this.kodeProvinsi;
	}

	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}

	public String getNamaKota() {
		return this.namaKota;
	}

	public void setNamaKota(String namaKota) {
		this.namaKota = namaKota;
	}

}
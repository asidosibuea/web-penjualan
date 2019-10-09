package com.mvc.entity.pk;

import java.io.Serializable;

public class MstBarangPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String kodeBarang;
	
	public String getKodeBarang() {
		return kodeBarang;
	}
	
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((kodeBarang == null) ? 0 : kodeBarang.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MstBarangPK other = (MstBarangPK) obj;
		if (kodeBarang == null) {
			if (other.kodeBarang != null)
				return false;
		} else if (!kodeBarang.equals(other.kodeBarang))
			return false;
		return true;
	}
	
}

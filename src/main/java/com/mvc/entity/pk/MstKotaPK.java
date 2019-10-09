package com.mvc.entity.pk;

import java.io.Serializable;

public class MstKotaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String kodeKota;

	public String getKodeKota() {
		return kodeKota;
	}

	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((kodeKota == null) ? 0 : kodeKota.hashCode());
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
		MstKotaPK other = (MstKotaPK) obj;
		if (kodeKota == null) {
			if (other.kodeKota != null)
				return false;
		} else if (!kodeKota.equals(other.kodeKota))
			return false;
		return true;
	}
	
}

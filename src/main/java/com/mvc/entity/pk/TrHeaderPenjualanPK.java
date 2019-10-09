package com.mvc.entity.pk;

import java.io.Serializable;

public class TrHeaderPenjualanPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String noNota;

	public String getNoNota() {
		return noNota;
	}

	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noNota == null) ? 0 : noNota.hashCode());
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
		TrHeaderPenjualanPK other = (TrHeaderPenjualanPK) obj;
		if (noNota == null) {
			if (other.noNota != null)
				return false;
		} else if (!noNota.equals(other.noNota))
			return false;
		return true;
	}
	
	

}

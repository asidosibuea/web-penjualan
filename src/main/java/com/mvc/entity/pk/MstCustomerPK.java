package com.mvc.entity.pk;

import java.io.Serializable;

public class MstCustomerPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String kodeCustomer;

	public String getKodeCustomer() {
		return kodeCustomer;
	}

	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((kodeCustomer == null) ? 0 : kodeCustomer.hashCode());
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
		MstCustomerPK other = (MstCustomerPK) obj;
		if (kodeCustomer == null) {
			if (other.kodeCustomer != null)
				return false;
		} else if (!kodeCustomer.equals(other.kodeCustomer))
			return false;
		return true;
	}
	
	
	
}

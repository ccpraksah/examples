package com.upgrad.aadhaar;

import java.util.Date;

public class AdharIdentifier {

	private int identifier;
	private String fingerPrints;
	private String eyePrints;
	private String name;
	private String address;
	private Date dob;

	/**
	 * @return the identifier
	 */
	public int getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier
	 *            the identifier to set
	 */
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the fingerPrints
	 */
	public String getFingerPrints() {
		return fingerPrints;
	}

	/**
	 * @param fingerPrints
	 *            the fingerPrints to set
	 */
	public void setFingerPrints(String fingerPrints) {
		this.fingerPrints = fingerPrints;
	}

	/**
	 * @return the eyePrints
	 */
	public String getEyePrints() {
		return eyePrints;
	}

	/**
	 * @param eyePrints
	 *            the eyePrints to set
	 */
	public void setEyePrints(String eyePrints) {
		this.eyePrints = eyePrints;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eyePrints == null) ? 0 : eyePrints.hashCode());
		result = prime * result + ((fingerPrints == null) ? 0 : fingerPrints.hashCode());
		result = prime * result + identifier;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AdharIdentifier other = (AdharIdentifier) obj;
		if (eyePrints == null) {
			if (other.eyePrints != null)
				return false;
		} else if (!eyePrints.equals(other.eyePrints)) {
			return false;
		}
		if (fingerPrints == null) {
			if (other.fingerPrints != null)
				return false;
		} else if (!fingerPrints.equals(other.fingerPrints)) {
			return false;
		}
		if (identifier != other.identifier) {
			return false;
		}
		return true;
	}

}

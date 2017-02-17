package com.challenge.dto;

import java.io.Serializable;

public class ShopAddressDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Street Number
	 */
	private String number;
	
	/**
	 * Postal Code
	 */
	private String postCode;
	
	/**
	 * Get shop number
	 * @return number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Set shop number
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Get postal code
	 * @return postCode
	 */
	public String getPostCode() {
		return postCode;
	}
	
	/**
	 * Set postal code
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}

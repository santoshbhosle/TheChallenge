package com.challenge.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShopDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Name of shop
	 */
	private String shopName;
	
	/**
	 * Longitude - location of shop
	 */
	private String shopLongitude;
	
	/**
	 * Latitude - location of shop
	 */
	private String shopLatitude;
	
	
	/**
	 * Address details of shop 
	 */
	@JsonProperty(value="shopAddress")
	private ShopAddressDTO shopAddressDTO;
	
	/**
	 * Get name of shop
	 * @return shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Set name of shop
	 * @param shopName
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Get shop longitude
	 * @return shopLongitude
	 */
	public String getShopLongitude() {
		return shopLongitude;
	}

	/**
	 * Set shop longitude
	 * @param shopLongitude
	 */
	public void setShopLongitude(String shopLongitude) {
		this.shopLongitude = shopLongitude;
	}

	/**
	 * Get shop latitude
	 * @return shopLatitude
	 */
	public String getShopLatitude() {
		return shopLatitude;
	}

	/**
	 * Set shop latitude
	 * @param shopLatitude
	 */
	public void setShopLatitude(String shopLatitude) {
		this.shopLatitude = shopLatitude;
	}
	
	/**
	 * Get shop address
	 * @return shopAddressDTO
	 */
	public ShopAddressDTO getShopAddressDTO() {
		return shopAddressDTO;
	}

	/**
	 * Set shop address
	 * @param shopAddressDTO
	 */
	public void setShopAddressDTO(ShopAddressDTO shopAddressDTO) {
		this.shopAddressDTO = shopAddressDTO;
	}

}

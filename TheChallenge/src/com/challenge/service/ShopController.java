package com.challenge.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.GeocodeResponseDTO;
import com.challenge.dto.ResultDTO;
import com.challenge.dto.ShopDTO;
import com.challenge.helper.ShopHelper;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/shops")
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
			
	private List<ShopDTO> shopList = Collections.synchronizedList(new ArrayList<>());
	
	/**
	 * This method adds shop to shopList.
	 * @param shopDTO
	 * @return string
	 */
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addShop(@RequestBody ShopDTO shopDTO){
		
		JsonNode node = ShopHelper.getGeocoding(shopDTO);
		
		StringBuffer sb = new StringBuffer("Shop \"");   
		sb.append(shopDTO.getShopName()); 
		if(node != null){
			String status = node.findValue("status").asText();
			logger.debug("Status : " + status);
			
			if("OK".equals(status)){
				shopDTO.setShopLatitude(node.findValue("lat").asText());
				shopDTO.setShopLongitude(node.findValue("lng").asText());
				shopList.add(shopDTO);
				sb.append("\" added successfully !");
			} else {
				sb.append("\" not added due to ");
				sb.append(status);
			}
		} else {
			sb.append("\" not added !");
		}
		
		logger.debug("Result : " + sb.toString());
		return sb.toString();
	}
	
	/**
	 * This method returns list of all shops
	 * @return List of shops
	 */
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ShopDTO> getAllShops(){
		return shopList;
	}
	
	/**
	 * This method retrieves shop list based on latitude and longitude 
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	@RequestMapping(value="/shop", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getShopsByGeocodes(@RequestParam("shopLatitude") String latitude, @RequestParam("shopLongitude") String longitude){
		List<String> shopList = new ArrayList<>();
		
		GeocodeResponseDTO geocodeResponseDTO = ShopHelper.getReverseGeocoding(latitude, longitude);
		
		if(null != geocodeResponseDTO){
			logger.debug("Status : " + geocodeResponseDTO.getStatus());
			
			if("OK".equals(geocodeResponseDTO.getStatus())) {
				ResultDTO[] resultArr = geocodeResponseDTO.getResult();
				for (int i = 0; i < resultArr.length; i++) {
					shopList.add(resultArr[i].getFormatted_address());
				}
			}else{
				shopList.add(geocodeResponseDTO.getStatus());
			}
		}else{
			shopList.add("Error while retrieving shops !");
		}
		logger.debug("Shop List : " + shopList.toString());
		return shopList;
	}
}

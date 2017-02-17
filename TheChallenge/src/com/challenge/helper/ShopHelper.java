package com.challenge.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.challenge.dto.GeocodeResponseDTO;
import com.challenge.dto.ShopDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShopHelper {

	private static final Logger logger = LoggerFactory.getLogger(ShopHelper.class);
			
	public static JsonNode getGeocoding(ShopDTO shopDTO) {
		HttpURLConnection conn = null;
		JsonNode node = null;
		try {
			
			StringBuffer encodedUrl = new StringBuffer("http://maps.googleapis.com/maps/api/geocode/json?address=");
			encodedUrl.append(URLEncoder.encode(shopDTO.getShopName(), "UTF-8"));
			if(null != shopDTO.getShopAddressDTO().getNumber()){
				encodedUrl.append(URLEncoder.encode(" ", "UTF-8")); 
				encodedUrl.append(shopDTO.getShopAddressDTO().getNumber());
			}
			if(null != shopDTO.getShopAddressDTO().getPostCode()){
				encodedUrl.append(URLEncoder.encode(" ", "UTF-8"));
				encodedUrl.append(shopDTO.getShopAddressDTO().getPostCode());
			}
			
			URL url = new URL(encodedUrl.toString());
			
			logger.debug("url query :: " + url.getQuery());
			
			SocketAddress addr = new InetSocketAddress("proxy.cognizant.com", 6050);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
					
			conn = (HttpURLConnection) url.openConnection(proxy);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			logger.debug("Output from Server .... \n");
			String geocodingResponse = read(conn.getInputStream());
			logger.debug(geocodingResponse);
			
			ObjectMapper mapper = new ObjectMapper();
			node = mapper.readTree(geocodingResponse);
		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }finally {
			conn.disconnect();
		}
		
		return node;
	}

	private static String read(InputStream input) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            return br.lines().collect(Collectors.joining("\n"));
        }
    }
	
	public static GeocodeResponseDTO getReverseGeocoding(String latitude, String longitude) {
		HttpURLConnection conn = null;
		GeocodeResponseDTO geocodingResponseDTO = null;
		try {
			StringBuffer sb = new StringBuffer("http://maps.googleapis.com/maps/api/geocode/xml?latlng=");
			sb.append(latitude);
			sb.append(URLEncoder.encode(",", "UTF-8"));
			sb.append(longitude);
			
			URL url = new URL(sb.toString());
			
			logger.debug("url query :: " + url.getQuery());
			
			SocketAddress addr = new InetSocketAddress("proxy.cognizant.com", 6050);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
					
			conn = (HttpURLConnection) url.openConnection(proxy);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			logger.debug("Output from Server .... \n");
			String geocodingResponse = read(conn.getInputStream());
			logger.debug(geocodingResponse);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(GeocodeResponseDTO.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();	    
			StringReader reader = new StringReader(geocodingResponse);
			geocodingResponseDTO = (GeocodeResponseDTO) unmarshaller.unmarshal(reader);	
			
		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  } catch (Exception e) {
			e.printStackTrace();
		  }finally {
			conn.disconnect();
		}
		
		return geocodingResponseDTO;
	}
}

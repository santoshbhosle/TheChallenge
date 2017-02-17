package com.challenge.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="result")
public class ResultDTO implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String place_id;

    private AddressComponentsDTO[] address_components;

    private String formatted_address;

    private String[] types;

    private GeometryDTO geometry;

    public String getPlace_id ()
    {
        return place_id;
    }

    public void setPlace_id (String place_id)
    {
        this.place_id = place_id;
    }

    public AddressComponentsDTO[] getAddress_components ()
    {
        return address_components;
    }

    public void setAddress_components (AddressComponentsDTO[] address_components)
    {
        this.address_components = address_components;
    }

    public String getFormatted_address ()
    {
        return formatted_address;
    }

    public void setFormatted_address (String formatted_address)
    {
        this.formatted_address = formatted_address;
    }

    public String[] getTypes ()
    {
        return types;
    }

    public void setTypes (String[] types)
    {
        this.types = types;
    }

    public GeometryDTO getGeometry ()
    {
        return geometry;
    }

    public void setGeometry (GeometryDTO geometry)
    {
        this.geometry = geometry;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [place_id = "+place_id+", address_components = "+address_components+", formatted_address = "+formatted_address+", types = "+types+", geometry = "+geometry+"]";
    }
}
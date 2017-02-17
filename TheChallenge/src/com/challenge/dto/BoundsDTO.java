package com.challenge.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="bounds")
public class BoundsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SouthwestSTO southwest;

    private NortheastDTO northeast;

    public SouthwestSTO getSouthwest ()
    {
        return southwest;
    }

    public void setSouthwest (SouthwestSTO southwest)
    {
        this.southwest = southwest;
    }

    public NortheastDTO getNortheast ()
    {
        return northeast;
    }

    public void setNortheast (NortheastDTO northeast)
    {
        this.northeast = northeast;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [southwest = "+southwest+", northeast = "+northeast+"]";
    }
}

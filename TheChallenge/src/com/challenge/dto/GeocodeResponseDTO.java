package com.challenge.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="GeocodeResponse")
public class GeocodeResponseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ResultDTO[] result;

    private String status;

    public ResultDTO[] getResult ()
    {
        return result;
    }

    public void setResult (ResultDTO[] result)
    {
        this.result = result;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [result = "+result+", status = "+status+"]";
    }
}

package com.challenge.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="geometry")
public class GeometryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BoundsDTO bounds;

    private ViewportDTO viewport;

    private String location_type;

    private LocationDTO location;

    public BoundsDTO getBounds ()
    {
        return bounds;
    }

    public void setBounds (BoundsDTO bounds)
    {
        this.bounds = bounds;
    }

    public ViewportDTO getViewport ()
    {
        return viewport;
    }

    public void setViewport (ViewportDTO viewport)
    {
        this.viewport = viewport;
    }

    public String getLocation_type ()
    {
        return location_type;
    }

    public void setLocation_type (String location_type)
    {
        this.location_type = location_type;
    }

    public LocationDTO getLocation ()
    {
        return location;
    }

    public void setLocation (LocationDTO location)
    {
        this.location = location;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [bounds = "+bounds+", viewport = "+viewport+", location_type = "+location_type+", location = "+location+"]";
    }

}

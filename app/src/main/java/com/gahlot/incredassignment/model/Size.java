package com.gahlot.incredassignment.model;

public class Size {
    private String width;

    private String label;

    private String source;

    private String media;

    private String url;

    private String height;

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getMedia ()
    {
        return media;
    }

    public void setMedia (String media)
    {
        this.media = media;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [width = "+width+", label = "+label+", source = "+source+", media = "+media+", url = "+url+", height = "+height+"]";
    }
}

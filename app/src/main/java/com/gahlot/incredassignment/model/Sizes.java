package com.gahlot.incredassignment.model;

import java.util.ArrayList;

public class Sizes {

    private ArrayList<Size> size;

    private String canprint;

    private String canblog;

    private String candownload;

    public ArrayList<Size> getSize() {
        return size;
    }

    public void setSize(ArrayList<Size> size) {
        this.size = size;
    }

    public String getCanprint ()
    {
        return canprint;
    }

    public void setCanprint (String canprint)
    {
        this.canprint = canprint;
    }

    public String getCanblog ()
    {
        return canblog;
    }

    public void setCanblog (String canblog)
    {
        this.canblog = canblog;
    }

    public String getCandownload ()
    {
        return candownload;
    }

    public void setCandownload (String candownload)
    {
        this.candownload = candownload;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [size = "+size+", canprint = "+canprint+", canblog = "+canblog+", candownload = "+candownload+"]";
    }
}

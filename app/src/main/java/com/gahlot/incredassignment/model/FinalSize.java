package com.gahlot.incredassignment.model;

public class FinalSize {

    private String stat;

    private Sizes sizes;

    public String getStat ()
    {
        return stat;
    }

    public void setStat (String stat)
    {
        this.stat = stat;
    }

    public Sizes getSizes ()
    {
        return sizes;
    }

    public void setSizes (Sizes sizes)
    {
        this.sizes = sizes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [stat = "+stat+", sizes = "+sizes+"]";
    }

}

/******************************************************************************
 * Copyright (c) 2012 SerenDipity Corporation                                 *
 * All Rights Reserved.                                                       *
 * Author: Vinogradov Eugene                                                  *
 ******************************************************************************/

package ua.pp.serendipity.eticket.structure;

public class Flight {
    private String flightFrom;
    private String flightTo;
    private String flight;
    private String cl;
    private String date;
    private String dep;
    private String fareBasis;
    private String nvb;
    private String nva;
    private String bag;
    private String st;

    public Flight() {
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getFareBasis() {
        return fareBasis;
    }

    public void setFareBasis(String fareBasis) {
        this.fareBasis = fareBasis;
    }

    public String getNvb() {
        return nvb;
    }

    public void setNvb(String nvb) {
        this.nvb = nvb;
    }

    public String getNva() {
        return nva;
    }

    public void setNva(String nva) {
        this.nva = nva;
    }

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }
}

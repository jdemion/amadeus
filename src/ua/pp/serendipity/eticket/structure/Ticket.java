/******************************************************************************
 * Copyright (c) 2012 SerenDipity Corporation                                 *
 * All Rights Reserved.                                                       *
 * Author: Vinogradov Eugene                                                  *
 ******************************************************************************/

package ua.pp.serendipity.eticket.structure;

public class Ticket {
    private String firstName;
    private String lastName;
    private String phone;

    private String issuingAirline;
    private String airline;
    private String ticketNumber;
    private String bRefAmadeus;
    private String bRefAirline;
    private String dateOfSale;

    public Ticket() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIssuingAirline() {
        return issuingAirline;
    }

    public void setIssuingAirline(String issuingAirline) {
        this.issuingAirline = issuingAirline;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getbRefAmadeus() {
        return bRefAmadeus;
    }

    public void setbRefAmadeus(String bRefAmadeus) {
        this.bRefAmadeus = bRefAmadeus;
    }

    public String getbRefAirline() {
        return bRefAirline;
    }

    public void setbRefAirline(String bRefAirline) {
        this.bRefAirline = bRefAirline;
    }

    public String getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }
}

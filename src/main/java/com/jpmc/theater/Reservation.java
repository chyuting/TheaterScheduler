package com.jpmc.theater;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Customer getCustomer() {
        return this.customer;
    }

    public Showing getShowing() {
        return this.showing;
    }

    public int getAudient() {
        return this.audienceCount;
    }

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    public double totalFee() {
        return showing.calculateTicketPrice() * audienceCount;
    }
}
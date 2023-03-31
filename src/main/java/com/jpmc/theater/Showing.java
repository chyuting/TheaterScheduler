package com.jpmc.theater;

import java.time.LocalDateTime;

public class Showing {
    private static int MOVIE_CODE_SPECIAL = 1;

    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public boolean isSequence(int sequence) {
        return sequenceOfTheDay == sequence;
    }

    public double getMovieFee() {
        return movie.getTicketPrice();
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    public double calculateTicketPrice() {
        return getMovieFee() - getDiscount(getSequenceOfTheDay());
    }

    private double getDiscount(int showSequence) {
        double specialDiscount = 0;
        if(showStartTime.getHour() >= 11 && showStartTime.getHour() < 16) {
            specialDiscount = getMovieFee() * 0.25; // 25% discount for movie starting between 11 am - 4 pm
        }
        else if (MOVIE_CODE_SPECIAL == movie.getSpecialCode()) {
            specialDiscount = getMovieFee() * 0.2;  // 20% discount for special movie
        }

        double sequenceDiscount = 0;
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showSequence == 2) {
            sequenceDiscount = 2; // $2 discount for 2nd show
        } else if(showStartTime.getDayOfMonth() == 7) {
            sequenceDiscount = 1; // $1 discount for 7th day movies
        }

        // biggest discount wins
        return Math.max(specialDiscount, sequenceDiscount);
    }

    @Override
    public String toString() {
        return  getStartTime() + " " + movie.getTitle() + " sequence: " + sequenceOfTheDay +  " " + Theater.humanReadableFormat(movie.getRunningTime()) + " $" + getMovieFee() + " after discount $" + calculateTicketPrice();
    }
}

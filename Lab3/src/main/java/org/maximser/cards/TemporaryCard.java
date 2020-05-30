package org.maximser.cards;

import org.maximser.cardtype.IntervalType;
import org.maximser.cardtype.OwnerType;

import java.util.Date;
import java.util.UUID;

public class TemporaryCard extends Card {

    private IntervalType intervalType;
    private Date finalDate;
    private int hoursInDay = 24;
    private int minutesInHour = 60;
    private int secondsInMinute = 60;
    private int millisecondInSecond = 1000;

    public TemporaryCard(UUID uniqueId, OwnerType ownerType, IntervalType intervalType) {
        super(uniqueId, ownerType);
        this.intervalType = intervalType;
        finalDate = new Date(new Date().getTime() + (long) intervalType.getDaysLeft() * hoursInDay * minutesInHour * secondsInMinute * millisecondInSecond);
    }

    public IntervalType getIntervalType() {
        return intervalType;
    }

    public boolean verify() {
        boolean isVerified = new Date().before(this.finalDate);
        if (!isVerified) block();
        if (this.getOwnerType() == OwnerType.HALF_PRICE){
            System.out.println("Need to be checked");
        }
        return isVerified;
    }

    @Override
    public String toString() {
        return "Card type: temporary card\n" +
                "Expiration date: " + this.finalDate.toString() + "\n";
    }
}

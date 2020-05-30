package org.maximser.cardtype;

public enum IntervalType {

    WEEK(7),

    MONTH(30),

    DAY(1);

    private int daysLeft;

    IntervalType(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getDaysLeft() {
        return daysLeft;
    }
}

package org.maximser.cardtype;
public enum TravelPassType {

    FOUR(4),
    TEN(10),
    TWENTY(20);
    private int passesLeft;

    TravelPassType(int passesLeft) {
        this.passesLeft = passesLeft;
    }

    public int getPassesLeft() {
        return passesLeft;
    }
}

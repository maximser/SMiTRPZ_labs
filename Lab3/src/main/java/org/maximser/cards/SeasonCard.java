package org.maximser.cards;

import org.maximser.cardtype.OwnerType;
import org.maximser.cardtype.TravelPassType;
import java.util.UUID;

public class SeasonCard extends Card {

    private int travelLeft;
    private TravelPassType travelPassType;

    public SeasonCard(UUID uniqueId, OwnerType ownerType, TravelPassType travelPassType) {
        super(uniqueId, ownerType);
        this.travelPassType = travelPassType;
        this.travelLeft = travelPassType.getPassesLeft();
    }

    public int getTravelLeft() {
        return travelLeft;
    }

    public TravelPassType getTravelPassType() {
        return travelPassType;
    }

    public boolean verify() {
        boolean isVerified = false;
        if (this.travelLeft > 0) {
            if (this.getOwnerType() == OwnerType.HALF_PRICE){
                System.out.println("Need to be checked");
            }
            this.travelLeft--;
            isVerified = true;
        }
        if (!isVerified) block();
        return isVerified;
    }

    @Override
    public String toString() {
        return "Card type: season card\n" +
                "Travels left: " + this.travelLeft + "\n";
    }
}


package org.maximser.cards;

import org.maximser.cardtype.OwnerType;
import java.util.UUID;

public abstract class Card {

    private UUID uniqueId;
    private OwnerType ownerType;
    private boolean isBlocked;

    public Card(UUID uniqueID, OwnerType ownerType) {
        this.uniqueId = uniqueID;
        this.ownerType = ownerType;
        isBlocked = false;

    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public OwnerType getOwnerType() {
        return ownerType;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void block() {
        isBlocked = true;
    }

    public abstract boolean verify();

    public abstract String toString();


}

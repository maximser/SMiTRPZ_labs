package org.maximser.control;

import java.util.Date;
import java.util.UUID;

public class Pass {
    private Date passDate;
    private boolean passed;
    private int turnstileSystemId;
    private UUID cardId;
    private AccessSystem accessSystem;

    public Pass(boolean passed, int turnstileSystemId, UUID cardId, AccessSystem accessSystem) {
        this.passed = passed;
        this.turnstileSystemId = turnstileSystemId;
        this.cardId = cardId;
        this.accessSystem = accessSystem;
        passDate = new Date(new Date().getTime());
    }

    public Date getPassDate() {
        return passDate;
    }

    public boolean isPassed() {
        return passed;
    }

    public int getTurnstileSystemId() {
        return turnstileSystemId;
    }

    public UUID getCardId() {
        return cardId;
    }

    public AccessSystem getAccessSystem() {
        return accessSystem;
    }

    @Override
    public String toString() {
        return accessSystem.getCardInfo(cardId) +
                "Pass result: " + passed + "\n" +
                "TurnstileSystem id: " + turnstileSystemId + "\n";
    }


}

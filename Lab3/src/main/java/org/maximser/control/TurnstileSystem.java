package org.maximser.control;

import org.maximser.cards.*;

public class TurnstileSystem {

    private AccessSystem accessSystem;
    private int id;

    public TurnstileSystem(AccessSystem accessSystem, int id) {
        this.accessSystem = accessSystem;
        this.id = id;
    }

    public boolean acceptPass(CumulativeCard cumulativeCard) {
        boolean passes = cumulativeCard.verify();
        accessSystem.passes.add(new Pass(passes, id, cumulativeCard.getUniqueId(), accessSystem));
        return passes;
    }

    public boolean acceptPass(SeasonCard seasonCard) {
        boolean passes = seasonCard.verify();
        accessSystem.passes.add(new Pass(passes, id, seasonCard.getUniqueId(), accessSystem));
        return passes;
    }

    public boolean acceptPass(TemporaryCard temporaryCard) {
        boolean passes = temporaryCard.verify();
        accessSystem.passes.add(new Pass(passes, id, temporaryCard.getUniqueId(), accessSystem));
        return passes;
    }

}

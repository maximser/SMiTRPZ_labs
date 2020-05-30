package org.maximser.cardtype;

public enum OwnerType {

    STANDARD(1),
    HALF_PRICE(2),
    STUDENT(2),
    SCHOOL(2),
    PENSIONER(2);

    public final int value;

    private OwnerType(int value) {
        this.value = value;
    }
}

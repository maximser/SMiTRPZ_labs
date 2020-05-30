package org.maximser.lab2;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testIsEqualsJson() {
        File file = new File("person.json");
        Person personOrig = new Person("Jhon", "Smith", 1.9, 30, 85);
        personOrig.ToJson(file);
        Person personFromJson = Person.FromJson(file);
        assertTrue(personOrig.equals(personFromJson));

    }

    @Test
    public void testIsEquals() throws Exception {
        EqualsVerifier.forClass(Person.class)
                .usingGetClass()
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();

    }
}
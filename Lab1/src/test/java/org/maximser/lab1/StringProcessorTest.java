package org.maximser.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {

    @Test
    void findEqVowelsConsonants() {
        StringProcessor processor = new StringProcessor();
        String str = "hell is bad place. what do you think?";
        int expResult = 2;
        int actResult = processor.findEqVowelsConsonants(str).length;
        assertEquals(expResult, actResult);
    }

    @Test
    void getWords() {
        StringProcessor processor = new StringProcessor();
        String str = "Hello how are you? Привет как дела?";
        int expResult = 4;
        int actResult = processor.getWords(str).length;
        assertEquals(expResult, actResult);
    }

    @Test
    void checkEqVowelsConsonants() {
        StringProcessor processor = new StringProcessor();
        String word = "Hate";
        assertTrue(processor.checkEqVowelsConsonants(word));
    }
}
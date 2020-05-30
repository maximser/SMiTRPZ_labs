package org.maximser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestCoder {
    private static StringWriter string_writer = null;
    private static Coder coder = null;
    private static String current_string = null;

    @BeforeAll
    public static void setUp() {
        string_writer = new StringWriter(256);
        current_string = "b";
        coder = new Coder(string_writer);
    }

    @Test
    public void testWrite() throws NullPointerException, IOException {
        coder.write(current_string);
    }

    @Test
    public void testGetString() {
        assertNotNull(coder.getString());
    }

    @Test
    public void testCodeChar() {
        char actual = coder.codeChar('b');
        char expected = (char)((int)'b' + (int)'b');

        assertEquals(actual, expected);
    }

    @Test
    public void testCodeDecode(){
        String input = "Does it decode correctly?";
        coder.write(input);
        StringReader in = new StringReader(coder.getString());
        Decoder decoder = new Decoder(in);
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < string_writer.getBuffer().length()) {
            result.append((char)decoder.read());
            i++;
        };
        assertEquals(result.toString(), input);
    }

}

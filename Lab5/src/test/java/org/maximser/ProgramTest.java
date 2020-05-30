package org.maximser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    static Program p;
    static String inputText;
    static String inputFileName;

    @BeforeAll
    public static void setUp() throws IOException {
        p = new Program();
        inputText =
                "1234\n"+
                "123\n"+
                "12\n"+
                "1\n"+
                "12345";
        inputFileName = "input.txt";
        Files.writeString(Paths.get(inputFileName), inputText);
    }

    @Test
    void sortLines() {
        String expectText =
                "1\n"+
                "12\n"+
                "123\n"+
                "1234\n"+
                "12345";
        assertEquals(expectText, p.sortLines(inputText));
    }

    @Test
    void process() {
        Assertions.assertDoesNotThrow(()->{
            String outputFileName = "output.txt";
            p.process(inputFileName,outputFileName);
        });
    }
}

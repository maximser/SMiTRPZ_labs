package org.maximser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

public class Program {

    public void process(String inputFileName, String outputFileName) throws IOException {
        String lines = new String(Files.readAllBytes(Paths.get(inputFileName)));
        Files.writeString(Paths.get(outputFileName), sortLines(lines));
    }

    public String sortLines(String input){

        String[] lines = input.split("\n");
        Arrays.sort(lines, Comparator.comparingInt(String::length));
        return String.join( "\n", lines);
    }
}

package org.maximser;

import java.io.*;

public class Coder extends FilterWriter {

    protected Coder(Writer out) {
        super(out);
    }
    private String stringToCode = "";

    public void write(String inString){
        if (inString == null) {
            return;
        }
        if (inString == "") {
            return;
        }
        stringToCode = inString;
        int stringLength = stringToCode.length();
        int i = 0;
        char currentChar;
        String codedString = "";
        while (i < stringLength) {
            currentChar = stringToCode.charAt(i);
            codedString += codeChar(currentChar);
            i++;
        }
        stringToCode = codedString;
        try {
            super.write(stringToCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char codeChar(char inChar) {
        char tempChar;
        int intToChar = (int) inChar;

        tempChar =(char)(intToChar + intToChar);

        return tempChar;
    }

    public void close() {
        try {
            super.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getString() {
        return  stringToCode;
    }
}

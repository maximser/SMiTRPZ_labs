package org.maximser.lab1;

import java.util.*;

public class StringProcessor {

    public String[] findEqVowelsConsonants(String str) {
        String[] words = getWords(str);
        return  Arrays.stream(words)
                .filter( word -> checkEqVowelsConsonants(word))
                .toArray(String[]::new);
    }
    public String[] getWords(String str) {
        return Arrays.stream(str.replaceAll("[.,-_!?\'\"\n]", "").split(" "))
                .filter( word -> word.matches("[a-zA-Z]+"))
                .toArray(String[]::new);
    }

    public boolean checkEqVowelsConsonants(String str) {
        if (str.length() % 2 == 1) return false;
        return str.toLowerCase().length()/2 == str.replaceAll("[aouei]","").length();
    }

}

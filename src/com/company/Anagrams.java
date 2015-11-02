package com.company;
/**
 * Access Code 2.1
 * Ray Acevedo
 * Anagrams.java
 */
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {

    }

    private static boolean isAnagrams(String stringone, String stringtwo) {

        Map<Character, Integer> characterCounter =
                new HashMap<>(Math.max(stringone.length(), stringtwo.length()));

        for(char c: stringone.toCharArray()) {
            if(!Character.isAlphabetic(c)) continue;

            c = Character.toLowerCase(c);

            Integer count = characterCounter.get(c);
            if(count == null) {
                characterCounter.put(c, 1);
            }
            else {
                characterCounter.put(c, count + 1);
            }
        }

        for(char c: stringtwo.toCharArray()) {
            if(!Character.isAlphabetic(c)) continue;

            c = Character.toLowerCase(c);

            Integer count = characterCounter.get(c);
            if(count == null) {
                return false;
            }
            else if(count == 1) {
                characterCounter.remove(c);
            }
            else {
                characterCounter.put(c, count - 1);
            }
        }

        return characterCounter.isEmpty();
    }
}

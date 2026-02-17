package Algorithms;

import java.util.Arrays;

public class Anagram {


    //Java 18
    public static boolean isAnagram18(String a,String b) {
        if(a.length() != b.length()) {
            return false;
        }


        int[] achars = a.toLowerCase().chars().sorted().toArray();
        int[] bchars = b.toLowerCase().chars().sorted().toArray();

        for (int i = 0; i < achars.length; i++) {
            if(achars[i] != bchars[i]) {
             return false;
            }
        }

        return true;
    }

    public static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        char[] achars = b.toLowerCase().toCharArray();
        char[] bchars = b.toLowerCase().toCharArray();

        Arrays.sort(achars);
        Arrays.sort(bchars);

        return Arrays.equals(achars,bchars);
    }
}

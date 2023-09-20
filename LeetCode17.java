package Recursion;
import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    public static void main(String[] args) {
        List<String> list =  letterCombinations("23");
        for(String s:list){
            System.out.println(s);
        }
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();   //If input array is empty
        }
        return padComb("", digits);
    }

    public static List<String> padComb(String p, String up) {
        List<String> list = new ArrayList<>();

        if (up.isEmpty()) {
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';

        if (digit == 7) {
            // Special case for digit 7 (p, q, r, s)
            for (char ch : "pqrs".toCharArray()) {
                list.addAll(padComb(p + ch, up.substring(1)));
            }
        } else if (digit == 8) {
            // Special case for digit 8 (t, u, v)
            for (char ch : "tuv".toCharArray()) {
                list.addAll(padComb(p + ch, up.substring(1)));
            }
        } else if (digit == 9) {
            // Special case for digit 9 (w, x, y, z)
            for (char ch : "wxyz".toCharArray()) {
                list.addAll(padComb(p + ch, up.substring(1)));
            }
        } else {
            // Regular cases for digits 2-6
            for (int i = (digit - 2) * 3; i < (digit - 1) * 3 ; i++) {
                char ch = (char) ('a' + i);
                list.addAll(padComb(p + ch, up.substring(1)));
            }
        }

        return list;
    }
}

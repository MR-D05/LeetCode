package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    List<String> returnValue = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        List<String> stringList = new ArrayList<>();
        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            stringList.add(hashMap.get(digits.charAt(i)));
        }
        backtrack(stringList, new StringBuilder(), 0, stringList.size());
        return returnValue;
    }

    public void backtrack(List<String> stringList, StringBuilder current, int position, int size) {
        if (current.length() == size) {
            returnValue.add(current.toString());
            return;
        }
        if (position < stringList.size()) {
            for (int i = 0; i < stringList.get(position).length(); i++) {
                StringBuilder newString = new StringBuilder(current);
                newString.append(stringList.get(position).charAt(i));
                backtrack(stringList, newString, position + 1, size);
            }
        }
    }

    public static void main(String[] args) {

        /*
        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

        A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

        Example:

        Input: "23"
        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

        Note:

        Although the above answer is in lexicographical order, your answer could be in any order you want.
         */

        /*
        Plan:

        1. We will need a HashMap containing all numbers mapped to their letters.
        2. Create an ArrayList of strings achieved by looping over input and getting each string from map.
        3. We have a helper function that will recur.
        4. This function has as inputs a String, a List<String>, a position variable, and a size variable that is the size of one of the strings in the list.
        5. Our base case is if the string is == to size, we add it to the return list and return.
         */

        /*
        Problems:

        1. In our backtracking function, we added to the "current" StringBuilder first then made a temp StringBuilder based on it, when we needed to do that the
           other way around.
        2. We did not consider the edge case of digit of length 0.
        3. We did not consider that as we increment position by one, that our for loop, which uses the position variable would index out of bounds.
         */

        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        String digits = "23";
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(digits));
    }
}

/*
    public static List<String> letterCombinations(String digits) {
        List<String> returnList = new ArrayList<>();

        HashMap<String, String> phone = new HashMap<>();

        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");

        if (digits.length() != 0) {
            backtrack(returnList, phone, "", digits);
        }
        return returnList;
    }

    public static void backtrack(List<String> returnList, HashMap<String, String> phone, String combination, String digits) {

        if (digits.length() == 0) {
            returnList.add(combination);
        } else {

            String digit = digits.substring(0, 1);
            String letters = phone.get(digit);

            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i+1);
                backtrack(returnList, phone, combination + letter, digits.substring(1));
            }
        }
    }
 */


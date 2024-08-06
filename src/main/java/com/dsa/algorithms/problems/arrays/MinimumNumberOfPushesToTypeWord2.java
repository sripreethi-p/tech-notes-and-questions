package com.dsa.algorithms.problems.arrays;

import java.util.*;

public class MinimumNumberOfPushesToTypeWord2 {

    /*
    You are given a string word containing lowercase English letters.
    Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them.
    For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .
    It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters,
    but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.

    Return the minimum number of pushes needed to type word after remapping the keys. Note that 1, *, #, and 0 do not map to any letters.

    Example 1: "abcde" ==> 5
    Example 2: "xyzxyzxyzxyz"  ==> 12
    Example 3: "aabbccddeeffgghhiiiiii"  ==> 24
     */



    public int minimumPushes(String word) {

        Map<Character, Integer> letterToNumberOfLettersMap = new HashMap<>();


        // this is taking nlogn ----> can be replaced with list of frequencies for 26 alphabet (n)
        for(int i =0; i<word.length(); i++) {
            Character character = word.charAt(i);
            letterToNumberOfLettersMap.put(character, letterToNumberOfLettersMap.getOrDefault(character, 0) + 1);

        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(letterToNumberOfLettersMap.entrySet().stream().toList());

        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int counter = 0;
        for (int i=0; i<entryList.size(); i++) {
            counter += entryList.get(i).getValue()*(((i)/8)+1);
        }

        return counter;

    }


    public int minimumPushesBetter(String word) {
        int[] arr = new int[26];
        for(int i=0;i<word.length();i++){
            arr[word.charAt(i) - 'a']++;
        }
        Arrays.sort(arr);
        int i=25;
        int count = 0;
        int start = 1;
        int ans =0;
        while( i >= 0 && arr[i] != 0){
            ans+=(start * arr[i]);
            count++;
            if(count == 8){
                start++;
                count = 0;
            }
            i--;
        }
        return ans;
    }
}

package top100;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationProblem {

    public static List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return Collections.EMPTY_LIST;

        Map<Character, List<String>> numberCharMap = frameMap();

        if(digits.trim().length()==1) return numberCharMap.get(digits.charAt(0));

        List<String> result = new ArrayList<>();
        List<List<String>> allString= new ArrayList<>();
        for(char c: digits.toCharArray()){
            allString.add(numberCharMap.get(c));
        }

        if(allString.size()==2){
            for(int i=0;i<allString.get(0).size();i++)
                for(int j=0;j<allString.get(1).size();j++)
                    result.add(allString.get(0).get(i) + allString.get(1).get(j));

        }else if(allString.size()==3){
            for(int i=0;i<allString.get(0).size();i++)
                for(int j=0;j<allString.get(1).size();j++)
                    for(int k=0;k<allString.get(2).size();k++)
                        result.add(allString.get(0).get(i) + allString.get(1).get(j) + allString.get(2).get(k));
        }else{
            for(int i=0;i<allString.get(0).size();i++)
                for(int j=0;j<allString.get(1).size();j++)
                    for(int k=0;k<allString.get(2).size();k++)
                        for(int l=0;l<allString.get(3).size();l++)
                            result.add(allString.get(0).get(i) + allString.get(1).get(j) + allString.get(2).get(k)+allString.get(3).get(l));
        }

        return result;

    }

    private static Map<Character, List<String>> frameMap(){
        Map<Character,List<String>> numberCharMap = new HashMap<>();
        numberCharMap.put('2', Arrays.asList("a","b","c"));
        numberCharMap.put('3', Arrays.asList("d","e","f"));
        numberCharMap.put('4', Arrays.asList("g","h","i"));
        numberCharMap.put('5', Arrays.asList("j","k","l"));
        numberCharMap.put('6', Arrays.asList("m","n","o"));
        numberCharMap.put('7', Arrays.asList("p","q","r","s"));
        numberCharMap.put('8', Arrays.asList("t","u","v"));
        numberCharMap.put('9', Arrays.asList("w","x","y","z"));
        return numberCharMap;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}

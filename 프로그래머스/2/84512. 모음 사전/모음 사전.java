import java.util.*;
class Solution {
    private List<String> dictionary;
    private String[] vowels = {"A", "E", "O", "I", "U"};
    public int solution(String word) {
        dictionary = new ArrayList<>();
        generate("");
        
        Collections.sort(dictionary);
        
        int answer = 0;
        return dictionary.indexOf(word) + 1;
    }
    
    private void generate(String current){
        if(!current.isEmpty()){
            dictionary.add(current);
        }
        
        if(current.length() < 5){
            for(String vowel: vowels){
                generate(current + vowel);
            }
        }
    }
}
import java.util.*;
class Solution {
    private Set<Integer> set;
    private boolean[] v;
    public int solution(String numbers) {
        set = new HashSet<Integer>();
        v = new boolean[numbers.length()];
        
        bt(numbers, "");
        
        int answer = 0;
        for(int num: set){
            if(isPrime(num)) answer++;
        }
        
        
        
        return answer;
    }
    
    private void bt(String numbers, String current){
        if(!current.isEmpty()){
            set.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i<numbers.length(); i++){
            if(!v[i]){
                v[i] = true;
                bt(numbers, current + numbers.substring(i, i+1));
                v[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num){
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        
        for(int i = 3; i*i<=num; i+=2){
            if(num % i == 0) return false;
        }
        return true;
    }
    
}
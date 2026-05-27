import java.util.*;
class Solution {
    public int solution(int n, int k) {
        String num = change(n, k);
        
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for(int i = 0; i<num.length(); i++){
            if(num.charAt(i) == '0'){
                if(sb.length() != 0){
                    int target = Integer.parseInt(sb.toString());
                    if(isPrime(target)){
                        answer++;
                    }
                    
                    sb.setLength(0);
                }
            }else{
                sb.append(num.charAt(i));
            }
        }
        
        if(sb.length() != 0){
            long target = Long.parseLong(sb.toString());
            if(isPrime(target)){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    static String change(int n, int k){
        if(n == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
    
    static boolean isPrime(long n){
        if(n < 2) return false;
        for(long i = 2; i*i <= n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    
}
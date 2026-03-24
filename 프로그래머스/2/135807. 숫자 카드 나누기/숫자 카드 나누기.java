import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = Math.max(find(arrayA, arrayB), find(arrayB, arrayA));
        return answer;
    }
    
    static int find(int[] arrayA, int[] arrayB){
        int num = 0;
        
        int min = arrayA[0];
        
        for(int i = 2; i<=min; i++){
            if(min % i == 0){
                boolean all = true;
                for(int j = 1; j<arrayA.length; j++){
                    if(arrayA[j] % i != 0){
                        all = false;
                        break;
                    }
                }
                if(all) {
                    boolean op = true;
                    for(int n: arrayB){
                        if(n % i == 0){
                            op = false;
                            break;
                        }
                    }
                    if(op) num = i;
                }
            }
        }
        
        
        
        return num;
    }
    
}
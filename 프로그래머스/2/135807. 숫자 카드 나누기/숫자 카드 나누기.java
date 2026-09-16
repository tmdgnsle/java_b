import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for(int i = 1; i<arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        int answerA = 0;
        int answerB = 0;
        if(canDivide(gcdA, arrayB)) answerA = gcdA;
        if(canDivide(gcdB, arrayA)) answerB = gcdB;
        
        
        
        return Math.max(answerA, answerB);
    }
    
    static int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    static boolean canDivide(int num, int[] arr){
        for(int a: arr){
            if(a % num == 0) return false;
        }
        return true;
    }
}
import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0;
        int bIdx = 0;
        
        while(aIdx < A.length && bIdx < B.length){
            if(B[bIdx] > A[aIdx]){
                answer++;
                aIdx++;
                bIdx++;
            } else {
                bIdx++;
            }
        }
        
        return answer;
    }
}
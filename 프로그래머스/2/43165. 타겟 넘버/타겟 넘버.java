import java.util.*;

class Solution {
    static ArrayList<Integer> arr;
    static int max;
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        max = numbers.length;
        
        dfs(0, 0, target, numbers);
        
        // System.out.println(max);
        
        
        return answer;
    }
    
    static void dfs(int idx, int current, int target, int[] numbers){
        if(idx == max){
            if(current == target) answer++;
            return;
        }
        
        dfs(idx+1, current + numbers[idx], target, numbers);
        dfs(idx+1, current - numbers[idx], target, numbers);
    }
}
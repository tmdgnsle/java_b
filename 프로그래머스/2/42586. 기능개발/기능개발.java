import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> arr = new ArrayList<>();
        int[] days = new int[progresses.length];
        for(int i = 0; i<progresses.length; i++){
            int remainWork = 100 - progresses[i];
            days[i] = (int) Math.ceil((double) remainWork / speeds[i]);
        }
        
        int i = 0;
        while(i < days.length){
            int currentDay = days[i];
            int count = 1;
            
            while(i + count < days.length && days[i + count] <= currentDay){
                count++;
            }
            arr.add(count);
            i += count;
        }
        
        int[] answer = new int[arr.size()];
        
        for(int j = 0; j<arr.size(); j++){
            answer[j] = arr.get(j);
        }
        
        return answer;
    }
}
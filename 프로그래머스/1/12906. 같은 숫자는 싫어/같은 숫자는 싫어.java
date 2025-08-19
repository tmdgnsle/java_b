import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<Integer>();
        
        
        int before = -1;
        for(int i = 0; i<arr.length; i++){
            int current = arr[i];
            if(before == current){
                continue;
            }
            before = current;
            list.add(current);
        }
        
        
        
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        

        return answer;
    }
}
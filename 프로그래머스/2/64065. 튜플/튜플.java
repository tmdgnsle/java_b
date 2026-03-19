import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        
        String[] arr = s.split("\\},\\{"); // 중괄호 escape 처리 \\
        
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        
        List<Integer> results = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(String str: arr){
            String[] nums = str.split(",");
            for(String num: nums){
                int n = Integer.parseInt(num);
                if(!set.contains(n)){
                    results.add(n);
                    set.add(n);
                }
            }
        }
        
        int[] answer = new int[results.size()];
        
        for(int i = 0; i<results.size(); i++){
            answer[i] = results.get(i);
        }
        
        
        return answer;
    }
}
import java.util.*;

class Solution {
    static HashMap<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int len: course){
            map = new HashMap<>();
            
            for(String order: orders){
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                comb(arr, 0, 0, len, new StringBuilder());
            }
            
            int max = 0;
            for(int count: map.values()){
                if(count >= 2){
                    max = Math.max(max, count);
                }
            }
            
            for(String key: map.keySet()){
                if(map.get(key) == max && max >= 2){
                    answer.add(key);
                }
            }
            
        }
        
        Collections.sort(answer);
        
        
        
        return answer.toArray(new String[0]);
    }
    
    
    static void comb(char[] arr, int idx, int depth, int target, StringBuilder sb){
        if(depth == target){
            String menu = sb.toString();
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            return;
        }
        
        for(int i = idx; i<arr.length; i++){
            sb.append(arr[i]);
            comb(arr, i+1, depth+1, target, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
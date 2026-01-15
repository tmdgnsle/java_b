import java.util.*;
class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 1; i<=26; i++){
            map.put(""+ (char)('A'+i-1), i);
        }
        
        int idx = 27;
        for(int i = 0; i<msg.length(); i++){
            String cur = msg.substring(i, i+1);
            String before = "";
            int next = 2;
            while(true){
                if(map.containsKey(cur)){
                    if(i+next > msg.length()){
                        arr.add(map.get(cur));
                        i += cur.length() - 1;
                        break;
                    }else {
                        before = cur;
                        cur = msg.substring(i, i+next); 
                        next++;
                    }
                }else {
                    arr.add(map.get(before));
                    map.put(cur, idx++);
                    i += before.length() - 1;
                    break;
                }
            }
            
        }
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
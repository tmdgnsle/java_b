import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int length = photo.length;
        
        int[] answer = new int[length];
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        int idx = 0;
        for(int i = 0; i<photo.length; i++){
            for(int j = 0; j<photo[i].length; j++){
                String person = photo[i][j];
                int score = map.getOrDefault(person, 0);
                answer[i] += score;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int n = scores.length;
        int wanhoSum = scores[0][0] + scores[0][1];
        
        
        Integer[] indices = new Integer[n];
        for(int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, (i, j) -> {
            if(scores[i][0] == scores[j][0]) {
                return Integer.compare(scores[i][1], scores[j][1]);
            }
            return Integer.compare(scores[j][0], scores[i][0]);
        });
        
        
        List<Integer> validSums = new ArrayList<>();
        int maxB = 0; 
        
        for(int idx : indices) {
            
            if(scores[idx][1] >= maxB) {
                maxB = scores[idx][1];
                validSums.add(scores[idx][0] + scores[idx][1]);
            } else if(idx == 0) {
            
                return -1;
            }
        }
        
        
        Collections.sort(validSums, Collections.reverseOrder());
        
        
        for(int i = 0; i < validSums.size(); i++) {
            if(validSums.get(i) == wanhoSum) {
                return i + 1;
            }
        }
        
        return -1;
    }
}
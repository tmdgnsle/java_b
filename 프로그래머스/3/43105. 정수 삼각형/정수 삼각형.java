import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        
        int[][] d = new int[triangle.length][triangle.length];
        int answer = 0;
        d[0][0] = triangle[0][0];
        for(int i = 1; i<triangle.length; i++){
            for(int j = 0; j<triangle[i].length; j++){
                int left = 0;
                int right = 0;
                if(j != 0){
                    left = d[i-1][j-1] + triangle[i][j];
                }
                right = d[i-1][j] + triangle[i][j];
                d[i][j] = Math.max(left, right);
                answer = Math.max(d[i][j], answer);
            }
        }
        
        
        return answer;
    }
}
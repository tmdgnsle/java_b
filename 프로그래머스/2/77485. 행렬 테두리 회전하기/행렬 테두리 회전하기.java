import java.util.*;
class Solution {
    static int[][] nums;
    public int[] solution(int rows, int columns, int[][] queries) {
        nums = new int[rows+1][columns+1];
        int num = 1;
        for(int i = 1; i<=rows; i++){
            for(int j = 1; j<=columns; j++){
                nums[i][j] = num++;
            }
        }
        int[] answer = new int[queries.length];
        int idx = 0;
        
        for(int i = 0; i<queries.length; i++){
            answer[idx++] = simulate(queries[i], rows, columns);
        }
        
        return answer;
    }
    
    static int simulate(int[] query, int rows, int columns){
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];
        
        int[][] newNums  = new int[rows+1][columns+1];
        for(int i = 1; i<= rows; i++){
            for(int j = 1; j<=columns; j++){
                newNums[i][j] = nums[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = x1; i<=x2; i++){
            for(int j = y1; j<=y2; j++){
                if(i != x1 && i != x2 && j != y1 && j != y2) continue;
                
                if(nums[i][j] < min) min = nums[i][j];
                
                if(i == x1){
                    if(j == y2){
                        newNums[i+1][j] = nums[i][j];
                    }else{
                        newNums[i][j+1] = nums[i][j];
                    }
                }
                if(i == x2){
                    if(j == y1){
                        newNums[i-1][j] = nums[i][j];
                    }else{
                        newNums[i][j-1] = nums[i][j];
                    }
                }
                if(j == y1){
                    if(i == x1){
                        newNums[i][j+1] = nums[i][j];
                    }else{
                        newNums[i-1][j] = nums[i][j];
                    }
                }
                if(j == y2){
                    if(i == x2){
                        newNums[i][j-1] = nums[i][j];
                    }else{
                        newNums[i+1][j] = nums[i][j];
                    }
                }

                
            }
        }
        
        nums = newNums;
        return min;
    }
}
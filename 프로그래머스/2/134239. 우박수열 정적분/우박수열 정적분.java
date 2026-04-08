import java.util.*;

class Solution {
    static ArrayList<Integer> graph;
    static int n = 0;
    public double[] solution(int k, int[][] ranges) {
        graph = new ArrayList<>();
        graph.add(k);
        
        while(true){
            if(k % 2 == 0){
                k /= 2;
            }else {
                k = 3 * k + 1;
            }
            
            graph.add(k);
            n++;
            if(k == 1) break;
            
        }
        
        
        
        double[] answer = new double[ranges.length];
        
        for(int i = 0; i<ranges.length; i++){
            int start = ranges[i][0];
            int end = n + ranges[i][1];
            if(start > end){
                answer[i] = -1.0;
                continue;
            }
            answer[i] = calculate(start, end);
        }
        
        return answer;
    }
    
    
    static double calculate(int start, int end){
        double total = 0;
        for(int i = start; i<end; i++){
            double left = graph.get(i);
            double right = graph.get(i+1);
            double min = Math.min(left, right);
            total += Math.abs(left - right) / 2 + min;
        }
        
        return total;
    }
}
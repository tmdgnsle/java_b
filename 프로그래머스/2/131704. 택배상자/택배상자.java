import java.util.*;
class Solution {
    static Stack<Integer> stack;
    public int solution(int[] order) {
        int size = order.length;
        stack = new Stack<Integer>();
        int answer = 0;
        int idx = 0;
        int num = 1;
        while(true){
            if(idx >= size) break;
            
            if(order[idx] == num){
                answer++;
                idx++;
                num++;
            }else {
                if(order[idx] < num){
                    if(!stack.isEmpty()){
                    if(order[idx] == stack.peek()){
                        stack.pop();
                        answer++;
                        idx++;
                    } else break;
                } else break;    
                }else {
                    stack.push(num++);
                }
                
            }
            
        }
        return answer;
    }
}
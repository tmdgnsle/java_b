import java.util.*;

class Node{
    int location;
    int priority;
    
    Node(int location, int priority){
        this.location = location;
        this.priority = priority;
    }
    
    // @Override
    // public int compareTo(Node o){
    //     return -(this.priority - o.priority);
    // }
}

class Solution {
    public int solution(int[] priorities, int location) {
        
        Deque<Node> queue = new ArrayDeque<>();
        
        for(int i = 0; i<priorities.length; i++){
            queue.add(new Node(i, priorities[i]));
        }
        
        Arrays.sort(priorities);
        
        int idx = priorities.length-1;
        
        int answer = 0;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.priority != priorities[idx]){
                queue.add(node);
                continue;
            }
            
            answer++;
            idx--;
            
            if(node.location == location){
                break;
            }
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    
    static class Truck{
        int weight;
        int time;
        
        Truck(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int truck_length = truck_weights.length;
        int idx = 1;
        int time = 1;
        int total_weight = truck_weights[0];
        Queue<Truck> q = new LinkedList<>();
        q.add(new Truck(truck_weights[0], 1));
        while (!q.isEmpty()) {
            time++; // 1초 경과

            // 1) 다리를 다 지난 트럭 내리기
            if (!q.isEmpty() && time - q.peek().time == bridge_length) {
                total_weight -= q.poll().weight;
            }

            // 2) 다음 트럭을 올릴 수 있으면 올리기
            if (idx < truck_length && total_weight + truck_weights[idx] <= weight) {
                total_weight += truck_weights[idx];
                q.add(new Truck(truck_weights[idx], time));
                idx++;
            }
        }
        
        
    
        return time;
    }
}
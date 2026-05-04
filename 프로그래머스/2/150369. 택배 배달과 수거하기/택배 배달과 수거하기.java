class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int dIdx = n - 1;
        int pIdx = n - 1;
        
        while(dIdx >= 0 || pIdx >= 0){
            
            while(dIdx >= 0 && deliveries[dIdx] == 0){
                dIdx--;
            }
            while(pIdx >= 0 && pickups[pIdx] == 0){
                pIdx--;
            }
            
            if(dIdx < 0 && pIdx < 0) break;
            
            int far = Math.max(dIdx, pIdx);
            answer += (far + 1) * 2L;
            
            int box = cap;
            while(dIdx >= 0 && box > 0){
                if(deliveries[dIdx] <= box){
                    box -= deliveries[dIdx];
                    deliveries[dIdx] = 0;
                    dIdx--;
                }else {
                    deliveries[dIdx] -= box;
                    box = 0;
                }
            }
            
            box = cap;
            while(pIdx >= 0 && box > 0){
                if(pickups[pIdx] <= box){
                    box -= pickups[pIdx];
                    pickups[pIdx] = 0;
                    pIdx--;
                }else {
                    pickups[pIdx] -= box;
                    box = 0;
                }
            }
            
            
        }
        return answer;
    }
}
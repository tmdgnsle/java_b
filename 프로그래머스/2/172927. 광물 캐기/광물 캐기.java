import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(totalPicks * 5, minerals.length);
        
        List<int[]> groups = new ArrayList<>();
        
        for(int i = 0; i<maxMinerals; i+=5){
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j = i; j<i+5 && j<maxMinerals; j++){
                if(minerals[j].equals("diamond")) diamond++;
                else if(minerals[j].equals("iron")) iron++;
                else stone++;
            }
            
            groups.add(new int[] {diamond, iron, stone});
        }
        
        groups.sort((a, b) -> {
            if(b[0] == a[0]) {
                if(b[1] == a[1]){
                    return b[2] - a[2];
                }
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });
        
        int answer = 0;
        
        
        for(int[] g: groups){
            int d = g[0];
            int i = g[1];
            int s = g[2];
            
            if(picks[0] > 0){
                picks[0]--;
                answer += d + i + s;
            }else if(picks[1] > 0){
                answer += d * 5 + i + s;
                picks[1]--;
            }else if(picks[2] > 0){
                answer += d * 25 + i * 5 + s;
                picks[2]--;
            }
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    private ArrayList<int[]> arr;
    private boolean[] v;
    private int count;
    public int solution(int k, int[][] dungeons) {
        arr = new ArrayList<>();
        v = new boolean[dungeons.length];
        count = Integer.MIN_VALUE;
        
        bt(k, dungeons);
        
        return count;
    }
    
    
    private void bt(int k, int[][] dungeons){
        if(count == dungeons.length) return;
        if(!arr.isEmpty()){
            if(canDungeon(k)){
                count = Math.max(count, arr.size());
            }
        }
        
        for(int i = 0; i<dungeons.length; i++){
            if(!v[i]){
                v[i] = true;
                arr.add(dungeons[i]);
                bt(k, dungeons);
                v[i] = false;
                arr.remove(arr.size()-1);
            }
        }
    }
    
    private boolean canDungeon(int k){
        for(int[] dungeon: arr){
            if(k < dungeon[0]) return false;
            k -= dungeon[1];
        }
        return true;
    }
}
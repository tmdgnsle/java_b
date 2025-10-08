import java.util.*;

class Solution {
    static String[][] classes;
    static ArrayList<int[]> arr;
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i<5; i++){
            classes = new String[5][5];
            arr = new ArrayList<>();
            for(int j = 0; j<5; j++){
                for(int k = 0; k<5; k++){
                    classes[j][k] = places[i][j].substring(k, k+1);
                }
            }
            answer[i] = find();
        }
        
        return answer;
    }
    
    
    static int find(){
        int count = 0;
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(classes[i][j].equals("P")){
                    count++;
                    arr.add(new int[] {i, j});
                }
            }
        }
        
        if(count == 0) return 1;
        
        for(int i = 0; i<count-1; i++){
            int[] first = arr.get(i);
            for(int j = i+1; j<count; j++){
                int[] second = arr.get(j);
                if(calculateDistance(first, second) <= 2){
                    if(!check(first, second)){
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    
    static int calculateDistance(int[] first, int[] second){
        int fx = first[0];
        int fy = first[1];
        int sx = second[0];
        int sy = second[1];
        
        return Math.abs(fx - sx) + Math.abs(fy - sy);
    }
    
    static boolean check(int[] first, int[] second){
        int startX = Math.min(first[0], second[0]);
        int startY = Math.min(first[1], second[1]);
        int endX = Math.max(first[0], second[0]);
        int endY = Math.max(first[1], second[1]);
        
        if(startX == endX){
            if(endY - startY == 1) return false;
            if(classes[startX][startY+1].equals("O")) return false;
        }
        
        if(startY == endY){
            if(endX - startX == 1) return false;
            if(classes[startX+1][startY].equals("O")) return false;
        }
        
        for(int i = startX; i<=endX; i++){
            for(int j = startY; j<=endY; j++){
                if(classes[i][j].equals("O")) return false;
            }
        }
        
        return true;
        
        
    }
}
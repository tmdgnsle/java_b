import java.util.*;

class Solution {
    static int[][] numMap;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int w, h;
    static int foods;
    static ArrayList<Integer> arr;
    
    public int[] solution(String[] maps) {
        h = maps.length;
        w = maps[0].length();
        numMap = new int[h][w];
        v = new boolean[h][w];
        for(int i = 0; i<h; i++){
            for(int j = 0; j<w; j++){
                if(maps[i].charAt(j) == 'X'){
                    numMap[i][j] = 0;
                }else {
                    numMap[i][j] = (int) maps[i].charAt(j) - 48;
                }
            }
        }
        arr = new ArrayList<>();
        
        for(int i = 0; i<h; i++){
            for(int j = 0; j<w; j++){
                foods = 0;
                if(v[i][j] || numMap[i][j] == 0) continue;
                bfs(i, j);
                arr.add(foods);
            }
        }
        
        int[] answer;
        if(arr.size() == 0){
            answer = new int[] {-1};
        }else {
            answer = new int[arr.size()];
            for(int i = 0; i<arr.size(); i++){
                answer[i] = arr.get(i);
            }
            Arrays.sort(answer);    
        }
        
        
        
        return answer;
    }
    
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {x, y, numMap[x][y]});
        v[x][y] = true;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            int cf = current[2];
            foods += cf;
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(isValid(nx, ny)){
                    v[nx][ny] = true;
                    q.add(new int[] {nx, ny, numMap[nx][ny]});
                }
            }
        }
    }
    
    static boolean isValid(int x, int y){
        return x >= 0 && x < h && y >= 0 && y < w && !v[x][y] && numMap[x][y] != 0;
    }
}
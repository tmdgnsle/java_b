import java.util.*;

class Solution {
    static boolean[][] v;
    static int n;
    static int m;
    static int count;
    static int[] total;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] oilId;  // 석유 덩어리 ID 저장
    static Map<Integer, Integer> oilSize;  // 각 덩어리의 크기
    static int currentId;
    
    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        
        n = land.length;
        m = land[0].length;
        total = new int[m];
        
        // 석유 덩어리 ID와 크기 저장용
        oilId = new int[n][m];
        oilSize = new HashMap<>();
        currentId = 2;  // 0: 빈땅, 1: 석유, 2부터: 덩어리 ID
        
        // 1단계: 모든 석유 덩어리 찾기
        v = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!v[i][j] && land[i][j] == 1){
                    v[i][j] = true;
                    count = 0;
                    dfs(land, i, j);
                    oilSize.put(currentId, count);
                    currentId++;
                }
            }
        }
        
        
        for(int j = 0; j < m; j++){
            Set<Integer> foundIds = new HashSet<>();
            count = 0;
            
            
            for(int i = 0; i < n; i++){
                if(oilId[i][j] > 0){
                    foundIds.add(oilId[i][j]);
                }
            }
            
            
            for(int id : foundIds){
                count += oilSize.get(id);
            }
            
            total[j] = count;
        }
        
        
        for(int j = 0; j < m; j++){  
            answer = Math.max(answer, total[j]);
        }
        
        return answer;
    }
    
    static void dfs(int[][] land, int x, int y){
        count += 1;
        oilId[x][y] = currentId;  // 덩어리 ID 부여
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 경계 조건 수정: >= 0으로 변경
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && !v[nx][ny]){
                v[nx][ny] = true;
                dfs(land, nx, ny);
            }
        }
    }
}
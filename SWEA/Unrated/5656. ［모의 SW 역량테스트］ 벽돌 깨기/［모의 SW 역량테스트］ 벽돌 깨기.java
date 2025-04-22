import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
 
public class Solution {
 
    static class Point{
        int r,c,cnt; // 벽돌의 위치, 크기
        public Point(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N,W,H,min;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());// 구슬 던지는 횟수
            W = Integer.parseInt(st.nextToken());// 가로(열크기)
            H = Integer.parseInt(st.nextToken());// 세로(행크기)
            int[][] map = new int[H][W];
             
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            } // 2차원 map 입력
           //---------INPUT END--------------------
            min = Integer.MAX_VALUE;
            drop(0,map);
            System.out.println("#"+tc+" "+min);
        }
    }
 
    /**
     * 구슬 떨어뜨리기 (중복 순열의 형태)
     * @param cnt : 떨어뜨린 구슬의 수
     * @param map : 직전까지의 map
     * @return
     */
    private static boolean drop(int cnt,int[][] map) {
                                                                   
     // 구슬을 던지기 전에 현 상태로 남은 벽돌수 체크
        int result = getRemain(map);
     // 남은 벽돌 수가 0이면 모든 벽돌이 제거된 가장 최적의 상태이므로 최소값 0으로 갱신후 return true
       if(result == 0) {
          min = 0;
           //return;
            return true;
      }
        // 모든 구슬을 다 던졌다면 남은 벽돌수로 최소값 갱신 후 return false
        if(cnt == N) {
            if(min>result) min = result;
            return false;
        }
         
        int[][] newMap = new int[H][W]; 
        for (int c = 0; c < W; c++) { // 모든 열에 대해 시도
             
            // 해당 열에 떨어뜨릴 경우 제거되게 되는 맨 윗벽돌 찾기
            int r=0;
            while(r<H && map[r][c]==0) ++r;
            // 벽돌이 존재하지 않는다면(해당 열은 모두 빈칸) 다음 열로 건너뛰기
            if(r==H) continue;
             
            // 벽돌이 존재한다면 기존 상태에서 복사
                copy(map, newMap);
                // 벽돌 제거 + 함께 제거될 인접벽돌 연쇄 찾기
                boom(newMap,r,c);
                // 제거처리(벽돌 내리기)
                down(newMap);
                // 다음 구슬 던지러 가기 : 재귀 호출 ==> 재귀호출의 결과가 true이면 가장 최적해의 상황이므로 return true
                if(drop(cnt+1, newMap)) return true;
        }
       return false;
    }
     
 
    // 인접한 제거 벽돌 찾기 : Flood Fill(4방 BFS)
    private static void boom(int[][] map, int r, int c) {
        Queue<Point> queue = new ArrayDeque<Point>();
         
        if(map[r][c]>1) queue.offer(new Point(r, c, map[r][c]));
        map[r][c] = 0; // 방문 처리(벽돌 제거 표시)
         
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
             
            for (int d = 0; d < 4; d++) {
                int nr = cur.r;
                int nc = cur.c;
                for (int i = 1; i < cur.cnt; i++) {// cnt-1만큼 주변 벽돌 찾기
                    nr += dr[d];
                    nc += dc[d];
                    if(isRange(nr, nc) && map[nr][nc]>0) {
                        if(map[nr][nc]>1) queue.offer(new Point(nr, nc, map[nr][nc]));
                        map[nr][nc] = 0; // 방문 처리
                    }
                }
            }
        }
    }
 
    // 벽돌 내리기1 : 빈자리 위쪽 벽돌 찾아 내리기 
    // 벽돌 내리기2 : 매 열마다 맨 윗행부터  벽돌칸 모두 스택에 넣고 빈칸 만들기 
    private static void down(int[][] map) {
        // 매 열 기준으로 내리기
        for (int c = 0; c < W; c++) {
            int r = H-1, nr = -1;
            while(r>0) {
                if(map[r][c] == 0) { // 빈칸이면 내릴 벽돌 찾기
                    nr = r-1; // 바로 윗행부터 찾기
                     
                    while(nr>0 && map[nr][c] == 0) --nr; 
                     
                    map[r][c] = map[nr][c];
                    map[nr][c] = 0; // 빈칸 처리 
                }
                 
                if(nr == 0) break;
                --r;
            }
        }       
    }
 
     
    /**
     * 배열 복사용 메소드
     * @param map
     * @param newMap
     */
    private static void copy(int[][] map, int[][] newMap) {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                newMap[r][c] = map[r][c];
            }
        }
    }
    
         private static boolean isRange(int nr, int nc) {
    	 return nr>=0 && nr<H && nc>=0 && nc<W;
     }
    
   /**
    * 남은 벽돌의 수를 구하는 메소드
    * @param map
    * @return
    */
    private static int getRemain(int[][] map) {
        int cnt = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if(map[r][c] != 0) cnt++;
            }
        }
        return cnt;
    }
     
}
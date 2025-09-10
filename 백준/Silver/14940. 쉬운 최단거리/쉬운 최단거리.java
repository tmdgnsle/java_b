import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int startX, startY;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] distance;
    static boolean[][] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        distance = new int[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(distance[i], -1);
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 2){
                    startX = i;
                    startY = j;
                }
                if(num == 0){
                    distance[i][j] = 0;
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }


    }

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        distance[startX][startY] = 0;
        v[startX][startY] = true;


        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int cd = current[2];

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(isValid(nx, ny)){
                    v[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cd + 1});
                    distance[nx][ny] = cd + 1;
                }
            }


        }
    }

    static boolean isValid(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m && map[x][y] != 0 && !v[x][y];
    }

}
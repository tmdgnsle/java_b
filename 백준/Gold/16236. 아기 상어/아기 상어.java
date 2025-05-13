import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Position me;


    static class Position implements Comparable<Position> {
        int x;
        int y;
        int time;

        Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Position o) {
            if (this.time == o.time) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.time - o.time;

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    me = new Position(i, j, 0);
                }
            }
        }


        int result = simulate();

        System.out.println(result);

    }

    static int simulate() {

        int level = 2;
        int count = 0;

        Position p = me;
        map[p.x][p.y] = 0;
        while(true){
            PriorityQueue<Position> pq = bfs(p, level);

            int canEat = pq.size();
            if(canEat == 0){
                break;
            }

            p = pq.poll();
            map[p.x][p.y] = 0;

            count++;
            if(level == count){
                level++;
                count = 0;
            }
        }


        return p.time;
    }

    static PriorityQueue<Position> bfs(Position p, int level) {

        boolean[][] v = new boolean[N][N];
        v[p.x][p.y] = true;

        Queue<Position> queue = new LinkedList<>();
        queue.add(p);
        PriorityQueue<Position> pq = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            Position c = queue.poll();
            if (level > map[c.x][c.y] && map[c.x][c.y] != 0) {
                pq.add(c);
            }

            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || v[nx][ny]) continue;

                if (level >= map[nx][ny]) {
                    queue.add(new Position(nx, ny, c.time + 1));
                    v[nx][ny] = true;
                }

            }
        }

        return pq;


    }

}
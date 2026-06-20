import java.io.*;
import java.util.*;

public class Main {

    // 화산 정보
    static class Volcano {
        int x, y;        // 화산 위치
        int limit;       // 분출 기준 압력
        int pressure;    // 현재 압력

        Volcano(int x, int y, int limit) {
            this.x = x;
            this.y = y;
            this.limit = limit;
            this.pressure = 0; // 처음 압력은 0
        }
    }

    // 거북이 정보
    static class Turtle {
        int x, y;            // 현재 위치
        boolean alive;       // 살아있는지 여부
        boolean arrived;     // 도착했는지 여부

        Turtle(int x, int y) {
            this.x = x;
            this.y = y;
            this.alive = true;
            this.arrived = false;
        }
    }

    static int N, M, K;

    // map[i][j] == 1 이면 산호초라서 이동/열기 통과 불가
    static int[][] map;

    // turtleMap[i][j] == 0 이면 거북이 없음
    // turtleMap[i][j] == n 이면 n번 거북이가 있음
    // 실제 turtles 배열 인덱스는 n - 1
    static int[][] turtleMap;

    static Turtle[] turtles;
    static Volcano[] volcanos;

    // answer[i] = i번 거북이가 도착한 턴
    // 도착 못하면 -1
    static int[] answer;

    // 거북이 이동 우선순위: 우, 하, 좌, 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static final int CORAL = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 격자 크기
        // M: 거북이 수
        // K: 화산 수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        turtleMap = new int[N][N];

        // 격자 입력
        // 0: 빈칸
        // 1: 산호초
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        turtles = new Turtle[M];
        answer = new int[M];

        // 기본값은 도착 실패
        Arrays.fill(answer, -1);

        // 거북이 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            turtles[i] = new Turtle(x, y);

            // i번 거북이를 맵에는 i + 1로 표시
            // 0을 빈칸으로 쓰기 위해서
            turtleMap[x][y] = i + 1;
        }

        volcanos = new Volcano[K];

        // 화산 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            volcanos[i] = new Volcano(x, y, limit);
        }

        // 문제 조건상 최대 100턴 진행
        for (int turn = 1; turn <= 100; turn++) {

            // 1단계: 살아있는 거북이들이 번호 순서대로 한 칸씩 이동
            moveTurtles(turn);

            // 2단계: 모든 화산의 압력이 10 증가
            increasePressure();

            // 3단계: 압력이 기준 이상인 화산 분출
            // 이때 열기로 인해 다른 화산이 연쇄 분출할 수 있음
            explodeVolcanos();
        }

        StringBuilder sb = new StringBuilder();

        for (int a : answer) {
            sb.append(a).append('\n');
        }

        System.out.print(sb);
    }

    static void moveTurtles(int turn) {

        // 거북이는 번호가 작은 순서대로 움직임
        for (int i = 0; i < M; i++) {
            Turtle t = turtles[i];

            // 이미 죽었거나 도착한 거북이는 더 이상 이동하지 않음
            if (!t.alive || t.arrived) continue;

            // 현재 거북이가 이번 턴에 갈 다음 한 칸을 구함
            int[] next = getNextStep(i);

            // 목적지까지 갈 수 있는 경로가 없으면 가만히 있음
            if (next == null) continue;

            // 기존 위치에서 거북이 제거
            turtleMap[t.x][t.y] = 0;

            // 새 위치로 이동
            t.x = next[0];
            t.y = next[1];

            // 목적지에 도착했으면 정답 기록
            if (t.x == N - 1 && t.y == N - 1) {
                t.arrived = true;
                answer[i] = turn;

                // 도착한 거북이는 더 이상 맵에 남겨둘 필요 없음
            } else {
                // 아직 도착하지 않았으면 새 위치에 표시
                turtleMap[t.x][t.y] = i + 1;
            }
        }
    }

    static int[] getNextStep(int turtleIdx) {
        Turtle t = turtles[turtleIdx];

        int sx = t.x;
        int sy = t.y;

        boolean[][] visited = new boolean[N][N];

        // beforeX, beforeY는 BFS 경로 복원용 배열
        // beforeX[x][y], beforeY[x][y]는
        // x, y 칸에 오기 직전에 있었던 칸의 좌표
        int[][] beforeX = new int[N][N];
        int[][] beforeY = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(beforeX[i], -1);
            Arrays.fill(beforeY[i], -1);
        }

        Queue<int[]> q = new ArrayDeque<>();

        // BFS 시작점은 현재 거북이 위치
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            // 목적지에 도착한 경로를 찾은 경우
            if (x == N - 1 && y == N - 1) {

                // 목적지에서 거꾸로 따라가서
                // 시작점 바로 다음 칸을 찾는다
                int cx = x;
                int cy = y;

                while (true) {
                    int px = beforeX[cx][cy];
                    int py = beforeY[cx][cy];

                    // 이전 칸이 시작점이면
                    // 현재 cx, cy가 거북이가 실제로 이동해야 할 첫 번째 칸
                    if (px == sx && py == sy) {
                        return new int[]{cx, cy};
                    }

                    cx = px;
                    cy = py;
                }
            }

            // 우, 하, 좌, 상 순서로 탐색
            // BFS는 먼저 발견한 경로가 최단 경로
            // 같은 최단 거리라면 이 방향 순서가 우선순위를 결정함
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 격자 밖이면 이동 불가
                if (!inRange(nx, ny)) continue;

                // 이미 방문한 칸이면 패스
                if (visited[nx][ny]) continue;

                // 산호초는 이동 불가
                if (map[nx][ny] == CORAL) continue;

                // 다른 거북이가 있는 칸은 이동 불가
                if (turtleMap[nx][ny] != 0) continue;

                visited[nx][ny] = true;

                // nx, ny는 x, y에서 왔다고 기록
                beforeX[nx][ny] = x;
                beforeY[nx][ny] = y;

                q.add(new int[]{nx, ny});
            }
        }

        // 목적지까지 갈 수 있는 경로가 없는 경우
        return null;
    }

    static void increasePressure() {
        // 매 턴 모든 화산 압력 +10
        for (int i = 0; i < K; i++) {
            volcanos[i].pressure += 10;
        }
    }

    static void explodeVolcanos() {

        // heat[x][y]는 이번 턴에 x, y 칸에 쌓인 열기
        // 매 턴 새로 만들어지므로 턴이 끝나면 자동 초기화되는 효과
        int[][] heat = new int[N][N];

        // exploded[i] == true면 이번 턴에 i번 화산은 이미 분출함
        // 같은 턴에 같은 화산이 두 번 분출하면 안 됨
        boolean[] exploded = new boolean[K];

        boolean changed = true;

        // 연쇄 폭발 처리
        // 어떤 화산이 터지면 heat가 증가하고,
        // 그 heat 때문에 다른 화산이 또 터질 수 있음
        while (changed) {
            changed = false;

            for (int i = 0; i < K; i++) {
                if (exploded[i]) continue;

                Volcano v = volcanos[i];

                // 현재 압력 + 이번 턴에 받은 열기 >= 임계값이면 분출
                if (v.pressure + heat[v.x][v.y] >= v.limit) {
                    exploded[i] = true;
                    changed = true;

                    // 이 화산이 터지면서 주변에 열기를 퍼뜨림
                    spreadHeat(v, heat);
                }
            }
        }

        // 모든 연쇄 분출이 끝난 뒤,
        // 거북이가 받은 열기가 20 이상이면 화석이 됨
        for (int i = 0; i < M; i++) {
            Turtle t = turtles[i];

            // 죽었거나 이미 도착한 거북이는 검사할 필요 없음
            if (!t.alive || t.arrived) continue;

            // 이번 턴에 받은 열기가 20 이상이면 사망
            if (heat[t.x][t.y] >= 20) {
                t.alive = false;
                answer[i] = -1;

                // 문제 조건에 따라 화석이 된 거북이는 장애물처럼 남음
                // 그래서 turtleMap에서 지우지 않음
            }
        }

        // 이번 턴에 분출한 화산은 압력 0으로 초기화
        for (int i = 0; i < K; i++) {
            if (exploded[i]) {
                volcanos[i].pressure = 0;
            }
        }
    }

    static void spreadHeat(Volcano v, int[][] heat) {

        // 화산 자기 위치에도 열기가 생김
        heat[v.x][v.y] += v.limit;

        // 4방향으로 열기 확산
        for (int d = 0; d < 4; d++) {
            int nx = v.x + dx[d];
            int ny = v.y + dy[d];

            // 한 칸 떨어진 곳은 limit / 2
            // 두 칸 떨어진 곳은 limit / 4
            // 세 칸 떨어진 곳은 limit / 8 ...
            int power = v.limit / 2;

            while (inRange(nx, ny) && power > 0) {

                // 산호초를 만나면 그 방향 열기 확산 중단
                if (map[nx][ny] == CORAL) break;

                // 해당 칸에 열기 누적
                heat[nx][ny] += power;

                // 다음 칸은 열기가 절반으로 줄어듦
                power /= 2;

                nx += dx[d];
                ny += dy[d];
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
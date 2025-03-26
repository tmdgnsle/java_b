import java.io.*;
import java.util.*;

public class Main {
    // 동(1), 서(2), 북(3), 남(4) 방향으로 이동할 때의 좌표 변화량
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    // 주사위의 상태를 나타내는 변수들
    // top: 윗면, bottom: 바닥면, front: 앞면, back: 뒷면, left: 왼쪽면, right: 오른쪽면
    static int top = 0, bottom = 0, front = 0, back = 0, left = 0, right = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
        int x = Integer.parseInt(st.nextToken()); // 주사위의 초기 x 좌표
        int y = Integer.parseInt(st.nextToken()); // 주사위의 초기 y 좌표
        int K = Integer.parseInt(st.nextToken()); // 명령의 개수

        // 지도 정보 입력 받기
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령 입력 받기
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int command = Integer.parseInt(st.nextToken());

            // 다음 위치 계산
            int nx = x + dx[command];
            int ny = y + dy[command];

            // 다음 위치가 지도 범위 안에 있는지 확인
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue; // 범위를 벗어나면 해당 명령을 무시
            }

            // 주사위 굴리기
            roll(command);

            // 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수를 복사
            if (map[nx][ny] == 0) {
                map[nx][ny] = bottom;
            }
            // 0이 아닌 경우, 칸에 쓰여 있는 수를 주사위의 바닥면으로 복사하고, 칸의 수를 0으로 변경
            else {
                bottom = map[nx][ny];
                map[nx][ny] = 0;
            }

            // 주사위의 윗면에 쓰여 있는 수 출력
            sb.append(top).append('\n');

            // 주사위 위치 갱신
            x = nx;
            y = ny;
        }

        System.out.print(sb);
    }

    // 주사위를 굴리는 함수
    static void roll(int direction) {
        int temp;

        // 각 방향에 따라 주사위의 면이 변경됨
        switch (direction) {
            case 1: // 동쪽 방향으로 굴리기
                temp = top;
                top = left;
                left = bottom;
                bottom = right;
                right = temp;
                break;
            case 2: // 서쪽 방향으로 굴리기
                temp = top;
                top = right;
                right = bottom;
                bottom = left;
                left = temp;
                break;
            case 3: // 북쪽 방향으로 굴리기
                temp = top;
                top = front;
                front = bottom;
                bottom = back;
                back = temp;
                break;
            case 4: // 남쪽 방향으로 굴리기
                temp = top;
                top = back;
                back = bottom;
                bottom = front;
                front = temp;
                break;
        }
    }
}
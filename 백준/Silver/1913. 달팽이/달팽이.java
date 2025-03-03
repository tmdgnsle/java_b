import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        // 달팽이 배열 생성
        int[][] snail = new int[n][n];

        // 방향: 상(0), 우(1), 하(2), 좌(3)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 시작 위치 (중앙부터 시작하되, 일단 중앙 아래부터 시작)
        int x = n / 2;
        int y = n / 2;

        // 현재 방향 (상단으로 시작)
        int dir = 0;

        // 타겟 숫자의 위치
        int targetX = 0, targetY = 0;

        // 1부터 n*n까지 숫자 채우기
        int num = 1;
        snail[x][y] = num++;
        if (1 == target) {
            targetX = x + 1;
            targetY = y + 1;
        }

        // 이동 횟수 및 방향 전환 횟수
        int move = 1;
        int change = 0;

        while (num <= n * n) {
            // 현재 방향으로 이동 횟수만큼 진행
            for (int i = 0; i < move; i++) {
                x += dx[dir];
                y += dy[dir];

                // 범위를 벗어나면 종료
                if (x < 0 || x >= n || y < 0 || y >= n) break;

                // 숫자 채우기
                snail[x][y] = num++;

                // 타겟 숫자 위치 저장
                if (snail[x][y] == target) {
                    targetX = x + 1;
                    targetY = y + 1;
                }

                // 모든 숫자를 채웠으면 종료
                if (num > n * n) break;
            }

            // 방향 전환
            dir = (dir + 1) % 4;
            change++;

            // 이동 횟수 증가 (방향 전환 2번마다)
            if (change % 2 == 0) {
                move++;
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(snail[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetX).append(" ").append(targetY);

        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[19][19];
    // 방향: 우, 우하, 하, 좌상 (8방향 탐색 시 중복 제거를 위해 4방향만 탐색)
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 바둑판 입력 받기
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 바둑판 좌표 탐색
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                // 빈 칸이 아닌 경우 (1: 흑돌, 2: 백돌)
                if (board[i][j] != 0) {
                    // 4방향 검사
                    for (int dir = 0; dir < 4; dir++) {
                        // 현재 위치에서 오목이 완성되는지 확인
                        if (checkFive(i, j, dir, board[i][j])) {
                            // 육목인지 확인 (반대쪽으로 같은 돌이 있는지 확인)
                            int prevX = i - dx[dir];
                            int prevY = j - dy[dir];

                            // 이전 방향에 같은 돌이 있으면 육목이므로 건너뜀
                            if (prevX >= 0 && prevX < 19 && prevY >= 0 && prevY < 19 && board[prevX][prevY] == board[i][j]) {
                                continue;
                            }

                            System.out.println(board[i][j]);
                            // 가장 왼쪽 또는 가장 위쪽의 좌표 출력 (문제 조건)
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        // 승부가 결정되지 않은 경우
        System.out.println(0);
    }

    // 오목 확인 함수
    private static boolean checkFive(int x, int y, int dir, int stone) {
        int count = 1; // 현재 위치의 돌을 포함하여 시작

        // 현재 방향으로 연속된 같은 돌 개수 세기
        for (int i = 1; i < 5; i++) {
            int nx = x + dx[dir] * i;
            int ny = y + dy[dir] * i;

            // 바둑판 범위를 벗어나거나 다른 돌이면 중단
            if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || board[nx][ny] != stone) {
                return false;
            }

            count++;
        }

        // 육목인지 확인 (다음 방향에 같은 돌이 있는지 확인)
        int nextX = x + dx[dir] * 5;
        int nextY = y + dy[dir] * 5;

        // 다음 위치에 같은 돌이 있으면 육목이므로 오목이 아님
        if (nextX >= 0 && nextX < 19 && nextY >= 0 && nextY < 19 && board[nextX][nextY] == stone) {
            return false;
        }

        // 연속으로 5개가 있으면 오목
        return count == 5;
    }
}
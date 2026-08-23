class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;

        // lock 주변에 key가 걸칠 수 있도록 확장
        int size = n + (m - 1) * 2;
        int[][] board = new int[size][size];

        // lock을 board 중앙에 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i + m - 1][j + m - 1] = lock[i][j];
            }
        }

        // 4방향 회전
        for (int r = 0; r < 4; r++) {

            // key를 놓을 수 있는 모든 위치
            for (int x = 0; x <= size - m; x++) {
                for (int y = 0; y <= size - m; y++) {

                    // key 올리기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            board[x + i][y + j] += key[i][j];
                        }
                    }

                    // lock 영역이 전부 1인지 검사
                    if (check(board, m, n)) {
                        return true;
                    }

                    // key 원상복구
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            board[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }

            key = rotate(key);
        }

        return false;
    }

    static boolean check(int[][] board, int m, int n) {
        for (int i = m - 1; i < m - 1 + n; i++) {
            for (int j = m - 1; j < m - 1 + n; j++) {
                if (board[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    static int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] newKey = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                newKey[j][m - 1 - i] = key[i][j];
            }
        }

        return newKey;
    }
}
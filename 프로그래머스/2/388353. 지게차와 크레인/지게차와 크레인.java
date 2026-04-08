import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        // 바깥 공기 처리를 쉽게 하려고 가장자리에 패딩 추가
        char[][] board = new char[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(board[i], '.');   // '.' = 빈칸(공기)
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        int remain = n * m;

        for (String req : requests) {
            char target = req.charAt(0);

            // 크레인: 같은 종류 전부 제거
            if (req.length() == 2) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (board[i][j] == target) {
                            board[i][j] = '.';
                            remain--;
                        }
                    }
                }
            }
            // 지게차: 바깥과 연결된 공기와 맞닿은 target만 제거
            else {
                boolean[][] outside = getOutside(board, n, m);
                List<int[]> removeList = new ArrayList<>();

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (board[i][j] != target) continue;

                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (outside[nx][ny]) {
                                removeList.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }

                for (int[] pos : removeList) {
                    int x = pos[0];
                    int y = pos[1];
                    board[x][y] = '.';
                    remain--;
                }
            }
        }

        return remain;
    }

    static boolean[][] getOutside(char[][] board, int n, int m) {
        boolean[][] visited = new boolean[n + 2][m + 2];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n + 2 || ny < 0 || ny >= m + 2) continue;
                if (visited[nx][ny]) continue;

                // 빈칸('.')으로만 바깥 공기 확장
                if (board[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return visited;
    }
}
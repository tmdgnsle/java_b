import java.util.*;

class Solution {
    int n;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;

        // 1) 빈칸(0) 모양들 저장: key -> 개수
        Map<String, Integer> holeMap = new HashMap<>();
        boolean[][] visBoard = new boolean[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visBoard[r][c] && game_board[r][c] == 0) {
                    List<int[]> hole = bfs(game_board, visBoard, r, c, 0);
                    String key = makeKey(hole);
                    holeMap.put(key, holeMap.getOrDefault(key, 0) + 1);
                }
            }
        }

        // 2) 조각(1) 하나씩 꺼내서 4번 회전하며 holeMap에 있으면 채움
        boolean[][] visTable = new boolean[n][n];
        int answer = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visTable[r][c] && table[r][c] == 1) {
                    List<int[]> piece = bfs(table, visTable, r, c, 1);
                    int size = piece.size();

                    // 조각을 정규화한 뒤, 4회전 해보면서 매칭 시도
                    List<int[]> cur = normalize(piece);

                    boolean matched = false;
                    for (int k = 0; k < 4; k++) {
                        String key = makeKey(cur);  // cur은 이미 정규화된 좌표들

                        if (holeMap.getOrDefault(key, 0) > 0) {
                            holeMap.put(key, holeMap.get(key) - 1);
                            answer += size;
                            matched = true;
                            break;
                        }

                        cur = rotate90(cur); // 다음 회전
                    }

                    // matched 안 되면 그냥 버림
                }
            }
        }

        return answer;
    }

    // BFS로 target(0 또는 1) 덩어리 좌표 수집
    private List<int[]> bfs(int[][] board, boolean[][] vis, int sr, int sc, int target) {
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> cells = new ArrayList<>();

        vis[sr][sc] = true;
        q.add(new int[]{sr, sc});
        cells.add(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (vis[nr][nc]) continue;
                if (board[nr][nc] != target) continue;

                vis[nr][nc] = true;
                q.add(new int[]{nr, nc});
                cells.add(new int[]{nr, nc});
            }
        }
        return cells;
    }

    // (0,0) 기준으로 좌표 이동 + 정렬
    private List<int[]> normalize(List<int[]> cells) {
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
        for (int[] p : cells) {
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }

        List<int[]> norm = new ArrayList<>();
        for (int[] p : cells) {
            norm.add(new int[]{p[0] - minR, p[1] - minC});
        }

        norm.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return norm;
    }

    // 좌표 리스트 -> 문자열 key
    private String makeKey(List<int[]> normCells) {
        // 혹시 입력이 정렬 안됐을 수도 있으니 안전하게 정렬/정규화 한 번 더
        List<int[]> cells = normalize(normCells);

        StringBuilder sb = new StringBuilder();
        for (int[] p : cells) {
            sb.append(p[0]).append(',').append(p[1]).append('|');
        }
        return sb.toString();
    }

    // 90도 회전: (r,c) -> (c, -r) 후 다시 정규화
    private List<int[]> rotate90(List<int[]> normCells) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : normCells) {
            int r = p[0], c = p[1];
            rotated.add(new int[]{c, -r});
        }
        return normalize(rotated);
    }
}
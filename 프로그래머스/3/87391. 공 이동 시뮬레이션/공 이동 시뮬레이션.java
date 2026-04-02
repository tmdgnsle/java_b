class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long startRow = x;
        long endRow = x;
        long startCol = y;
        long endCol = y;

        for (int i = queries.length - 1; i >= 0; i--) {
            int dir = queries[i][0];
            int dist = queries[i][1];

            if (dir == 0) { // 정방향: 왼쪽, 역방향: 오른쪽으로 확장
                if (startCol != 0) startCol += dist;
                endCol = Math.min(m - 1L, endCol + dist);
            } else if (dir == 1) { // 정방향: 오른쪽, 역방향: 왼쪽으로 확장
                startCol = Math.max(0L, startCol - dist);
                if (endCol != m - 1L) endCol -= dist;
            } else if (dir == 2) { // 정방향: 위, 역방향: 아래로 확장
                if (startRow != 0) startRow += dist;
                endRow = Math.min(n - 1L, endRow + dist);
            } else { // dir == 3, 정방향: 아래, 역방향: 위로 확장
                startRow = Math.max(0L, startRow - dist);
                if (endRow != n - 1L) endRow -= dist;
            }

            if (startRow > n - 1 || endRow < 0 || startCol > m - 1 || endCol < 0) {
                return 0;
            }
        }

        return (endRow - startRow + 1) * (endCol - startCol + 1);
    }
}
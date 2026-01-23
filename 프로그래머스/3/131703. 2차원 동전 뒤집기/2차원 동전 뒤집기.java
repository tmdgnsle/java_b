class Solution {
    int n, m;
    int[][] diff;
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] beginning, int[][] target) {
        n = beginning.length;
        m = beginning[0].length;

        diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = beginning[i][j] ^ target[i][j]; // ^ XOR 둘이 다르면 1, 같으면 0
            }
        }

        boolean[] rowFlip = new boolean[n];
        dfs(0, rowFlip);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // 각 행을 뒤집을지 말지 선택
    void dfs(int idx, boolean[] rowFlip) {
        if (idx == n) {
            check(rowFlip);
            return;
        }

        // 안 뒤집는 경우
        rowFlip[idx] = false;
        dfs(idx + 1, rowFlip);

        // 뒤집는 경우
        rowFlip[idx] = true;
        dfs(idx + 1, rowFlip);
    }

    // rowFlip이 정해졌을 때 가능한지 검사
    void check(boolean[] rowFlip) {
        boolean[] colFlip = new boolean[m];

        // 첫 행 기준으로 열 결정
        for (int j = 0; j < m; j++) {
            colFlip[j] = (diff[0][j] == 1) ^ rowFlip[0];
        }

        // 전체 검증
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean cur = rowFlip[i] ^ colFlip[j];
                if (cur != (diff[i][j] == 1)) return;
            }
        }

        // 뒤집기 횟수 계산
        int cnt = 0;
        for (boolean r : rowFlip) if (r) cnt++;
        for (boolean c : colFlip) if (c) cnt++;

        answer = Math.min(answer, cnt);
    }
}
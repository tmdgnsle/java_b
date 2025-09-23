class Solution {
    private int n;
    private int answer = Integer.MAX_VALUE;
    private int[][] original;
    private int[] firstRowRotations; // 첫 번째 행의 회전 횟수 저장
    
    public int solution(int[][] clockHands) {
        n = clockHands.length;
        original = clockHands;
        firstRowRotations = new int[n];
        
        // 첫 번째 행의 각 칸을 0~3번 회전하는 모든 경우의 수 시도
        dfs(0);
        
        return answer;
    }
    
    // col: 현재 처리할 열 번호
    private void dfs(int col) {
        if (col == n) {
            // 첫 번째 행이 모두 결정되면 그리디로 해결
            solveWithGreedy();
            return;
        }
        
        // 현재 열을 0~3번 회전하는 경우들
        for (int rotation = 0; rotation <= 3; rotation++) {
            firstRowRotations[col] = rotation; // 현재 칸의 회전 횟수 저장
            dfs(col + 1);
        }
    }
    
    // 첫 번째 행이 결정된 후 그리디로 나머지 해결
    private void solveWithGreedy() {
        // 원본 배열 복사
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = original[i][j];
            }
        }
        
        int totalRotations = 0;
        
        // 첫 번째 행 회전 적용
        for (int j = 0; j < n; j++) {
            applyRotation(temp, 0, j, firstRowRotations[j]);
            totalRotations += firstRowRotations[j];
        }
        
        // 두 번째 행부터 그리디하게 해결
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 위쪽 칸(i-1, j)을 12시 방향(0)으로 맞추기 위한 회전 횟수
                int currentDirection = temp[i-1][j] % 4;
                int needRotation = 0;
                
                // 현재 방향에서 0(12시)까지 필요한 회전 횟수 계산
                if (currentDirection == 1) needRotation = 3;
                else if (currentDirection == 2) needRotation = 2;
                else if (currentDirection == 3) needRotation = 1;
                else needRotation = 0; // 이미 12시 방향
                
                applyRotation(temp, i, j, needRotation);
                totalRotations += needRotation;
            }
        }
        
        // 마지막 행이 모두 12시 방향인지 확인
        boolean solved = true;
        for (int j = 0; j < n; j++) {
            if (temp[n-1][j] % 4 != 0) {
                solved = false;
                break;
            }
        }
        
        if (solved) {
            answer = Math.min(answer, totalRotations);
        }
    }
    
    // (r, c) 위치를 rotation번 회전 -> 십자 모양의 시계들이 함께 회전
    private void applyRotation(int[][] grid, int r, int c, int rotation) {
        // 십자 모양: 상, 하, 좌, 우, 자기자신
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {0, 0}};
        
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            // 범위 체크
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                grid[nr][nc] = (grid[nr][nc] + rotation) % 4;
            }
        }
    }
}
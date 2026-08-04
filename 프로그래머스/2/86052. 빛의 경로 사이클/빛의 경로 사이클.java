import java.util.*;

class Solution {

    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static String[] grid;
    static boolean[][][] visited;
    static int row;
    static int col;

    public int[] solution(String[] grid) {
        row = grid.length;
        col = grid[0].length();

        
        visited = new boolean[row][col][4];
        this.grid = grid;

        List<Integer> answer = new ArrayList<>();

        // 모든 칸과 모든 시작 방향을 확인한다.
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                for (int dir = 0; dir < 4; dir++) {

                    // 이미 다른 사이클을 탐색하면서 지나간 상태
                    if (visited[x][y][dir]) {
                        continue;
                    }

                    int length = findCycle(
                            x,
                            y,
                            dir
                    );

                    answer.add(length);
                }
            }
        }

        Collections.sort(answer);

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    static int findCycle(
            int startX,
            int startY,
            int startDir
    ) {
        int x = startX;
        int y = startY;
        int dir = startDir;

        int length = 0;

        while (!visited[x][y][dir]) {

            // 현재 상태 방문 처리
            visited[x][y][dir] = true;
            length++;

            char command = grid[x].charAt(y);

            // 현재 칸의 명령에 따라 방향 변경
            if (command == 'L') {
                dir = (dir + 3) % 4;
            } else if (command == 'R') {
                dir = (dir + 1) % 4;
            }

            // 변경된 방향으로 한 칸 이동
            x = (x + dx[dir] + row) % row;
            y = (y + dy[dir] + col) % col;
        }

        return length;
    }
}
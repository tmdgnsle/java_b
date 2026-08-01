import java.util.*;

class Solution {

    static class Node {
        int x;
        int y;
        int dir;
        int cost;

        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int n = board.length;

        
        int[][][] cost = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Node> queue = new LinkedList<>();

       
        for (int dir = 0; dir < 4; dir++) {
            int nx = dx[dir];
            int ny = dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            if (board[nx][ny] == 1) {
                continue;
            }

            cost[nx][ny][dir] = 100;
            queue.offer(new Node(nx, ny, dir, 100));
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int x = current.x;
            int y = current.y;
            int dir = current.dir;
            int currentCost = current.cost;

            
            if (currentCost > cost[x][y][dir]) {
                continue;
            }

            for (int nextDir = 0; nextDir < 4; nextDir++) {
                int nx = x + dx[nextDir];
                int ny = y + dy[nextDir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (board[nx][ny] == 1) {
                    continue;
                }

                int nextCost = currentCost;

                if (dir == nextDir) {
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }

                if (nextCost < cost[nx][ny][nextDir]) {
                    cost[nx][ny][nextDir] = nextCost;
                    queue.offer(new Node(nx, ny, nextDir, nextCost));
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int dir = 0; dir < 4; dir++) {
            answer = Math.min(answer, cost[n - 1][n - 1][dir]);
        }

        return answer;
    }
}
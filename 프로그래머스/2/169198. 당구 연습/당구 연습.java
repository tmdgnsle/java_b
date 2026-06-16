import java.util.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i = 0; i<balls.length; i++){
            int x = balls[i][0];
            int y = balls[i][1];
            
            int min = Integer.MAX_VALUE;
            
            // 반사시킨다는 개념 사용
            
            // 왼쪽 벽
            if (!(startY == y && startX > x)) {
                min = Math.min(min, dist(startX, startY, -x, y));
            }

            // 오른쪽 벽
            if (!(startY == y && startX < x)) {
                min = Math.min(min, dist(startX, startY, 2 * m - x, y));
            }

            // 아래쪽 벽
            if (!(startX == x && startY > y)) {
                min = Math.min(min, dist(startX, startY, x, -y));
            }

            // 위쪽 벽
            if (!(startX == x && startY < y)) {
                min = Math.min(min, dist(startX, startY, x, 2 * n - y));
            }

            answer[i] = min;
        }
        return answer;
    }
    
    static int dist(int x1, int y1, int x2, int y2){
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx * dx + dy * dy;
    }
}
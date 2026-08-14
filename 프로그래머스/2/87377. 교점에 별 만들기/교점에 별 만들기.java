import java.util.*;

class Solution {

    static int[][] line;
    static List<long[]> points;

    public String[] solution(int[][] line) {

        this.line = line;
        points = new ArrayList<>();

        // 1. 모든 직선 쌍의 정수 교점 찾기
        for(int i = 0; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                find(i, j);
            }
        }

        // 2. 교점들의 최소/최대 좌표 찾기
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for(long[] point : points){
            long x = point[0];
            long y = point[1];

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);

            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        // 3. 별을 그릴 배열 크기
        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);

        char[][] board = new char[height][width];

        // 처음에는 전부 . 으로 채움
        for(int i = 0; i < height; i++){
            Arrays.fill(board[i], '.');
        }

        // 4. 교점 위치에 별 찍기
        for(long[] point : points){
            long x = point[0];
            long y = point[1];

            int row = (int)(maxY - y);
            int col = (int)(x - minX);

            board[row][col] = '*';
        }

        // 5. char[][] -> String[]
        String[] answer = new String[height];

        for(int i = 0; i < height; i++){
            answer[i] = new String(board[i]);
        }

        return answer;
    }

    static void find(int first, int second){

        long a = line[first][0];
        long b = line[first][1];
        long e = line[first][2];

        long c = line[second][0];
        long d = line[second][1];
        long f = line[second][2];

        // AD - BC
        long denominator = a * d - b * c;

        // 평행하거나 일치
        if(denominator == 0) return;

        // BF - ED
        long xNumerator = b * f - e * d;

        // EC - AF
        long yNumerator = e * c - a * f;

        // 정수 교점이 아니면 무시
        if(xNumerator % denominator != 0 ||
           yNumerator % denominator != 0){
            return;
        }

        long x = xNumerator / denominator;
        long y = yNumerator / denominator;

        points.add(new long[]{x, y});
    }
}
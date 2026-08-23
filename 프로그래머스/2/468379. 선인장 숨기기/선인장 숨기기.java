import java.util.*;

class Solution {

    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        int INF = drops.length + 1;

        // 각 칸에 몇 번째 비가 내리는지 저장
        int[][] rain = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(rain[i], INF);
        }

        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];

            rain[r][c] = i + 1;
        }


        /*
         * 1단계
         * 각 행에서 길이 w 구간의 최솟값
         *
         * rowMin[r][c]
         * = rain[r][c ~ c+w-1] 중 최솟값
         */
        int colCount = n - w + 1;

        int[][] rowMin = new int[m][colCount];

        for (int r = 0; r < m; r++) {

            Deque<Integer> deque = new ArrayDeque<>();

            for (int c = 0; c < n; c++) {

                // 현재 값보다 큰 값들은 필요 없음
                while (!deque.isEmpty()
                        && rain[r][deque.peekLast()] >= rain[r][c]) {
                    deque.pollLast();
                }

                deque.offerLast(c);

                // 범위를 벗어난 인덱스 제거
                if (deque.peekFirst() <= c - w) {
                    deque.pollFirst();
                }

                // 길이 w가 완성됐을 때
                if (c >= w - 1) {
                    int start = c - w + 1;

                    rowMin[r][start] = rain[r][deque.peekFirst()];
                }
            }
        }


        /*
         * 2단계
         * rowMin에서 세로 길이 h의 최솟값
         */

        int best = -1;
        int answerR = 0;
        int answerC = 0;

        for (int c = 0; c < colCount; c++) {

            Deque<Integer> deque = new ArrayDeque<>();

            for (int r = 0; r < m; r++) {

                while (!deque.isEmpty()
                        && rowMin[deque.peekLast()][c] >= rowMin[r][c]) {
                    deque.pollLast();
                }

                deque.offerLast(r);

                // 세로 h 범위 밖 제거
                if (deque.peekFirst() <= r - h) {
                    deque.pollFirst();
                }

                if (r >= h - 1) {

                    int startR = r - h + 1;

                    int minRain = rowMin[deque.peekFirst()][c];

                    if (minRain > best) {
                        best = minRain;
                        answerR = startR;
                        answerC = c;
                    }
                    else if (minRain == best) {

                        // 가장 위쪽
                        if (startR < answerR) {
                            answerR = startR;
                            answerC = c;
                        }
                        // 같은 행이면 가장 왼쪽
                        else if (startR == answerR && c < answerC) {
                            answerC = c;
                        }
                    }
                }
            }
        }

        return new int[]{answerR, answerC};
    }
}
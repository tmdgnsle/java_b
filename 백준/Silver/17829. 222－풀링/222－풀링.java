import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(pooling(0, 0, n));
    }

    // 222-풀링 연산을 수행하는 재귀 함수
    private static int pooling(int row, int col, int size) {
        // 기저 사례: 2x2 행렬에 도달했을 때
        if (size == 2) {
            int[] values = new int[4];
            values[0] = matrix[row][col];          // 좌상단
            values[1] = matrix[row][col + 1];      // 우상단
            values[2] = matrix[row + 1][col];      // 좌하단
            values[3] = matrix[row + 1][col + 1];  // 우하단

            // 정렬 후 두 번째로 큰 값 반환
            Arrays.sort(values);
            return values[2];
        }

        // 4개의 부분 행렬로 분할
        int newSize = size / 2;
        int[] results = new int[4];

        results[0] = pooling(row, col, newSize);                  // 좌상단 부분 행렬
        results[1] = pooling(row, col + newSize, newSize);        // 우상단 부분 행렬
        results[2] = pooling(row + newSize, col, newSize);        // 좌하단 부분 행렬
        results[3] = pooling(row + newSize, col + newSize, newSize); // 우하단 부분 행렬

        // 각 부분 행렬의 풀링 결과 중 두 번째로 큰 값 반환
        Arrays.sort(results);
        return results[2];
    }
}
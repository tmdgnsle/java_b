import java.io.*;
import java.util.*;

public class Main {
    // 0~9까지 7세그먼트 표시
    static int[] segments = {
            0b1110111, // 0
            0b0010010, // 1
            0b1011101, // 2
            0b1011011, // 3
            0b0111010, // 4
            0b1101011, // 5
            0b1101111, // 6
            0b1010010, // 7
            0b1111111, // 8
            0b1111011  // 9
    };

    // 두 숫자 간 LED 차이를 미리 계산
    static int[][] diff = new int[10][10];

    static int N, K, P, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 모든 숫자 쌍의 LED 차이를 미리 계산
        preCalculate();

        int count = 0;

        // 1층부터 N층까지 확인
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;

            int totalDiff = getDifference(X, i);

            if (totalDiff > 0 && totalDiff <= P) {
                count++;
            }
        }

        System.out.println(count);
    }

    // 0~9 모든 숫자 쌍의 LED 차이를 미리 계산
    static void preCalculate() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                diff[i][j] = Integer.bitCount(segments[i] ^ segments[j]);
            }
        }
    }

    // 두 층수 사이의 LED 반전 개수 계산
    static int getDifference(int from, int to) {
        int totalDiff = 0;

        for (int i = 0; i < K; i++) {
            int fromDigit = from % 10;
            int toDigit = to % 10;

            totalDiff += diff[fromDigit][toDigit];

            from /= 10;
            to /= 10;
        }

        return totalDiff;
    }
}
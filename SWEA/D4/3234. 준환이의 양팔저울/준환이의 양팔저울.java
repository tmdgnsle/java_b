import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] nums;
    static boolean[] v;
    static long count;  // int에서 long으로 변경 (큰 수 처리를 위해)
    static int sum;
    static long[] factorial;
    static long[] powTwo;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input_3234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums = new int[N];
            v = new boolean[N];
            count = 0;
            sum = 0;

            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                sum += nums[i];
            }

            // 팩토리얼과 2의 거듭제곱 미리 계산
            factorial = new long[N + 1];
            powTwo = new long[N + 1];
            factorial[0] = 1;
            powTwo[0] = 1;

            for (int i = 1; i <= N; i++) {
                factorial[i] = factorial[i - 1] * i;
                powTwo[i] = powTwo[i - 1] * 2;
            }

            bt(0, 0, 0);

            System.out.println("#" + t + " " + count);
        }
    }

    static void bt(int depth, int l, int r) {
        // 모든 추를 다 올린 경우
        if (depth == N) {
            count++;
            return;
        }

        // 가지치기: 왼쪽 무게가 (남은 모든 추 + 오른쪽 무게)보다 크거나 같으면
        // 남은 추를 모두 오른쪽에 올려도 조건을 만족합니다
        int remainingWeight = sum - l - r;
        if (l >= r + remainingWeight) {
            // 남은 추들로 만들 수 있는 모든 순열 * 각 추를 놓는 위치(왼/오)
            count += factorial[N - depth] * powTwo[N - depth];
            return;
        }

        // 각 추를 순서대로 시도
        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;

                // 추를 왼쪽 저울에 올리는 경우
                bt(depth + 1, l + nums[i], r);

                // 추를 오른쪽 저울에 올리는 경우 (왼쪽 >= 오른쪽 조건 확인)
                if (l >= r + nums[i]) {
                    bt(depth + 1, l, r + nums[i]);
                }

                v[i] = false;
            }
        }
    }
}
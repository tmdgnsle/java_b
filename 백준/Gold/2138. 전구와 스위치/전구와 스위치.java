import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] start, target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        start = br.readLine().trim().toCharArray();
        target = br.readLine().trim().toCharArray();

        int case1 = simulate(false); // 0번 스위치 안 누름
        int case2 = simulate(true);  // 0번 스위치 누름

        int ans = Math.min(case1, case2);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    // pressFirst = true면 0번 스위치를 먼저 누른 상태로 시작
    static int simulate(boolean pressFirst) {
        char[] cur = start.clone();
        int cnt = 0;

        if (pressFirst) {
            press(cur, 0);
            cnt++;
        }

        // i=1..N-1 스위치를 결정 (i-1 전구를 맞추기 위해)
        for (int i = 1; i < N; i++) {
            if (cur[i - 1] != target[i - 1]) {
                press(cur, i);
                cnt++;
            }
        }

        // 최종 비교
        for (int i = 0; i < N; i++) {
            if (cur[i] != target[i]) return Integer.MAX_VALUE;
        }
        return cnt;
    }

    static void press(char[] arr, int i) {
        toggle(arr, i);
        if (i - 1 >= 0) toggle(arr, i - 1);
        if (i + 1 < N) toggle(arr, i + 1);
    }

    static void toggle(char[] arr, int i) {
        arr[i] = (arr[i] == '0') ? '1' : '0';
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int m = cores.length;
        if (n <= m) return n; // 시작하자마자 각 코어에 1개씩 들어감

        long left = 0;
        long right = 0;

        // upper bound 잡기: 가장 느린 코어 기준으로 넉넉히
        int maxCore = 0;
        for (int c : cores) maxCore = Math.max(maxCore, c);
        right = (long) maxCore * n; // 충분히 큰 값

        // t 시간까지 처리 가능한 작업 수
        // done(t) = m + sum(t / cores[i])
        while (left < right) {
            long mid = (left + right) / 2;
            long done = m;
            for (int c : cores) {
                done += mid / c;
                if (done >= n) break; // 오버플로/불필요 계산 방지
            }

            if (done >= n) right = mid;
            else left = mid + 1;
        }

        long t = left;

        // t-1까지 처리한 개수
        long doneBefore = m;
        long tb = t - 1;
        for (int c : cores) doneBefore += tb / c;

        long remain = n - doneBefore; // t 시점에 새로 배정해야 할 작업 수

        // t 시점에 끝나는 코어들에 앞에서부터 배정
        for (int i = 0; i < m; i++) {
            if (t % cores[i] == 0) {
                remain--;
                if (remain == 0) return i + 1;
            }
        }

        return -1; // 도달하면 안 됨
    }
}
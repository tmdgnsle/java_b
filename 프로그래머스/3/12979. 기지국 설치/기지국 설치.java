import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2 * w + 1;

        int start = 1;

        for (int station : stations) {
            int left = station - w;
            int right = station + w;

            // start ~ left-1 까지가 전파 안 닿는 구간
            if (start < left) {
                int len = left - start;
                answer += (len + cover - 1) / cover; // 올림 나눗셈
            }

            // 다음 확인 시작 위치
            start = right + 1;
        }

        // 마지막 기지국 이후 남은 구간
        if (start <= n) {
            int len = n - start + 1;
            answer += (len + cover - 1) / cover; // 올림 나눗셈
        }

        return answer;
    }
}
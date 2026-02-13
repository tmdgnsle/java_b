import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        // 1) 약수 개수 전처리
        int[] divCnt = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                divCnt[j]++;
                // 1, 2, 2, 3, 2, 4, 2, 4
            }
        }

        // 2) best[i] = i 이상 구간에서 약수 개수가 최대인 수 (동률이면 더 작은 수)
        int[] best = new int[e + 1];
        int bestIdx = e;
        best[e] = e;
        
        // best[8] = 8

        for (int i = e - 1; i >= 1; i--) {
            // 뒤에서 앞으로 오니까, 동률(=)이면 i(더 작은 수)로 갈아타야 함
            if (divCnt[i] >= divCnt[bestIdx]) {
                bestIdx = i;
            }
            best[i] = bestIdx;
            // best
            // 6, 6, 6, 6, 6, 6, 8, 8
        }

        // 3) 질의 처리
        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = best[starts[i]];
        }
        return answer;
    }
}
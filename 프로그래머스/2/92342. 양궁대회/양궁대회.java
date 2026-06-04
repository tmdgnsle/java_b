import java.util.*;

class Solution {
    static int n;
    static int[] info;
    static int[] ryan;
    static int maxDiff;
    static int[] answer;

    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;

        ryan = new int[11];
        maxDiff = 0;

        bt(0, 0);

        if (maxDiff == 0) return new int[]{-1};
        return answer;
    }

    static void bt(int idx, int count) {
        if (count == n) {
            compareScore();
            return;
        }

        for (int i = idx; i < 11; i++) {
            ryan[i]++;
            bt(i, count + 1);
            ryan[i]--;
        }
    }

    static void compareScore() {
        int apeach = 0;
        int ryanScore = 0;

        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && ryan[i] == 0) continue;

            if (info[i] >= ryan[i]) {
                apeach += 10 - i;
            } else {
                ryanScore += 10 - i;
            }
        }

        int diff = ryanScore - apeach;

        if (diff <= 0) return;

        if (diff > maxDiff) {
            maxDiff = diff;
            answer = ryan.clone();
        } else if (diff == maxDiff) {
            for (int i = 10; i >= 0; i--) {
                if (ryan[i] > answer[i]) {
                    answer = ryan.clone();
                    break;
                } else if (ryan[i] < answer[i]) {
                    break;
                }
            }
        }
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        // 끝나는 지점 기준 오름차순
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        // 마지막으로 요격 미사일을 쏜 위치
        int point = 0;

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            // point가 현재 구간 안에 없으면 새로 쏴야 함
            if (point <= start) {
                answer++;

                // 실제로는 end 바로 직전에 쏜다고 생각
                point = end;
            }
        }

        return answer;
    }
}
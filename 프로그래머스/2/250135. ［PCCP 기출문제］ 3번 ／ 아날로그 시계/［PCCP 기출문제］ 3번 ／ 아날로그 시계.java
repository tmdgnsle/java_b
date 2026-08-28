class Solution {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        int answer = count(end) - count(start);

        // 시작 시간이 정확히 겹치는 순간이면 포함해야 함
        if (start % 3600 == 0) {
            answer++;
        }

        return answer;
    }

    // 00:00:00 ~ time까지 울린 알람 횟수
    private int count(int time) {

        // 초침과 분침이 겹친 횟수
        int minute = time * 59 / 3600;

        // 초침과 시침이 겹친 횟수
        int hour = time * 719 / 43200;

        // 00:00:00에서 한 번
        int result = minute + hour + 1;

        // 12:00:00에서는
        // 시침/분침/초침이 동시에 겹쳐 2번 계산되므로 1번 제거
        if (time >= 43200) {
            result--;
        }

        return result;
    }
}
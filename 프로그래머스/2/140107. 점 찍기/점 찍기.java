class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (long x = 0; x <= d; x += k) {
            long remain = (long) d * d - x * x;
            long maxY = (long) Math.sqrt(remain);

            answer += maxY / k + 1;
        }

        return answer;
    }
}
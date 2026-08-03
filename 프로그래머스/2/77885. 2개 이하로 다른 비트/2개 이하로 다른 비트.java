class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            if (num % 2 == 0) {
                // 짝수는 마지막 비트가 0이므로
                // 1을 더하면 비트가 하나만 달라진다.
                answer[i] = num + 1;
            } else {
                // 홀수는 오른쪽에서 처음 등장하는 0을 1로 바꾸고,
                // 그 바로 오른쪽의 1을 0으로 바꾼다.
                answer[i] = num + 1 + ((num ^ (num + 1)) >> 2);
            }
        }

        return answer;
    }
}
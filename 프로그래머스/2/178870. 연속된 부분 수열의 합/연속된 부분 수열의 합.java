class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[0];

        int answerStart = 0;
        int answerEnd = 0;
        int length = Integer.MAX_VALUE;

        while (start < sequence.length && end < sequence.length) {

            if (sum == k) {
                int currentLength = end - start;

                if (currentLength < length) {
                    length = currentLength;
                    answerStart = start;
                    answerEnd = end;
                }

                sum -= sequence[start];
                start++;
            } 
            else if (sum < k) {
                end++;

                if (end < sequence.length) {
                    sum += sequence[end];
                }
            } 
            else { 
                sum -= sequence[start];
                start++;
            }
        }

        return new int[] {answerStart, answerEnd};
    }
}
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        long r1Square = (long) r1 * r1;
        long r2Square = (long) r2 * r2;

        for (int x = 1; x <= r2; x++) {
            long xSquare = (long) x * x;

            long maxY = (long) Math.sqrt(r2Square - xSquare);

            long minY = 0;
            if (x < r1) {
                minY = (long) Math.ceil(Math.sqrt(r1Square - xSquare));
            }

            answer += maxY - minY + 1;
        }

        return answer * 4;
    }
}
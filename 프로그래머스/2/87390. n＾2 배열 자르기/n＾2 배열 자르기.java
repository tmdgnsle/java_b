class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];
        
        for (long idx = left; idx <= right; idx++) {
            long row = idx / n;
            long col = idx % n;
            answer[(int)(idx - left)] = (int)Math.max(row, col) + 1;
        }
        
        return answer;
    }
}
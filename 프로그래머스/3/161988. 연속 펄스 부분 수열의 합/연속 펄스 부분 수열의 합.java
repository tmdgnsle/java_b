class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        long maxSum1 = Long.MIN_VALUE;  
        long maxSum2 = Long.MIN_VALUE;  
        
        long currentSum1 = 0;  
        long currentSum2 = 0;  
        
        for (int i = 0; i < n; i++) {
            
            int pulse1 = (i % 2 == 0) ? 1 : -1;
            int pulse2 = (i % 2 == 0) ? -1 : 1;
            
            
            currentSum1 = Math.max(sequence[i] * pulse1, currentSum1 + sequence[i] * pulse1);
            currentSum2 = Math.max(sequence[i] * pulse2, currentSum2 + sequence[i] * pulse2);
            
            
            maxSum1 = Math.max(maxSum1, currentSum1);
            maxSum2 = Math.max(maxSum2, currentSum2);
        }
        
        return Math.max(maxSum1, maxSum2);
    }
}
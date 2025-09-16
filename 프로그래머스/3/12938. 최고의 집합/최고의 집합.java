class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int m = s / n;
        int r = s % n;
        if(m == 0){
            return new int[] {-1};
        }
        if(r == 0){
            for(int i = 0; i<n; i++){
                answer[i] = m;
            }
        } else {
            int idx = 0;
            for(int i = 0; i<n-r; i++){
                answer[idx++] = m;
            }
            for(int i = idx; i<n; i++){
                answer[i] = m+1;
            }
        }
        
        
        return answer;
    }
}
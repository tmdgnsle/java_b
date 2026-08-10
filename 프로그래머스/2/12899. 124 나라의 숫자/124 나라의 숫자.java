class Solution {
    public String solution(int n) {
        String[] nums = {"1", "2", "4"};
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            n--;
            int idx = n % 3;
            n /= 3;
            
            sb.append(nums[idx]);
            
        }
        
        return sb.reverse().toString();
    }
}
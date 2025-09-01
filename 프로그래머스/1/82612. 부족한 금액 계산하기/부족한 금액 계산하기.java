class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long total = 0;
        
        for(int i = 1; i<=count; i++){
            long current = price * i;
            total += current;
        }
        
        answer = total - money;

        return answer >= 0 ? answer : 0;
    }
}
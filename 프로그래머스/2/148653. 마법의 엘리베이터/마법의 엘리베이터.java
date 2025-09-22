class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int digit = storey % 10;  // 현재 자릿수
            storey /= 10;
            
            if (digit < 5) {
                // 현재 자릿수가 5 미만이면 빼는 게 유리
                answer += digit;
            } else if (digit > 5) {
                // 현재 자릿수가 5 초과면 올리는 게 유리
                answer += (10 - digit);
                storey++;  // 다음 자릿수에 1 추가
            } else {
                // digit == 5인 경우: 다음 자릿수를 고려
                int nextDigit = storey % 10;
                if (nextDigit >= 5) {
                    // 다음 자릿수가 5 이상이면 올리는 게 유리
                    answer += (10 - digit);
                    storey++;
                } else {
                    // 다음 자릿수가 5 미만이면 빼는 게 유리
                    answer += digit;
                }
            }
        }
        
        return answer;
    }
}
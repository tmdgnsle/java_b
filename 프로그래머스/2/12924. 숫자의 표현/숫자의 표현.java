import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;

        int l = 1, r = 1;
        int sum = 1;

        while (l <= n) {
            if (sum == n) {
                answer++;
                r++;
                if (r > n) break;
                sum += r;
            } else if (sum < n) {
                r++;
                if (r > n) break;
                sum += r;
            } else { 
                sum -= l;
                l++;
                if (l > r && l <= n) { 
                    r = l;
                    sum = l;
                }
            }
        }

        return answer;
    }
}
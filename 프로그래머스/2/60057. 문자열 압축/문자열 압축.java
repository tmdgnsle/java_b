import java.util.*;

class Solution {
    static int answer;
    static String s;

    public int solution(String s) {
        this.s = s;
        answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            divide(i);
        }

        return answer;
    }

    static void divide(int d) {
        StringBuilder sb = new StringBuilder();

        String before = s.substring(0, d);
        int count = 1;

        for (int i = d; i < s.length(); i += d) {

            String current =
                s.substring(i, Math.min(i + d, s.length()));

            if (before.equals(current)) {
                count++;
            } else {
                if (count == 1) {
                    sb.append(before);
                } else {
                    sb.append(count).append(before);
                }

                before = current;
                count = 1;
            }
        }

        //마지막으로 남은 문자열 처리
        if (count == 1) {
            sb.append(before);
        } else {
            sb.append(count).append(before);
        }

        answer = Math.min(answer, sb.length());

        
    }
}
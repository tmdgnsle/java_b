import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = 0;

        for (int rot = 0; rot < n; rot++) {
            if (isValidRotation(s, rot)) answer++;
        }

        return answer;
    }

    private boolean isValidRotation(String s, int rot) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt((rot + i) % n); // 회전 효과

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!isPair(top, c)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isPair(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }
}
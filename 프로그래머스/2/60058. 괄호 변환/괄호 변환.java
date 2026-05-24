class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return "";

        int idx = splitIndex(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);

        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();

            sb.append("(");
            sb.append(solution(v));
            sb.append(")");

            String mid = u.substring(1, u.length() - 1);

            for (char c : mid.toCharArray()) { // 뒤집어서
                sb.append(c == '(' ? ')' : '(');
            }

            return sb.toString();
        }
    }

    private int splitIndex(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right) {
                return i + 1;
            }
        }

        return s.length();
    }

    private boolean isCorrect(String s) { // 올바른 괄호 함수열인지 확인하는 함수
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else count--;

            if (count < 0) return false; // 중간에 음수가 되면 안된다
        }

        return count == 0;
    }
}
class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            StringBuilder sb = new StringBuilder();
            int count = 0;

            // 1. "110" 모두 제거
            for (char c : str.toCharArray()) {
                sb.append(c);
                int len = sb.length();

                if (len >= 3 &&
                    sb.charAt(len - 3) == '1' &&
                    sb.charAt(len - 2) == '1' &&
                    sb.charAt(len - 1) == '0') {
                    sb.delete(len - 3, len);
                    count++;
                }
            }

            // 2. 마지막 0 위치 찾기
            int idx = sb.lastIndexOf("0");

            // 3. 결과 문자열 만들기
            StringBuilder result = new StringBuilder();

            if (idx == -1) {
                // 0이 없으면 맨 앞에 삽입
                for (int j = 0; j < count; j++) {
                    result.append("110");
                }
                result.append(sb);
            } else {
                // 마지막 0 뒤에 삽입
                result.append(sb.substring(0, idx + 1));

                for (int j = 0; j < count; j++) {
                    result.append("110");
                }

                result.append(sb.substring(idx + 1));
            }

            answer[i] = result.toString();
        }

        return answer;
    }
}
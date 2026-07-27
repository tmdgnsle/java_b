class Solution {
    public String solution(String number, int k) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            // 아직 숫자를 제거할 수 있고,
            // 마지막에 저장한 숫자보다 현재 숫자가 크다면
            // 마지막 숫자를 제거한다.
            while (k > 0
                    && stack.length() > 0
                    && stack.charAt(stack.length() - 1) < current) {

                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(current);
        }

        // 숫자가 내림차순인 경우에는 while문에서 제거되지 않는다.
        // 예: "98765", k = 2
        // 이 경우 뒤쪽의 작은 숫자 2개를 제거한다.
        if (k > 0) {
            stack.setLength(stack.length() - k);
        }

        return stack.toString();
    }
}
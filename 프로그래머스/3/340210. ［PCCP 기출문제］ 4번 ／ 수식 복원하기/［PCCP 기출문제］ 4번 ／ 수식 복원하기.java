import java.util.*;

class Solution {

    public String[] solution(String[] expressions) {

        // 식에 등장하는 가장 큰 숫자
        int maxDigit = 0;

        for (String expression : expressions) {
            String[] parts = expression.split(" ");

            maxDigit = Math.max(maxDigit, getMaxDigit(parts[0]));
            maxDigit = Math.max(maxDigit, getMaxDigit(parts[2]));

            // 결과가 X가 아닌 경우에만 숫자 검사
            if (!parts[4].equals("X")) {
                maxDigit = Math.max(maxDigit, getMaxDigit(parts[4]));
            }
        }

        
        int minBase = Math.max(2, maxDigit + 1);

        // 가능한 진법들을 저장
        ArrayList<Integer> possibleBases = new ArrayList<>();

        for (int base = minBase; base <= 9; base++) {
            boolean possible = true;

            // 정답이 알려진 식들을 이용해 현재 진법이 가능한지 확인
            for (String expression : expressions) {
                String[] parts = expression.split(" ");

                // 결과가 X인 식은 진법 검증에 사용할 수 없음
                if (parts[4].equals("X")) {
                    continue;
                }

                int left = toDecimal(parts[0], base);
                int right = toDecimal(parts[2], base);
                int result = toDecimal(parts[4], base);

                int calculated;

                if (parts[1].equals("+")) {
                    calculated = left + right;
                } else {
                    calculated = left - right;
                }

                // 계산 결과가 맞지 않으면 불가능한 진법
                if (calculated != result) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                possibleBases.add(base);
            }
        }

        ArrayList<String> answer = new ArrayList<>();

        // X가 있는 식들의 결과 복원
        for (String expression : expressions) {
            String[] parts = expression.split(" ");

            if (!parts[4].equals("X")) {
                continue;
            }

            String commonResult = null;
            boolean same = true;

            // 가능한 모든 진법에서 식을 계산
            for (int base : possibleBases) {
                int left = toDecimal(parts[0], base);
                int right = toDecimal(parts[2], base);

                int calculated;

                if (parts[1].equals("+")) {
                    calculated = left + right;
                } else {
                    calculated = left - right;
                }

                // 계산 결과를 현재 진법 문자열로 변환
                String convertedResult = toBase(calculated, base);

                // 첫 번째 후보 진법의 결과 저장
                if (commonResult == null) {
                    commonResult = convertedResult;
                }
                // 진법에 따라 결과가 달라진다면 확정할 수 없음
                else if (!commonResult.equals(convertedResult)) {
                    same = false;
                    break;
                }
            }

            String result;

            if (same) {
                result = commonResult;
            } else {
                result = "?";
            }

            answer.add(
                parts[0] + " " +
                parts[1] + " " +
                parts[2] + " = " +
                result
            );
        }

        return answer.toArray(new String[0]);
    }

    
    private int getMaxDigit(String number) {
        int maxDigit = 0;

        for (int i = 0; i < number.length(); i++) {
            int digit = number.charAt(i) - '0';
            maxDigit = Math.max(maxDigit, digit);
        }

        return maxDigit;
    }

    
    private int toDecimal(String number, int base) {
        int result = 0;

        for (int i = 0; i < number.length(); i++) {
            int digit = number.charAt(i) - '0';

            result = result * base + digit;
        }

        return result;
    }

    
    private String toBase(int number, int base) {

        if (number == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while (number > 0) {
            result.append(number % base);
            number /= base;
        }

        // 나머지가 거꾸로 들어갔으므로 뒤집기
        return result.reverse().toString();
    }
}
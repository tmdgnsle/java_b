import java.util.*;
import java.util.function.Function;

class Solution {

    public int solution(int n, Function<Integer, String> submit) {

        ArrayList<Integer> candidates = new ArrayList<>();

        // 1~9 사이의 서로 다른 숫자 4개로 만들 수 있는 모든 비밀번호 후보 생성
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {

                        // 같은 숫자가 있으면 비밀번호 후보가 될 수 없음
                        if (a == b || a == c || a == d ||
                            b == c || b == d ||
                            c == d) {
                            continue;
                        }

                        int number = a * 1000 + b * 100 + c * 10 + d;
                        candidates.add(number);
                    }
                }
            }
        }

        // 후보가 하나 남을 때까지 질문
        while (candidates.size() > 1) {

            // 현재 후보들을 가장 잘 나눌 수 있는 숫자 선택
            int guess = getBestGuess(candidates);

            // 문제에서 제공하는 submit 함수 호출
            String result = submit.apply(guess);

            ArrayList<Integer> next = new ArrayList<>();

            // guess를 냈을 때 실제 결과와 같은 결과가 나오는 후보만 남김
            for (int candidate : candidates) {
                if (check(candidate, guess).equals(result)) {
                    next.add(candidate);
                }
            }

            candidates = next;
        }

        return candidates.get(0);
    }

    // 현재 후보들을 가장 균등하게 나누는 질문을 찾는 함수
    static int getBestGuess(ArrayList<Integer> candidates) {

        int bestGuess = candidates.get(0);
        int bestWorstCase = Integer.MAX_VALUE;

        for (int guess : candidates) {

            // resultCount[s][b]
            // guess를 냈을 때 s스트라이크 b볼이 나오는 후보 개수
            int[][] resultCount = new int[5][5];

            for (int candidate : candidates) {
                int[] sb = countStrikeBall(candidate, guess);

                int strike = sb[0];
                int ball = sb[1];

                resultCount[strike][ball]++;
            }

            // 이 guess를 냈을 때 최악의 경우 남는 후보 수
            int worstCase = 0;

            for (int s = 0; s <= 4; s++) {
                for (int b = 0; b <= 4; b++) {
                    worstCase = Math.max(worstCase, resultCount[s][b]);
                }
            }

            // 최악의 경우가 가장 작은 guess를 선택
            if (worstCase < bestWorstCase) {
                bestWorstCase = worstCase;
                bestGuess = guess;
            }
        }

        return bestGuess;
    }

    // answer가 실제 정답이고 guess를 제출했다고 가정했을 때 결과 문자열 반환
    static String check(int answer, int guess) {
        int[] sb = countStrikeBall(answer, guess);

        return sb[0] + "S " + sb[1] + "B";
    }

    // 스트라이크, 볼 개수 계산
    static int[] countStrikeBall(int answer, int guess) {

        String a = String.valueOf(answer);
        String g = String.valueOf(guess);

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 4; i++) {

            // 숫자와 위치가 모두 같으면 스트라이크
            if (a.charAt(i) == g.charAt(i)) {
                strike++;
            }

            // 숫자는 포함되어 있지만 위치가 다르면 볼
            else if (a.indexOf(g.charAt(i)) != -1) {
                ball++;
            }
        }

        return new int[]{strike, ball};
    }
}
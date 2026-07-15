import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        // 아직 사용하지 않은 사람 번호
        ArrayList<Integer> people = new ArrayList<>();

        // factorial[i] = i!
        long[] factorial = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            people.add(i);
            factorial[i] = factorial[i - 1] * i;
        }

        // 문제의 k는 1부터 시작하므로
        // 0부터 시작하는 인덱스로 변경
        k--;

        for (int i = 0; i < n; i++) {
            // 현재 자리에 한 숫자를 정하면
            // 남은 숫자들로 만들 수 있는 순열의 개수
            long groupSize = factorial[n - 1 - i];

            // 몇 번째 숫자를 골라야 하는지 계산
            int index = (int) (k / groupSize);

            answer[i] = people.get(index);

            // 사용한 숫자는 제거
            people.remove(index);

            // 선택한 그룹 내부에서 몇 번째인지 계산
            k %= groupSize;
        }

        return answer;
    }
}
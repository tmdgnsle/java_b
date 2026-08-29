import java.util.*;

class Solution {

    static int[][] dice;
    static int n;
    static long maxWin = -1;
    static int[] answer;

    public int[] solution(int[][] dice) {

        this.dice = dice;
        n = dice.length;

        // A가 가져갈 주사위 선택
        selectDice(0, 0, new int[n / 2]);

        return answer;
    }

    
    static void selectDice(int start, int depth, int[] selected) {

        if (depth == n / 2) {

            boolean[] isA = new boolean[n];

            for (int idx : selected) {
                isA[idx] = true;
            }

            int[] A = new int[n / 2];
            int[] B = new int[n / 2];

            int aIdx = 0;
            int bIdx = 0;

            for (int i = 0; i < n; i++) {

                if (isA[i]) {
                    A[aIdx++] = i;
                } else {
                    B[bIdx++] = i;
                }
            }

            
            List<Integer> sumA = new ArrayList<>();
            List<Integer> sumB = new ArrayList<>();

            makeSum(A, 0, 0, sumA);
            makeSum(B, 0, 0, sumB);

            Collections.sort(sumB);

            long win = 0;

            
            for (int a : sumA) {
                win += lowerBound(sumB, a);
            }

            if (win > maxWin) {

                maxWin = win;

                answer = new int[n / 2];

                for (int i = 0; i < n / 2; i++) {
                    answer[i] = A[i] + 1;
                }
            }

            return;
        }

        for (int i = start; i < n; i++) {

            selected[depth] = i;

            selectDice(i + 1, depth + 1, selected);
        }
    }

    
    static void makeSum(
            int[] selected,
            int depth,
            int sum,
            List<Integer> result
    ) {

        if (depth == selected.length) {
            result.add(sum);
            return;
        }

        int diceIdx = selected[depth];

        for (int num : dice[diceIdx]) {
            makeSum(
                    selected,
                    depth + 1,
                    sum + num,
                    result
            );
        }
    }

    // target보다 작은 값의 개수
    static int lowerBound(List<Integer> list, int target) {

        int left = 0;
        int right = list.size();

        while (left < right) {

            int mid = (left + right) / 2;

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
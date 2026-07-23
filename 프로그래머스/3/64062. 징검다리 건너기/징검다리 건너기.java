class Solution {

    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200_000_000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // mid명이 건널 수 있는 경우
            if (canCross(stones, k, mid)) {
                // 더 많은 사람도 가능한지 확인
                left = mid + 1;
            } else {
                // 사람이 너무 많으므로 줄이기
                right = mid - 1;
            }
        }

        // 마지막으로 건널 수 있었던 사람 수
        return right;
    }

    static boolean canCross(int[] stones, int k, int people) {
        int zeroCount = 0;

        for (int stone : stones) {

            /*
             * people번째 사람이 건널 때
             * stone < people이면 이 돌은 이미 사용할 수 없다.
             */
            if (stone < people) {
                zeroCount++;

                // 사용할 수 없는 돌이 k개 연속이면 건널 수 없음
                if (zeroCount >= k) {
                    return false;
                }
            } else {
                // 밟을 수 있는 돌을 만났으므로 연속 개수 초기화
                zeroCount = 0;
            }
        }

        return true;
    }
}
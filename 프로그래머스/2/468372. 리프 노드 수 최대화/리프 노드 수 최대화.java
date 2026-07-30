class Solution {

    static long answer;
    static int distLimit;
    static int splitLimit;

    public int solution(int dist_limit, int split_limit) {
        distLimit = dist_limit;
        splitLimit = split_limit;
        answer = 1;

        /*
         * cur   : 현재 깊이에 존재하는 노드 수
         * used  : 지금까지 사용한 분배 노드 수
         * split : 현재 깊이까지의 분배도
         * leaf  : 이전 깊이에서 이미 리프로 확정된 노드 수
         */
        dfs(1, 0, 1, 0);

        return (int) answer;
    }

    static void dfs(long cur, long used, long split, long leaf) {

        /*
         * 여기서 더 이상 분배하지 않는다면
         * 현재 깊이의 cur개 노드는 모두 리프가 된다.
         */
        answer = Math.max(answer, leaf + cur);

        // 앞으로 사용할 수 있는 분배 노드 수
        long remain = distLimit - used;

        // 분배 노드를 더 사용할 수 없다면 종료
        if (remain == 0) {
            return;
        }

        /*
         * 현재 노드 중 가능한 만큼 분배 노드로 사용한다.
         *
         * 분배 노드는 자식을 2개 또는 3개 만들어서
         * 리프 수를 증가시키므로, 가능한 많이 사용하는 것이 이득이다.
         */
        long distribute = Math.min(cur, remain);

        /*
         * 현재 노드 중 분배 노드로 사용하지 못한 노드는
         * 여기서 리프로 확정된다.
         */
        long nextLeaf = leaf + (cur - distribute);

        // 이번 깊이의 분배 노드 자식 수를 2개 또는 3개로 선택
        for (int child = 2; child <= 3; child++) {

            long nextSplit = split * child;

            // 분배도 제한을 넘으면 해당 선택은 불가능
            if (nextSplit > splitLimit) {
                continue;
            }

            /*
             * distribute개의 분배 노드가
             * 각각 child개의 자식 노드를 만든다.
             */
            long nextCur = distribute * child;

            dfs(
                nextCur,
                used + distribute,
                nextSplit,
                nextLeaf
            );
        }
    }
}
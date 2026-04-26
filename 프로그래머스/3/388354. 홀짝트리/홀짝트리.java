import java.util.*;

class Solution {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();

    public int[] solution(int[] nodes, int[][] edges) {
        for (int node : nodes) {
            graph.put(node, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int oddEvenTree = 0;
        int reverseOddEvenTree = 0;

        for (int node : nodes) {
            if (!visited.contains(node)) {
                int[] count = dfs(node);

                int same = count[0];
                int diff = count[1];

                if (same == 1) oddEvenTree++;
                if (diff == 1) reverseOddEvenTree++;
            }
        }

        return new int[]{oddEvenTree, reverseOddEvenTree};
    }

    static int[] dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited.add(start);

        int same = 0;
        int diff = 0;

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            int degree = graph.get(cur).size();

            if (cur % 2 == degree % 2) {
                same++;
            } else {
                diff++;
            }

            for (int next : graph.get(cur)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    stack.push(next);
                }
            }
        }

        return new int[]{same, diff};
    }
}
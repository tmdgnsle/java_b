import java.util.*;

class Solution {
    static Map<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String s : info) {
            String[] arr = s.split(" ");
            makeKey(arr, "", 0, Integer.parseInt(arr[4]));
        }

        for (ArrayList<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace(" and ", " ");
            String[] arr = q.split(" ");

            String key = arr[0] + arr[1] + arr[2] + arr[3];
            int score = Integer.parseInt(arr[4]);

            if (!map.containsKey(key)) {
                answer[i] = 0;
                continue;
            }

            ArrayList<Integer> scores = map.get(key);
            int idx = lowerBound(scores, score);
            answer[i] = scores.size() - idx;
        }

        return answer;
    }

    static void makeKey(String[] arr, String key, int depth, int score) {
        if (depth == 4) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(score);
            return;
        }

        makeKey(arr, key + arr[depth], depth + 1, score);
        makeKey(arr, key + "-", depth + 1, score);
    }

    static int lowerBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
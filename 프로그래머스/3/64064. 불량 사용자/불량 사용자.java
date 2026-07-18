import java.util.*;

class Solution {

    static String[] users;
    static String[] bans;
    static boolean[] visited;

    static HashSet<String> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        users = user_id;
        bans = banned_id;
        visited = new boolean[user_id.length];

        dfs(0);

        return result.size();
    }

    static void dfs(int idx) {

        if (idx == bans.length) {

            StringBuilder sb = new StringBuilder();

            // 선택된 사용자들을 문자열로 저장
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(i).append(",");
                }
            }

            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < users.length; i++) {

            if (visited[i]) continue;

            if (match(users[i], bans[idx])) {
                visited[i] = true;
                dfs(idx + 1);
                visited[i] = false;
            }
        }
    }

    static boolean match(String user, String ban) {

        if (user.length() != ban.length())
            return false;

        for (int i = 0; i < user.length(); i++) {

            if (ban.charAt(i) == '*')
                continue;

            if (user.charAt(i) != ban.charAt(i))
                return false;
        }

        return true;
    }
}
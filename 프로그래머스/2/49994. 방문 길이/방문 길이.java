import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();

        int x = 0;
        int y = 0;

        for (char d : dirs.toCharArray()) {
            int nx = x;
            int ny = y;

            if (d == 'U') ny++;
            else if (d == 'D') ny--;
            else if (d == 'R') nx++;
            else if (d == 'L') nx--;

            // 범위 벗어나면 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }

            // 정방향, 역방향 둘 다 저장
            String path1 = x + "," + y + "," + nx + "," + ny;
            String path2 = nx + "," + ny + "," + x + "," + y;

            set.add(path1);
            set.add(path2);

            // 위치 이동
            x = nx;
            y = ny;
        }

        return set.size() / 2;
    }
}
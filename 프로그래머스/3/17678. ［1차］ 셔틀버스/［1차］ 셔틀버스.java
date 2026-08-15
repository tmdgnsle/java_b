import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {

        int[] crew = new int[timetable.length];

        for (int i = 0; i < timetable.length; i++) {
            crew[i] = toMinute(timetable[i]);
        }

        Arrays.sort(crew);

        int idx = 0;
        int answer = 0;

        for (int bus = 0; bus < n; bus++) {

            int busTime = 540 + bus * t; // 09:00
            int count = 0;
            int lastCrew = -1;

            // 현재 버스에 크루 태우기
            while (idx < crew.length
                    && crew[idx] <= busTime
                    && count < m) {

                lastCrew = crew[idx];

                idx++;
                count++;
            }

            // 마지막 버스
            if (bus == n - 1) {

                // 자리가 남아있으면 버스 도착 시간에 오면 됨
                if (count < m) {
                    answer = busTime;
                }
                // 버스가 꽉 찼다면 마지막 탑승자보다 1분 일찍
                else {
                    answer = lastCrew - 1;
                }
            }
        }

        return toTime(answer);
    }

    static int toMinute(String time) {
        String[] split = time.split(":");

        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60 + minute;
    }

    static String toTime(int time) {
        int hour = time / 60;
        int minute = time % 60;

        return String.format("%02d:%02d", hour, minute);
    }
}
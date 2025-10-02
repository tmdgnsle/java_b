import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String target = normalize(m);

        String answer = "(None)";
        int maxPlayTime = -1;
        int bestIdx = Integer.MAX_VALUE; // 동률일 때 더 앞선 입력 유지용

        for (int idx = 0; idx < musicinfos.length; idx++) {
            String info = musicinfos[idx];
            String[] parts = info.split(",");
            String start = parts[0];
            String end   = parts[1];
            String title = parts[2];
            String melodyRaw = parts[3];

            int playTime = getPlayTime(start, end);
            String melody = normalize(melodyRaw);
            String played = getPlayedMelody(melody, playTime);

            if (played.contains(target)) {
                if (playTime > maxPlayTime || (playTime == maxPlayTime && idx < bestIdx)) {
                    maxPlayTime = playTime;
                    bestIdx = idx;
                    answer = title;
                }
            }
        }
        return answer;
    }

    // 샾 처리: 문자 스캔하며 '#'이면 직전 문자를 소문자로 교체
    private String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                // 직전 문자를 소문자로
                int last = sb.length() - 1;
                sb.setCharAt(last, Character.toLowerCase(sb.charAt(last)));
            } else {
                sb.append(ch); // A~G
            }
        }
        return sb.toString();
    }

    private int getPlayTime(String start, String end) {
        String[] a = start.split(":");
        String[] b = end.split(":");
        int s = Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
        int e = Integer.parseInt(b[0]) * 60 + Integer.parseInt(b[1]);
        return e - s;
    }

    private String getPlayedMelody(String melody, int playTime) {
        StringBuilder sb = new StringBuilder(playTime);
        int n = melody.length();
        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % n));
        }
        return sb.toString();
    }
}

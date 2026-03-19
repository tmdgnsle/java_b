import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        // a의 개수만큼의 구간에 있는 b의 개수 최소값
        
        // 전체 a의 개수 세기
        int aCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') aCount++;
        }

        // a가 0개이거나 전부 a면 바꿀 필요 없음
        if (aCount == 0 || aCount == n) {
            System.out.println(0);
            return;
        }

        // 처음 길이 aCount 구간에서 b 개수 세기
        int bCount = 0;
        for (int i = 0; i < aCount; i++) {
            if (s.charAt(i) == 'b') bCount++;
        }

        int answer = bCount;

        // 원형 슬라이딩 윈도우
        for (int i = 1; i < n; i++) {
            // 빠지는 문자
            if (s.charAt(i - 1) == 'b') bCount--;

            // 새로 들어오는 문자 (원형 처리)
            int nextIdx = (i + aCount - 1) % n;
            if (s.charAt(nextIdx) == 'b') bCount++;

            answer = Math.min(answer, bCount);
        }

        System.out.println(answer);
    }
}
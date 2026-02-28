import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int kind = 0;

        // 1️⃣ 처음 k개 세팅
        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) kind++;
            count[sushi[i]]++;
        }

        int answer = kind;
        if (count[c] == 0) answer++;

        // 2️⃣ 슬라이딩 윈도우
        for (int i = 1; i < N; i++) {
            // 왼쪽 제거
            int left = sushi[i - 1];
            count[left]--;
            if (count[left] == 0) kind--;

            // 오른쪽 추가 (원형 처리)
            int right = sushi[(i + k - 1) % N];
            if (count[right] == 0) kind++;
            count[right]++;

            int temp = kind;
            if (count[c] == 0) temp++;

            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}
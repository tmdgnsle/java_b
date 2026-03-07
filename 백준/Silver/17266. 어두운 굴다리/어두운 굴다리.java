import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] lights = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        // 왼쪽 끝
        answer = Math.max(answer, lights[0]);

        // 가로등 사이
        for (int i = 1; i < M; i++) {
            int dist = lights[i] - lights[i - 1];
            answer = Math.max(answer, (dist + 1) / 2); // 올림
        }

        // 오른쪽 끝
        answer = Math.max(answer, N - lights[M - 1]);

        System.out.println(answer);
    }
}
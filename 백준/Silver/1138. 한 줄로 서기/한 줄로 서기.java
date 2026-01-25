import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[N + 1];
        for (int i = 1; i <= N; i++) a[i] = Integer.parseInt(st.nextToken());

        int[] line = new int[N]; // 0이면 빈칸

        for (int h = 1; h <= N; h++) {
            int need = a[h];     // 왼쪽에 있어야 하는 '더 큰 사람' 수
            int emptyCount = 0;

            for (int pos = 0; pos < N; pos++) {
                if (line[pos] == 0) {
                    if (emptyCount == need) {
                        line[pos] = h;
                        break;
                    }
                    emptyCount++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(line[i]);
            if (i + 1 < N) sb.append(' ');
        }
        System.out.println(sb);
    }
}
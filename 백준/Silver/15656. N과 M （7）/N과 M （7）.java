//  N과 M (7)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static ArrayList<Integer> result;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        result = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        bt();

        System.out.println(sb);
    }

    static void bt() {
        if (result.size() == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            result.add(numbers[i]);
            bt();
            result.remove(result.size() - 1);
        }
    }

}
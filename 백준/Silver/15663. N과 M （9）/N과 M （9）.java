//  N과 M (9)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] numbers;
    static boolean[] v;
//    static ArrayList<String> answer;
    static LinkedHashSet<String> answer;
    static ArrayList<Integer> result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        result = new ArrayList<Integer>();
        v = new boolean[N];
//        answer = new ArrayList<String>();
        answer = new LinkedHashSet<String>();

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        bt();

        for (String s : answer) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

    }

    static void bt() {
        if (result.size() == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result.get(i)).append(" ");
            }
//            if(!answer.contains(sb.toString())){
//                answer.add(sb.toString());
//            }
            answer.add(sb.toString());
            sb = new StringBuilder();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                result.add(numbers[i]);
                bt();
                v[i] = false;
                result.remove(result.size() - 1);
            }
        }

    }

}
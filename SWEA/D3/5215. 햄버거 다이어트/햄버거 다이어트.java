import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<int[]> ingredient;
    static int N, L;
    static boolean[] v;
    static int max;

    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("res/input_5215.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            ingredient = new ArrayList<>();
            v = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                ingredient.add(new int[]{p1, p2});
            }

            bt(0, 0, 0);

            System.out.println("#" + t + " " + max);


        }
    }

    static void bt(int start, int taste, int cal) {
        for (int i = start; i < N; i++) {
            if (!v[i]) {
                int n_cal = cal + ingredient.get(i)[1];
                int n_taste = taste + ingredient.get(i)[0];
                if (n_cal <= L) {
                    if (n_taste > max) max = n_taste;
                    v[i] = true;
                    bt(i, n_taste, n_cal);
                    v[i] = false;
                }
            }
        }

    }

}
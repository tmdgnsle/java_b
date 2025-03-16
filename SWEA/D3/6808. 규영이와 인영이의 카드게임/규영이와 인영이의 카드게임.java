import java.io.*;
import java.util.*;

public class Solution {
    static int[] num;
    static boolean[] my;
    static ArrayList<Integer> arr;
    static ArrayList<Integer> your;
    static boolean[] v;
    static int win, lose;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input_6808.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            my = new boolean[19];
            num = new int[9];
            arr = new ArrayList<>();
            your = new ArrayList<>();
            v = new boolean[9];
            win = 0;
            lose = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                num[i] = Integer.parseInt(st.nextToken());
                my[num[i]] = true;
            }
            for (int i = 1; i <= 18; i++) {
                if (!my[i]) your.add(i);
            }


            bt();

            System.out.println("#" + t + " " + win + " " + lose);

        }
    }

    static void bt() {
        if (arr.size() == 9) {
            calculate();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!v[i]) {
                v[i] = true;
                arr.add(your.get(i));
                bt();
                v[i] = false;
                arr.remove(arr.size() - 1);
            }
        }
    }

    static void calculate() {
        int me = 0;
        int you = 0;
        for (int i = 0; i < 9; i++) {
            int diff = num[i] - arr.get(i);
            if (diff > 0) {
                me += num[i] + arr.get(i);
            }
            if (diff < 0) {
                you += num[i] + arr.get(i);
            }
        }

        if (me > you) {
            win++;
        }
        if (you > me) {
            lose++;
        }

    }

}
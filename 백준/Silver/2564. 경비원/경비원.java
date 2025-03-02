//  경비원

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static ArrayList<int[]> arr;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        result = 0;
        for (int i = 0; i < K + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            findPos(dir, pos);
        }

        findSum();

        System.out.println(result);

    }

    static void findSum() {
        int[] current = arr.get(arr.size() - 1);
        int ci = current[0];
        int cj = current[1];
        int cdir = current[2];

        for (int i = 0; i < arr.size() - 1; i++) {
            int[] market = arr.get(i);
            int mi = market[0];
            int mj = market[1];
            int mdir = market[2];

            if ((cdir == 1 && mdir == 2) || (cdir == 2 && mdir == 1)) {
                int cleft = cj;
                int cright = N - cj;
                int mleft = mj;
                int mright = N - mj;
                int small = Math.min(cleft + mleft, cright + mright);
                int distance = small + M;
                result += distance;

            } else if ((cdir == 3 && mdir == 4) || (cdir == 4 && mdir == 3)) {
                int cup = ci;
                int cdown = M - ci;
                int mup = mi;
                int mdown = M - mi;
                int small = Math.min(cup + mup, cdown + mdown);
                int distance = small + N;
                result += distance;

            } else {

                int distance = Math.abs(ci - mi) + Math.abs(cj - mj);
                result += distance;

            }


        }


    }

    static void findPos(int dir, int pos) {
        switch (dir) {
            case 1:
                arr.add(new int[]{0, pos, dir});
                break;
            case 2:
                arr.add(new int[]{M, pos, dir});
                break;
            case 3:
                arr.add(new int[]{pos, 0, dir});
                break;
            case 4:
                arr.add(new int[]{pos, N, dir});
                break;
        }
    }
}
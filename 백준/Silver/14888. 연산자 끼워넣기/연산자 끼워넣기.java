import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    static int[] oper;
    static int N;

    static int max_result;
    static int min_result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        oper = new int[4];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        max_result = Integer.MIN_VALUE;
        min_result = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        bt(nums[0], -1, 1);

        System.out.println(max_result);
        System.out.println(min_result);


    }

    static void bt(int current, int index, int num_index) {
        if (num_index == nums.length) {

            min_result = Math.min(min_result, current);
            max_result = Math.max(max_result, current);
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                if (oper[i] != 0) {
                    oper[i]--;
                    bt(calculate(i, num_index, current), i, num_index + 1);
                    oper[i]++;
                }
            }
        }
    }

    static int calculate(int index, int num_index, int current) {
        int temp = 0;
        switch (index) {
            case 0:
                temp = current + nums[num_index];
                break;
            case 1:
                temp = current - nums[num_index];
                break;
            case 2:
                temp = current * nums[num_index];
                break;
            case 3:
                temp = current / nums[num_index];
                break;
        }

        return temp;
    }
}
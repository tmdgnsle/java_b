import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("res/input_3263.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int[] maxLength = new int[N+1];
            int maxResult = 0;

            for (int i = 0; i < N; i++) {
                int num = nums[i];
                maxLength[num] = Math.max(maxLength[num-1]+1, maxLength[num]);
                maxResult = Math.max(maxLength[num], maxResult);
            }

            System.out.println("#" + t + " " + (N - maxResult));


        }
    }
}
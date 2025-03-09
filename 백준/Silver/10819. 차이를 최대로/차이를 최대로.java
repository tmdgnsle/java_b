import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    static boolean[] v;
    static ArrayList<Integer> arr;
    static int N;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        v = new boolean[N];
        arr = new ArrayList<>();
        result = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        bt();

        System.out.println(result);

    }

    static void bt(){
        if(arr.size() == N){
            solve();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!v[i]){
                v[i] = true;
                arr.add(nums[i]);
                bt();
                v[i] = false;
                arr.remove(arr.size()-1);
            }
        }

    }

    static void solve(){
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            int temp = Math.abs(arr.get(i) - arr.get(i+1));
            sum += temp;
        }

        result = Math.max(result, sum);
    }
}
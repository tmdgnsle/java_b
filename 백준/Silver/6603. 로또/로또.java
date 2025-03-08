import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(true){
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            nums = new int[N];
            arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            bt(0);
            System.out.println();
            st = new StringTokenizer(br.readLine());
        }
    }

    static void bt(int start){
        if(arr.size() == 6){
            for (int i = 0; i < 6; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            arr.add(nums[i]);
            bt(i+1);
            arr.remove(arr.size() - 1);
        }
    }
}
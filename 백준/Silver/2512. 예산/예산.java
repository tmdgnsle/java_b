import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] moneys = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max_money = Integer.MIN_VALUE;
        int money_sum = 0;
        for (int i = 0; i < N; i++) {
            moneys[i] = Integer.parseInt(st.nextToken());
            max_money = Math.max(max_money, moneys[i]);
            money_sum += moneys[i];
        }

        int total_money = Integer.parseInt(br.readLine());

        if(money_sum <= total_money){
            System.out.println(max_money);
            return;
        }

        int left = 1;
        int right = max_money;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int money : moneys) {
                sum += Math.min(money, mid);
            }

            if (sum <= total_money) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);


    }
}
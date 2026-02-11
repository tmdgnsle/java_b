import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] num = new int[str.length()];
            for(int i = 0; i<str.length(); i++){
                char first = str.charAt(i);
                int count = 1;
                for(int j = i+1; j<str.length(); j++) {
                    char second = str.charAt(j);
                    if (first == second) {
                        count++;
                        if (count == K) {
                            num[i] = j - i + 1;
                            break;
                        }
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<str.length(); i++){
                if(num[i] == 0) continue;
                min = Math.min(min, num[i]);
                max = Math.max(max, num[i]);
            }

            if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) System.out.println(-1);
            else System.out.println(min + " " + max);
        }
    }
}
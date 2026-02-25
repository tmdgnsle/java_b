import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static int[] x;

    static boolean canInstall(int dist) {
        int count = 1;          
        int last = x[0];

        for (int i = 1; i < N; i++) {
            if (x[i] - last >= dist) {
                count++;
                last = x[i];
                if (count >= C) return true; 
            }
        }
        return count >= C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        x = new int[N];
        for (int i = 0; i < N; i++) x[i] = Integer.parseInt(br.readLine());

        Arrays.sort(x);

        int low = 1;
        int high = x[N - 1] - x[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (canInstall(mid)) {
                ans = mid;
                low = mid + 1;   
            } else {
                high = mid - 1;  
            }
        }

        System.out.println(ans);
    }
}
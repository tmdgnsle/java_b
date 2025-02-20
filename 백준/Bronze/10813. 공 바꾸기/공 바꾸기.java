

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            basket[i] = i;
        }

        for (int x = 0; x < M; x++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int temp = basket[i];
            basket[i] = basket[j];
            basket[j] = temp;
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.print(basket[i] + " ");
        }
        System.out.println();

    }
}

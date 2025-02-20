

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] stars = new boolean[N][N];

        for (int i = N-1; i >= 0; i--) {
            for (int j = N-i-1; j <N; j++) {
                stars[i][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!stars[i][j]){
                    System.out.print(" ");
                } else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<= T; t++){
            String s = br.readLine();
            int score = 0;
            int total = 0;

            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'X'){
                    score = 0;
                } else {
                    total += ++score;
                }
            }

            System.out.println(total);
        }
    }
}

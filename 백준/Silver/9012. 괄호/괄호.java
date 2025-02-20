

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<= T; t++){
            String s = br.readLine();
            int left = 0;
            int right = 0;

            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '('){
                    left++;
                } else if (s.charAt(i) == ')'){
                    right++;
                }
                if(left < right){
                    break;
                }
            }

            if(left == right){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

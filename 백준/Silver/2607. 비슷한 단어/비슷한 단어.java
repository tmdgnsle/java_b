import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;


        int[] alpha = new int[26];
        String str = br.readLine();
        for(char c: str.toCharArray()){
            int idx = c - 'A';
            alpha[idx]++;
        }
        int length = str.length();

        for(int i = 0; i<N-1; i++){
            int[] targetAlpha = new int[26];
            String target = br.readLine();
            int targetLength = target.length();
            if(Math.abs(length - targetLength) >= 2) continue;
            for(char c: target.toCharArray()){
                int idx = c - 'A';
                targetAlpha[idx]++;
            }

            int diff = 0;

            for(int j = 0; j<26; j++){
                diff += Math.abs(targetAlpha[j] - alpha[j]);
            }

            if(diff <= 2) answer++;

        }
        System.out.println(answer);
    }
}
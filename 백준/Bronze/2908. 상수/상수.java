

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        String a=""; String b = "";
        for (int i = input[0].length()-1; i >= 0; i--) {
            a += input[0].charAt(i);
        }

        for (int i = input[1].length()-1; i >= 0; i--) {
            b += input[1].charAt(i);
        }

        System.out.println(Math.max(Integer.parseInt(a), Integer.parseInt(b)));
    }
}

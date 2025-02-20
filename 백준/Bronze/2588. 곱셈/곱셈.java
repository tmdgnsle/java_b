

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        String[] b = br.readLine().split("");

        System.out.println(a * Integer.parseInt(b[2]));
        System.out.println(a * Integer.parseInt(b[1]));
        System.out.println(a * Integer.parseInt(b[0]));
        System.out.println(a * Integer.parseInt(b[2]) + a * Integer.parseInt(b[1]) * 10 + a * Integer.parseInt(b[0]) * 100);
    }
}

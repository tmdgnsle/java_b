import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int p3 = Integer.parseInt(st.nextToken());
            if(p1 == 0 && p2 == 0 && p3 == 0) break;

            int[] p = new int[]{p1, p2, p3};
            Arrays.sort(p);

            p1 = p[0];
            p2 = p[1];
            p3 = p[2];

            if(p1 + p2 <= p3){
                System.out.println("Invalid");
                continue;
            }

            if(p1 == p2 && p2 == p3){
                System.out.println("Equilateral");
                continue;
            }

            if(p1 == p2 || p2 == p3){
                System.out.println("Isosceles");
                continue;
            }

            System.out.println("Scalene");

        }
    }
}
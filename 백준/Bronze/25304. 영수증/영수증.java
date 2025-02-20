

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int total = Integer.parseInt(br.readLine());
        int item = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < item; i++) {
            st = new StringTokenizer(br.readLine());
            
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            
            total -= price * count;
        }
        
        if(total == 0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

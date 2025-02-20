

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int hour = Integer.parseInt(input[0]);
        int minute = Integer.parseInt(input[1]);

        if (minute < 45){
            if(hour == 0){
                hour = 23;
            } else {
                hour -= 1;
            }
            minute = 60 - (45 - minute);
        } else {
            minute -= 45;
        }

        System.out.println(hour + " " + minute);
    }
}

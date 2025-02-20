

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int time = Integer.parseInt(br.readLine());

        int hour = Integer.parseInt(input[0]);
        int minute = Integer.parseInt(input[1]);


        if (minute + time > 60) {
            if (hour == 23) {
                hour = 0;
            } else {
                hour += 1;
            }
            minute = (time + minute) - 60;
        } else {
            minute += time;
        }

        while(minute >= 60){
            if(hour == 23){
                hour = 0;
            } else {
                hour += 1;
            }
            minute -= 60;
        }

        System.out.println(hour + " " + minute);
    }
}

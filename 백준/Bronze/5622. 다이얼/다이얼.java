

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cha = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        String dial = br.readLine();

        int time = 0;

        for (int i = 0; i < dial.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if(cha[j].contains(""+dial.charAt(i))){
                    time += j + 1;
                }
            }
        }

        System.out.println(time);
    }
}

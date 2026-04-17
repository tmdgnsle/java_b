import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int count0 = 0;
        int count1 = 0;

        for(char c: str){
            if(c == '0') count0++;
            if(c == '1') count1++;
        }

        count1 /= 2;
        count0 /= 2;

        for(int i = 0; i<str.length; i++){
            if(str[i] == '1'){
                str[i] = '.';
                if(--count1 == 0) break;
            }
        }

        for(int i = str.length - 1; i>=0; i--){
            if(str[i] == '0'){
                str[i] = '.';
                if(--count0 == 0) break;
            }
        }

        StringBuilder answer = new StringBuilder();

        for(int i = 0; i<str.length; i++){
            if(str[i] != '.') answer.append(str[i]);
        }
        System.out.println(answer);

    }
}
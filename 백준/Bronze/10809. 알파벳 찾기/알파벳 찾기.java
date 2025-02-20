

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] position = new int[26];
        String word = br.readLine();
        for (int i = 0; i < 26; i++){
            position[i] = -1;
        }

        for (int i = 0; i < word.length(); i++) {
            if(position[word.charAt(i) - 97] == -1){
                position[word.charAt(i) - 97] = i;
            }
        }

        for (int i: position){
            System.out.print(i + " ");
        }


    }
}

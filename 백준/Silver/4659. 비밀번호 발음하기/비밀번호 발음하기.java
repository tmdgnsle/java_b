import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;

            if (isAcceptable(s)) {
                sb.append("<").append(s).append("> is acceptable.\n");
            } else {
                sb.append("<").append(s).append("> is not acceptable.\n");
            }
        }

        System.out.print(sb.toString());
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static boolean isAcceptable(String s) {
        boolean hasVowel = false;
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            
            if (isVowel(c)) {
                hasVowel = true;
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }

            
            if (vowelCount == 3 || consonantCount == 3) {
                return false;
            }

            
            if (i > 0) {
                char prev = s.charAt(i - 1);
                if (c == prev && c != 'e' && c != 'o') {
                    return false;
                }
            }
        }

        
        if (!hasVowel) {
            return false;
        }

        return true;
    }
}
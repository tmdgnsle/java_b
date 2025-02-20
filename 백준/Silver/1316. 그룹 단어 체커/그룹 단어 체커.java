
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            HashSet<Character> ch = new HashSet<>();
            boolean noRepeat = true;
            char before = 0;
            for (int j = 0; j < word.length(); j++) {
                if(j == 0){
                    ch.add(word.charAt(j));
                    before = word.charAt(j);
                } else {
                    if(before != word.charAt(j)){
                        if(ch.contains(word.charAt(j))){
                            noRepeat = false;
                            break;
                        } else {
                            ch.add(word.charAt(j));
                            before = word.charAt(j);
                        }
                    }

                }

            }
            if(noRepeat) count++;
        }

        System.out.println(count);
    }
}

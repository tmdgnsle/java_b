import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        String key = br.readLine();
        boolean[] alph = new boolean[26];
        alph[9] = true; // J
        char[][] table = new char[5][5];
        int x = 0;
        int y = 0;
        for(char c: key.toCharArray()){
            int idx = c - 65;
            if(alph[idx]) continue;
            table[x][y] = c;
            alph[idx] = true;
            y++;
            if(y >= 5){
                x++;
                y = 0;
            }

        }

        int idx = 0;
        for(int i = 0; i<26; i++){
            if(!alph[i]){
                idx = i;
                break;
            }
        }

        while(x < 5){
            table[x][y] = (char)(idx + 65);
            alph[idx] = true;
            y++;
            if(y >=5){
                x++;
                y = 0;
            }
            while (idx < 26 && alph[idx]) idx++;
        } // 키 테이블 세팅 끝

        int[] row = new int[26];
        int[] col = new int[26];

        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                int num = table[i][j] - 65;
                row[num] = i;
                col[num] = j;
            }
        } // 매번 table 안돌아다니도록 저장

        ArrayList<String> pairs = new ArrayList<>();
        for(int i = 0; i<msg.length(); i++){
            char a = msg.charAt(i);

            if(i == msg.length() - 1){
                pairs.add("" + a + "X");
            } else {
                char b = msg.charAt(i+1);
                if(a == b){
                    if(a == 'X'){
                        pairs.add("" + a + "Q");
                    }else {
                        pairs.add("" + a + "X");
                    }
                }else {
                    pairs.add("" + a + b);
                    i++;
                }
            }
        } // 두글자씩 묶음

        StringBuilder sb = new StringBuilder();
        for(String p: pairs){
            char a = p.charAt(0);
            char b = p.charAt(1);

            int ra = row[a - 65];
            int ca = col[a - 65];
            int rb = row[b - 65];
            int cb = col[b - 65];

            if(ra == rb){
                sb.append(table[ra][(ca + 1) % 5]);
                sb.append(table[rb][(cb + 1) % 5]);
            }else if(ca == cb){
                sb.append(table[(ra + 1) % 5][ca]);
                sb.append(table[(rb + 1) % 5][cb]);
            }else {
                sb.append(table[ra][cb]);
                sb.append(table[rb][ca]);
            }
        }

        System.out.println(sb);
        

    }
}
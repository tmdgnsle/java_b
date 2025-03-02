//  킹

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] chess;
    static int Ki, Kj, Di, Dj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //65
        StringTokenizer st = new StringTokenizer(br.readLine());
        chess = new int[8][8];
        String king = st.nextToken();
        Ki = Integer.parseInt(king.charAt(1) + "");
        Ki = 8 - Ki;
        Kj = (int) king.charAt(0) - 65;
        chess[Ki][Kj] = 1;

        String dol = st.nextToken();
        Di = Integer.parseInt(dol.charAt(1) + "");
        Di = 8 - Di;
        Dj = (int) dol.charAt(0) - 65;
        chess[Di][Dj] = 2;

        int N = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            move(key);
        }


        king = (char) (Kj + 65) + "" + (8 - Ki);
        dol = (char) (Dj + 65) + "" + (8 - Di);

        System.out.println(king);
        System.out.println(dol);

    }

    static void move(String key) {
        int dx = 0;
        int dy = 0;
        switch (key) {
            case ("R"):
                dy = 1;
                break;
            case ("L"):
                dy = -1;
                break;
            case ("B"):
                dx = 1;
                break;
            case ("T"):
                dx = -1;
                break;
            case ("RT"):
                dy = 1;
                dx = -1;
                break;
            case ("LT"):
                dy = -1;
                dx = -1;
                break;
            case ("RB"):
                dy = 1;
                dx = 1;
                break;
            case ("LB"):
                dy = -1;
                dx = 1;
                break;
        }

        int Knx = Ki + dx;
        int Kny = Kj + dy;

        if (Knx >= 0 && Knx < 8 && Kny >= 0 && Kny < 8) {
            if (chess[Knx][Kny] == 2) {
                int Dnx = Di + dx;
                int Dny = Dj + dy;

                if (Dnx >= 0 && Dnx < 8 && Dny >= 0 && Dny < 8) {
                    chess[Ki][Kj] = 0;
                    chess[Di][Dj] = 0;

                    Di = Dnx;
                    Dj = Dny;
                    Ki = Knx;
                    Kj = Kny;

                    chess[Ki][Kj] = 1;
                    chess[Di][Dj] = 2;
                }
            } else {
                chess[Ki][Kj] = 0;

                Ki = Knx;
                Kj = Kny;
                chess[Ki][Kj] = 1;
            }
        }


    }

}
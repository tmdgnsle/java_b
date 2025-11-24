import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] square = new char[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                square[i][j] = str.charAt(j - 1);
            }
        }


        int headX = 0;
        int headY = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (square[i][j] == '*') {
                    headX = i;
                    headY = j;

                    break;
                }
            }
            if (headX != 0 && headY != 0) break;
        }
        int heartX = headX + 1;
        int heartY = headY;
        System.out.println(heartX + " " + heartY);

        int leftHand = 0;
        int rightHand = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        int mid = 0;
        for (int i = heartY - 1; i > 0; i--) {
            if (square[heartX][i] == '*') leftHand++;
            else break;
        }
        for (int i = heartY + 1; i <= N; i++) {
            if (square[heartX][i] == '*') rightHand++;
            else break;
        }
        int betweenX = 0;
        int betweenY = heartY;
        for (int i = heartX + 1; i <= N; i++) {
            if (square[i][heartY] == '*') mid++;
            else {
                betweenX = i;
                break;
            }
        }

        for (int i = betweenX; i <= N; i++) {
            if (square[i][betweenY - 1] == '*') leftLeg++;
            else break;
        }

        for (int i = betweenX; i <= N; i++) {
            if (square[i][betweenY + 1] == '*') rightLeg++;
            else break;
        }

        System.out.println(leftHand + " " + rightHand + " " + mid + " " + leftLeg + " " + rightLeg);


    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int R = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[R][C];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        
        int count = 1;
        int cx = R - 1;
        int cy = 0;
        int targetX = cx;
        int targetY = cy;
        int dir = 0;
        arr[cx][cy] = count;
        
        

        if(K > R*C){
            System.out.println(0);
            return;
        }


        while (count != K) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            if(nx < 0 || ny < 0 || nx >= R || ny >=C || arr[nx][ny]!=0){
                dir = (dir+1) %4;
                nx = cx + dx[dir];
                ny = cy + dy[dir];
            }

            arr[nx][ny] = ++count;
            if(count == K){
                targetX = nx;
                targetY = ny;
            }
            cx = nx;
            cy = ny;


        }

        targetX = R - targetX;
        targetY += 1;

        System.out.println(targetY + " " + targetX);


    }
}
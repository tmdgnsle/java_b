import java.io.*;
import java.util.*;

public class Main {
    static int[][] gears = new int[4][8]; // 4개의 톱니바퀴, 각 8개의 톱니
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 톱니바퀴 상태 입력 받기
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = line.charAt(j) - '0';
            }
        }
        
        // 회전 횟수 입력 받기
        int K = Integer.parseInt(br.readLine());
        
        // K번 회전 실행
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1; // 0-based 인덱스로 변환
            int direction = Integer.parseInt(st.nextToken()); // 1: 시계방향, -1: 반시계방향
            
            // 각 톱니바퀴의 회전 방향 결정 (왼쪽, 오른쪽으로 전파)
            int[] rotations = new int[4];
            rotations[gearNum] = direction;
            
            // 왼쪽으로 전파
            for (int j = gearNum; j > 0; j--) {
                if (gears[j][6] != gears[j-1][2]) { // 맞닿은 부분이 다른 극이면
                    rotations[j-1] = -rotations[j]; // 반대 방향으로 회전
                } else {
                    break; // 같은 극이면 더 이상 회전하지 않음
                }
            }
            
            // 오른쪽으로 전파
            for (int j = gearNum; j < 3; j++) {
                if (gears[j][2] != gears[j+1][6]) { // 맞닿은 부분이 다른 극이면
                    rotations[j+1] = -rotations[j]; // 반대 방향으로 회전
                } else {
                    break; // 같은 극이면 더 이상 회전하지 않음
                }
            }
            
            // 모든 톱니바퀴 회전
            for (int j = 0; j < 4; j++) {
                if (rotations[j] != 0) {
                    rotate(j, rotations[j]);
                }
            }
        }
        
        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == 1) { // 12시 방향이 S극(1)이면
                score += (1 << i); // 2^i 점 획득 (1, 2, 4, 8)
            }
        }
        
        System.out.println(score);
    }
    
    // 톱니바퀴 회전
    static void rotate(int gearNum, int direction) {
        if (direction == 1) { // 시계 방향
            int temp = gears[gearNum][7];
            for (int i = 7; i > 0; i--) {
                gears[gearNum][i] = gears[gearNum][i-1];
            }
            gears[gearNum][0] = temp;
        } else { // 반시계 방향
            int temp = gears[gearNum][0];
            for (int i = 0; i < 7; i++) {
                gears[gearNum][i] = gears[gearNum][i+1];
            }
            gears[gearNum][7] = temp;
        }
    }
}
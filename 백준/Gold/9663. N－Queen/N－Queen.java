import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static int[] col;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        col = new int[N + 1];
        
        // 첫 번째 행부터 시작
        setQueen(1);
        
        System.out.println(count);
    }
    
    // 해당 위치에 퀸을 놓을 수 있는지 확인
    public static boolean isPossible(int row) {
        for (int i = 1; i < row; i++) {
            // 같은 열에 퀸이 있는 경우
            if (col[i] == col[row]) {
                return false;
            }
            
            // 대각선에 퀸이 있는 경우
            // 두 퀸이 대각선에 위치하는 경우는 행의 차이와 열의 차이가 같은 경우
            if (Math.abs(row - i) == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    // row 행에 퀸을 놓는 함수
    public static void setQueen(int row) {
        if (row > N) {
            // N개의 퀸을 모두 놓은 경우 카운트 증가
            count++;
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            col[row] = i; // row 행, i 열에 퀸을 놓음
            
            // 퀸을 놓을 수 있는지 확인
            if (isPossible(row)) {
                // 다음 행으로 진행
                setQueen(row + 1);
            }
            // 조건을 만족하지 않는 경우 다음 열로 이동
        }
    }
}
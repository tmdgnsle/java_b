import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    // 상, 우, 하, 좌 방향 (시계 방향)
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    
    static int N; // 보드의 크기
    static int[][] board; // 보드 (0: 빈칸, 1: 뱀, 2: 사과)
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 보드의 크기
        board = new int[N + 1][N + 1]; // 1부터 시작하는 인덱스 사용
        
        int K = Integer.parseInt(br.readLine()); // 사과의 개수
        
        // 사과 위치 입력
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 2; // 사과 위치 표시
        }
        
        int L = Integer.parseInt(br.readLine()); // 방향 변환 횟수
        
        // 방향 변환 정보 저장
        Map<Integer, Character> directionChanges = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            directionChanges.put(time, direction);
        }
        
        System.out.println(playGame(directionChanges));
        br.close();
    }
    
    // 게임 진행 함수
    private static int playGame(Map<Integer, Character> directionChanges) {
        // 뱀의 위치를 저장하는 덱 (머리가 맨 앞, 꼬리가 맨 뒤)
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{1, 1}); // 시작 위치 (1,1)
        board[1][1] = 1; // 뱀 위치 표시
        
        int direction = 1; // 초기 방향은 오른쪽 (우측)
        int time = 0; // 게임 진행 시간
        
        while (true) {
            time++; // 시간 증가
            
            // 뱀의 머리 위치
            int[] head = snake.peekFirst();
            
            // 다음 위치 계산
            int nx = head[0] + dx[direction];
            int ny = head[1] + dy[direction];
            
            // 벽이나 자기 자신과 부딪히는 경우 게임 종료
            if (nx < 1 || nx > N || ny < 1 || ny > N || board[nx][ny] == 1) {
                break;
            }
            
            // 사과가 있는 경우
            boolean eatApple = false;
            if (board[nx][ny] == 2) {
                eatApple = true;
            }
            
            // 뱀 머리 이동
            snake.addFirst(new int[]{nx, ny});
            board[nx][ny] = 1;
            
            // 사과가 없는 경우 꼬리 제거
            if (!eatApple) {
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }
            
            // 방향 전환 확인
            if (directionChanges.containsKey(time)) {
                char changeDir = directionChanges.get(time);
                
                // 'L'이면 왼쪽으로 90도, 'D'이면 오른쪽으로 90도 회전
                if (changeDir == 'L') {
                    direction = (direction + 3) % 4; // 왼쪽으로 90도 회전
                } else if (changeDir == 'D') {
                    direction = (direction + 1) % 4; // 오른쪽으로 90도 회전
                }
            }
        }
        
        return time;
    }
}
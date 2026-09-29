import java.util.*;



class Solution {
    static int N;
static int[][] map;

static class Robot{
    int x1, y1;
    int x2, y2;
    int time;
    
    Robot(int x1, int y1, int x2, int y2, int time){
        //좌표 순서 일정하게 맞춤
        if(x1 > x2 || (x1 == x2 && y1 > y2)){
            int tx = x1;
            int ty = y1;
            
            x1 = x2;
            y1 = y2;
            
            x2 = tx;
            y2 = ty;
        }
        
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.time = time;
    }
    
    String key(){
        return x1 + "," + y1 + "," + x2 + "," + y2;
    }
}
    public int solution(int[][] board) {
        N = board.length;
        
        map = new int[N+2][N+2]; // 바깥에 벽 세움
        
        for(int i = 0; i<N+2; i++){
            Arrays.fill(map[i], 1);
        }
        
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                map[i+1][j+1] = board[i][j];
            }
        }
        
        Queue<Robot> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        Robot start = new Robot(1, 1, 1, 2, 0);
        
        q.offer(start);
        visited.add(start.key());
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()){
            Robot cur = q.poll();
            
            if((cur.x1 == N && cur.y1 == N) || cur.x2 == N && cur.y2 == N){
                return cur.time;
            }
            
            // 상하좌우
            for(int d = 0; d<4; d++){
                int nx1 = cur.x1 + dx[d];
                int ny1 = cur.y1 + dy[d];
                
                int nx2 = cur.x2 + dx[d];
                int ny2 = cur.y2 + dy[d];
                
                if(map[nx1][ny1] == 0 && map[nx2][ny2] == 0){
                    Robot next = new Robot(nx1, ny1, nx2, ny2, cur.time+1);
                    
                    if(visited.add(next.key())){ // set에 이미 있을 때는 false 반환
                        q.offer(next);
                    }
                }
            }
            
            // 회전
            
            //가로
            if(cur.x1 == cur.x2){
                for(int d: new int[] {-1, 1}){
                    if(map[cur.x1 + d][cur.y1] == 0 && map[cur.x2 + d][cur.y2] == 0){
                        Robot next1 = new Robot(cur.x1, cur.y1, cur.x1+d, cur.y1, cur.time+1);
                        
                        if(visited.add(next1.key())){
                            q.offer(next1);
                        }
                        
                        Robot next2 = new Robot(cur.x2+d, cur.y2, cur.x2, cur.y2, cur.time+1);
                        if(visited.add(next2.key())){
                            q.offer(next2);
                        }
                    }
                }
            }else{ // 세로
                for(int d: new int[] {-1, 1}){
                    if(map[cur.x1][cur.y1+d] == 0 && map[cur.x2][cur.y2+d] == 0){
                        Robot next1 = new Robot(cur.x1, cur.y1, cur.x1, cur.y1+d, cur.time+1);
                        if(visited.add(next1.key())){
                            q.offer(next1);
                        }
                        
                        Robot next2 = new Robot(cur.x2, cur.y2+d, cur.x2, cur.y2, cur.time+1);
                        
                        if(visited.add(next2.key())){
                            q.offer(next2);
                        }
                    }
                }
            }
            
            
            
        }
        
        
        
        // int answer = 0;
        return -1;
    }
}
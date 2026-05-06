import java.util.*;
import java.io.*;
public class Main {

    static class Candidate implements Comparable<Candidate>{
        int x;
        int y;
        int likeCount;
        int emptyCount;

        public Candidate(int x, int y, int likeCount, int emptyCount){
            this.x = x;
            this.y = y;
            this.likeCount = likeCount;
            this.emptyCount = emptyCount;
        }

        @Override
        public int compareTo(Candidate o){
            if(this.likeCount == o.likeCount){
                if(this.emptyCount == o.emptyCount){
                    if(this.x == o.x){
                        return this.y - o.y;
                    }
                    return this.x - o.x;
                }
                return -(this.emptyCount - o.emptyCount);
            }

            return -(this.likeCount - o.likeCount);
        }

    }

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] map = new int[n][n];
        int[] order = new int[n*n];
        int[][] likeFriends = new int[n*n+1][4];

        for(int i = 0; i<n*n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            order[i] = num;
            for(int j = 0; j<4; j++){
                int p = Integer.parseInt(st.nextToken());
                likeFriends[num][j] = p;
            }
        }

        for(int p: order){
            PriorityQueue<Candidate> pq = new PriorityQueue<>();
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(map[i][j] != 0) continue;

                    int likeCount = 0;
                    int emptyCount = 0;
                    for(int d = 0; d<4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(nx < 0 || nx >=n || ny < 0 || ny >=n) continue;
                        if(map[nx][ny] == 0) emptyCount++;
                        for(int k = 0; k<4; k++){
                            if(map[nx][ny] == likeFriends[p][k]){
                                likeCount++;
                                break;
                            }
                        }
                    }
                    pq.add(new Candidate(i, j, likeCount, emptyCount));
                    // 4방향 탐색 및 친한 친구 비교 + 빈 칸 비교
                    // Candidate 우선순위 큐 만들어서 넣기
                }
            }

            Candidate c = pq.poll();
            map[c.x][c.y] = p;
        }

        int answer = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int p = map[i][j];
                int friends = 0;
                for(int d = 0; d<4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if(nx < 0 || nx >=n || ny < 0 || ny >=n) continue;

                    for(int k = 0; k<4; k++){
                        if(map[nx][ny] == likeFriends[p][k]){
                            friends++;
                            break;
                        }
                    }
                }
                if(friends == 1) answer += 1;
                if(friends == 2) answer += 10;
                if(friends == 3) answer += 100;
                if(friends == 4) answer += 1000;
            }
        }

        System.out.println(answer);


    }
}
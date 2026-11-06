import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows+1][columns+1];
        for(int i = 1; i<=rows; i++){
            for(int j = 1; j<=columns; j++){
                arr[i][j] = ((i-1) * columns + j);
            }
        }
        int[] answer = new int[queries.length];
        int idx = 0;
        
        for(int[] query: queries){
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            
            int min = Integer.MAX_VALUE;
            
            // boolean all = false;
            int x = x1;
            int y = y1;
            int num = arr[x][y];
            HashSet<Integer> set = new HashSet<>();
            
            while(true){
                min = Math.min(min, num);
                if(set.contains(num)){
                    break;
                }else{
                    set.add(num);
                    if(x == x1){
                        if(y == y2){
                            // 밑으로 이동
                            x += 1;
                            int temp = arr[x][y];
                            arr[x][y] = num;
                            num = temp;
                            continue;
                        }
                        //오른쪽 이동
                        y += 1;
                        int temp = arr[x][y];
                        arr[x][y] = num;
                        num = temp;
                        continue;
                        
                    }
                    if(y == y2){
                        if(x == x2){
                            // 왼쪽이동
                            y -= 1;
                            int temp = arr[x][y];
                            arr[x][y] = num;
                            num = temp;
                            continue;
                        }
                        
                        
                        //밑 이동
                        x += 1;
                        int temp = arr[x][y];
                        arr[x][y] = num;
                        num = temp;
                        continue;
                    }
                    if(x == x2){
                        
                        if(y == y1){
                            // 위 이동
                            x -= 1;
                            int temp = arr[x][y];
                            arr[x][y] = num;
                            num = temp;
                            continue;
                        }
                        
                        // 왼쪽 이동
                        y -= 1;
                        int temp = arr[x][y];
                        arr[x][y] = num;
                        num = temp;
                        continue;
                    }
                    if(y == y1){
                        // 위로 이동
                        x -= 1;
                        int temp = arr[x][y];
                        arr[x][y] = num;
                        num = temp;
                        continue;
                    }
                }
            }
            
            answer[idx++] = min;
            
            
        }
        
        
        
        
        return answer;
    }
}
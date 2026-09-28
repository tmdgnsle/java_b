class Solution {
    public int[] solution(String[] park, String[] routes) {
        int startX = -1;
        int startY = -1;
        int row = park.length;
        int col = park[0].length();
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(park[i].charAt(j) == 'S'){
                    startX = i;
                    startY = j;
                    break;
                }
            }
            if(startX != -1) break;
        }
        
        int x = startX;
        int y = startY;
        for(String route: routes){
            char d = route.charAt(0);
            int n = Integer.parseInt(route.substring(2, 3));
            int nx = x;
            int ny = y;
            
            for(int i = 0; i<n; i++){
                if(d == 'N') nx -= 1;
                else if(d == 'S') nx += 1;
                else if(d == 'W') ny -= 1;
                else if(d == 'E') ny += 1;
                
                if(nx < 0 || nx >= row || ny < 0 || ny >= col || park[nx].charAt(ny) == 'X'){
                    nx = x;
                    ny = y;
                    break;
                }
            }
            
            x = nx;
            y = ny;
            
        }
        
        int[] answer = {x, y};
        return answer;
    }
}
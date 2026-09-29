import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        ArrayList<Integer> basket = new ArrayList<>();
        for(int move: moves){
            move -= 1;
            for(int i = 0; i<n; i++){
                if(board[i][move] != 0){
                    if(basket.size() != 0){
                        if(basket.get(basket.size()-1) == board[i][move]){
                            answer += 2;
                            basket.remove(basket.size() -1); 
                        }else{
                            basket.add(board[i][move]);
                        }
                    }else{
                        basket.add(board[i][move]);
                    }
                    board[i][move] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
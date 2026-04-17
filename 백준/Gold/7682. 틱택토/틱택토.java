import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;

            int xCount = 0;
            int oCount = 0;

            char[][] board = new char[3][3];

            for(int i = 0; i < 9; i++){
                char c = str.charAt(i);
                board[i / 3][i % 3] = c;

                if(c == 'X') xCount++;
                else if(c == 'O') oCount++;
            }



            // 개수 조건
            if(!(xCount == oCount || xCount == oCount + 1)){
                sb.append("invalid\n");
                continue;
            }

            boolean xWin = win(board, 'X');
            boolean oWin = win(board, 'O');

            // 둘 다 이김
            if(xWin && oWin){
                sb.append("invalid\n");
                continue;
            }

            // X 승리
            if(xWin){
                if(xCount == oCount + 1) sb.append("valid\n");
                else sb.append("invalid\n");
                continue;
            }

            // O 승리
            if(oWin){
                if(xCount == oCount) sb.append("valid\n");
                else sb.append("invalid\n");
                continue;
            }

            // 아무도 안 이김
            if(xCount + oCount == 9){
                if(xCount == oCount + 1) sb.append("valid\n");
                else sb.append("invalid\n");
            } else {
                sb.append("invalid\n");
            }
        }

        System.out.print(sb);
    }

    static boolean win(char[][] b, char c){
        // 가로, 세로
        for(int i = 0; i < 3; i++){
            if(b[i][0] == c && b[i][1] == c && b[i][2] == c) return true;
            if(b[0][i] == c && b[1][i] == c && b[2][i] == c) return true;
        }
        // 대각선
        if(b[0][0] == c && b[1][1] == c && b[2][2] == c) return true;
        if(b[0][2] == c && b[1][1] == c && b[2][0] == c) return true;

        return false;
    }

}
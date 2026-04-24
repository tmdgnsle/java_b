class Solution {
    static int zero = 0;
    static int one = 0;
    
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return new int[]{zero, one};
    }
    
    static void compress(int[][] arr, int x, int y, int size) {
        if (isSame(arr, x, y, size)) {
            if (arr[x][y] == 0) zero++;
            else one++;
            return;
        }
        
        int half = size / 2;
        
        compress(arr, x, y, half);
        compress(arr, x, y + half, half);
        compress(arr, x + half, y, half);
        compress(arr, x + half, y + half, half);
    }
    
    static boolean isSame(int[][] arr, int x, int y, int size) {
        int first = arr[x][y];
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
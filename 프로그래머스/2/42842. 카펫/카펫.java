class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for(int i = 3; i<=total; i++){
            
            if(total % i == 0){
                int width = i;
                int height = total / i;
                
                if(width >= height){
                    int yellowCount = (width - 2) * (height - 2);
                if(yellowCount == yellow){
                    return new int[] {width, height};
                }
                }
                
            }
        }
        
        
        
        
        int[] answer = {};
        return answer;
    }
}
import java.util.*;

class Solution {
    static int[] rates = {10, 20, 30, 40};
    static int[][] salesEmoticons;
    static ArrayList<Integer> arr;
    static int usersLength;
    static int emoticonsLength;
    static int finalJoin, finalMoney = 0;
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        usersLength = users.length;
        emoticonsLength = emoticons.length;
        
        salesEmoticons = new int[emoticonsLength][4];
        
        arr = new ArrayList<>();
        calculateSale(emoticons);
        
        bt(users);
        
        int[] answer = {finalJoin, finalMoney};
        return answer;
    }
    
    static void buy(int[][] users){
        int join = 0;
        int money = 0;
        for(int i = 0; i<usersLength; i++){
            int userRate = users[i][0];
            int userMoney = users[i][1];
            
            int totalMoney = 0;
            
            for(int j = 0; j<emoticonsLength; j++){
                int idx = arr.get(j);
                int emoRate = rates[idx];
                int emoMoney = salesEmoticons[j][idx];
                
                if(userRate <= emoRate){
                    totalMoney += emoMoney;
                }
            }
            if(totalMoney >= userMoney){
                join++;
            }else{
                money += totalMoney;
            }
        }
        
        if(finalJoin < join){
            finalJoin = join;
            finalMoney = money;
        }else if(finalJoin == join && finalMoney < money){
            finalMoney = money;
        }
        
    }
    
    
    static void bt(int[][] users){
        
        if(arr.size() == emoticonsLength) {
            buy(users);
            return;
        }
        
        for(int i = 0; i<4; i++){
            arr.add(i);
            bt(users);
            arr.remove(arr.size() - 1);
        }
    }
    
    static void calculateSale(int[] emoticons){
        for(int i = 0; i<emoticonsLength; i++){
            for(int j = 0; j<4; j++){
                salesEmoticons[i][j] = emoticons[i] * (100 - rates[j]) / 100 ; 
            }
        }
    }
    
}
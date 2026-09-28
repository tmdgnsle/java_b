import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int day_today = change(today);
        System.out.println("today: " + day_today);
        HashMap<String, Integer> term = new HashMap<>();
        for(String te: terms){
            String[] t = te.split(" ");
            String condition = t[0];
            int num = Integer.parseInt(t[1]);
            term.put(condition, num*28);
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<privacies.length; i++){
            String privacy = privacies[i];
            String[] p = privacy.split(" ");
            int date = change(p[0]);
            String condition = p[1];
            int term_date = date + term.get(condition);
            System.out.println("term_date: " + term_date);
            if(term_date <= day_today) arr.add(i+1);
            
        }
        
        
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
        // return new int[] {};
        
    }
    
    static int change(String date){
        String[] d = date.split("\\.");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        // System.out.println(year + " " + month + " " + day);
        
        return year * 12 * 28 + month * 28 + day;
    }
}
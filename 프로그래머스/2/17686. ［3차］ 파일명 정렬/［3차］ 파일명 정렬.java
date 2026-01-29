import java.util.*;

class Solution {
    
    static class File implements Comparable<File>{
        String head;
        String number;
        String tail;
        int idx;
        
        File(String head, String number, String tail, int idx){
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
        }
        
        public int compareTo(File o){
            if(this.head.toLowerCase().equals(o.head.toLowerCase())){
                int n1 = Integer.parseInt(this.number);
                int n2 = Integer.parseInt(o.number);
                if(n1 == n2){
                    return this.idx - o.idx;
                }
                return n1 - n2;    
            }

            return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }
    }
    
    public String[] solution(String[] files) {
        PriorityQueue<File> pq = new PriorityQueue<>();
        for(int i = 0; i<files.length; i++){
            String f = files[i];
            int headIdx = 0;
            boolean headDone = false;
            int numberIdx = f.length();
            
            for(int j = 0; j<f.length(); j++){
                char c = f.charAt(j);
                if(!headDone){
                    if(Character.isDigit(c)){
                        headIdx = j;
                        headDone = true;
                    }    
                }else {
                    if(!Character.isDigit(c)){
                        numberIdx = j;
                        break;
                    }
                }
            }
            String head = ""+f.substring(0, headIdx);
            String number = ""+f.substring(headIdx, numberIdx);
            String tail = ""+f.substring(numberIdx, f.length());
            
            
            
            pq.add(new File(head, number, tail, i));
            
        }
        int size = pq.size();
        String[] answer = new String[size];
        
        for(int i = 0; i<size; i++){
            File current = pq.poll();
            String head = current.head;
            String number = current.number;
            String tail = current.tail;
            
            answer[i] = head + number + tail;
            
        }
        return answer;
    }
}
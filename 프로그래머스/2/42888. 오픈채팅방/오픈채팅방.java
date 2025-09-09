import java.util.*;

class Solution {
    static HashMap<String, String> nicknameMap;
    static HashMap<String, ArrayList<Integer>> resultMap;
    static ArrayList<String> result;
    static int idx;
    public String[] solution(String[] record) {
        nicknameMap = new HashMap<>();
        resultMap = new HashMap<>();
        result = new ArrayList<>();
        idx = 0;
        
        for(String r: record){
            String[] arr = r.split(" ");
            if(r.charAt(0) == 'L'){
                String uid = arr[1];
                leave(uid);
            }else if(r.charAt(0) == 'E'){
                String uid = arr[1];
                String nickname = arr[2];
                enter(uid, nickname);
            }else if(r.charAt(0) == 'C'){
                String uid = arr[1];
                String nickname = arr[2];
                String prevNickName = nicknameMap.get(uid);
                change(uid, nickname, prevNickName);
            }
        }
        
        String[] answer = new String[result.size()];
        
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    static void leave(String uid){
        String nickname = nicknameMap.get(uid);
        result.add(nickname + "님이 나갔습니다.");
        ArrayList<Integer> arr = resultMap.get(uid);
        arr.add(idx++);
        resultMap.put(uid, arr);
    }
    
    static void enter(String uid, String nickname){
        String prevNickName = nicknameMap.getOrDefault(uid, "");
        if(prevNickName.equals("")){
            nicknameMap.put(uid, nickname);
            ArrayList<Integer> arr = new ArrayList<>();
            result.add(nickname + "님이 들어왔습니다.");
            arr.add(idx++);
            resultMap.put(uid, arr);
        }else {
            change(uid, nickname, prevNickName);
            result.add(nickname + "님이 들어왔습니다.");
            ArrayList<Integer> arr = resultMap.get(uid);
            arr.add(idx++);
            resultMap.put(uid, arr);
        }
        
    }
    
    static void change(String uid, String nickname, String prevNickName){
        nicknameMap.put(uid, nickname);
        ArrayList<Integer> arr = resultMap.get(uid);
        for(int idx : arr){
            String oldMessage = result.get(idx);
            String newMessage = oldMessage.replace(prevNickName, nickname);
            result.set(idx, newMessage);
        }
    }
    
}
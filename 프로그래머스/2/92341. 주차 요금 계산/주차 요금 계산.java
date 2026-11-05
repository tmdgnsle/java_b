import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> cars = new HashMap<>();
        HashMap<String, Integer> times = new HashMap<>();
        ArrayList<String> carNums = new ArrayList<>();
        
        int basic_time = fees[0];
        int basic_money = fees[1];
        int per_time = fees[2];
        int per_money = fees[3];
        
        for(String record: records){
            String[] r = record.split(" ");
            String time = r[0];
            String car = r[1];
            String now = r[2];
            
            if(!cars.containsKey(car) && !times.containsKey(car)){
                carNums.add(car);
            }
            
            if(now.equals("IN")){
                cars.put(car, time);
            }else{
                String inTime = cars.get(car);
                cars.remove(car);
                int diffMin = diffTime(inTime, time);
                times.put(car, times.getOrDefault(car, 0)+diffMin);
            }
            
        }
        
        for(String car: cars.keySet()){
            String inTime = cars.get(car);
            int diffMin = diffTime(inTime, "23:59");
            times.put(car, times.getOrDefault(car, 0)+diffMin);
        }
        
        Collections.sort(carNums);
        int[] answer = new int[carNums.size()];
        
        for(int i = 0; i<carNums.size(); i++){
            String car = carNums.get(i);
            int totalFee = 0;
            int time = times.get(car);
            if(time <= basic_time){
                totalFee = basic_money;
            }else{
                totalFee += basic_money;
                totalFee += Math.ceil((double)(time - basic_time) / per_time) * per_money;
            }
            answer[i] = totalFee;
        }
        
        
        
        
        return answer;
    }
    
    
    static int diffTime(String inTime, String outTime){
        String[] in = inTime.split(":");
        String[] out = outTime.split(":");
        
        int inHour = Integer.parseInt(in[0]);
        int inMin = Integer.parseInt(in[1]);
        int outHour = Integer.parseInt(out[0]);
        int outMin = Integer.parseInt(out[1]);
        
        return outHour * 60 + outMin - inHour*60 - inMin;
    }
}
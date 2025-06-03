import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n, k;
    static int[] nums;
    static ArrayList<Integer> arr;
    static HashSet<String> set;
    static boolean[] v;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        nums = new int[n];
        v = new boolean[n];
        for(int i = 0; i<n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        arr = new ArrayList<>();
        set = new HashSet<>();

        bt(0);

        System.out.println(set.size());
        
    }

    static void bt(int count){
        if(count == k){
            String str = "";
            for(int i = 0; i<k; i++){
                str += arr.get(i).toString();
            }
            set.add(str);
            
            return;
        }

        for(int i = 0; i<n; i++){
            if(!v[i]){
                arr.add(nums[i]);
                v[i] = true;
                bt(count+1);
                v[i] = false;
                arr.remove(arr.size() - 1);
            }
        }
        
    }
    
}
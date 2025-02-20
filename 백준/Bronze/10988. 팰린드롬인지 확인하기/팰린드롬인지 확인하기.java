import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		sb.reverse();
		
		if(s.equals(sb.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}

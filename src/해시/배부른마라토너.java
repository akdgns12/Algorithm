package �ؽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ��θ�������� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // ������ ��
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			map.put(name, i);
		}
		
		ArrayList<String> result = new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
				map.remove(name);
 			}
		}
		
		for(String key : map.keySet()) {
			System.out.println(key);
		}
		
		
	}
}

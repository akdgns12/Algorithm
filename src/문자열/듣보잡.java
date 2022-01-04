package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 듣보잡 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,Integer> map = new HashMap<>();
		// 듣도 못한
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name,0)+1);
		}
		// 보도 못한 
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) +1);
		}
		
		ArrayList<String> result = new ArrayList<>();
		for(String key : map.keySet()) {
			if(map.get(key) > 1) {
				result.add(key);
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		
		
	}
}

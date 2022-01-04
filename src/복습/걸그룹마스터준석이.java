package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 걸그룹마스터준석이 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 걸그룹의 수
		int M = Integer.parseInt(st.nextToken()); // 맞혀야 할 문제의 수
		HashMap<String, String> map = new HashMap<>(); // team, name
		ArrayList<String> result = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringBuilder sb = new StringBuilder();
			String team = br.readLine();
			int num = Integer.parseInt(br.readLine());
			for(int j=0; j<num; j++) {
				String name = br.readLine();
				sb.append(name + " ");
			}
			map.put(team, sb.toString());
		}
		
		for(int i=0; i<M; i++) {
			String str = br.readLine(); // 팀명이거나, 이름이거나
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) { // 팀명이 온경우 -> 해당팀의 이름 출력
				st = new StringTokenizer(map.get(str));
				
				while(st.hasMoreTokens()) {
					result.add(st.nextToken());
				}
				
				Collections.sort(result);
				
				for(int j=0; j<result.size(); j++) {
					System.out.println(result.get(j));
				}
			}
			else { // 이름이 온 경우 -> 팀명을 호출해줘야함
				for(String key : map.keySet()) {
					st = new StringTokenizer(map.get(key));
					
					while(st.hasMoreTokens()) {
						if(str.equals(st.nextToken())) {
							System.out.println(key);
						}
					}
				}
			}
		}
	
	}
}

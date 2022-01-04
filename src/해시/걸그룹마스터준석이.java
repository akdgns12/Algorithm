package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 걸그룹마스터준석이 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 걸그룹의 수
		int M = Integer.parseInt(st.nextToken()); // 맞혀야 할 문제의 수
		HashMap<String, String> map = new HashMap<>();
		ArrayList<String> result = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringBuilder sb = new StringBuilder();
			String team = br.readLine();
			int num = Integer.parseInt(br.readLine());
			// 걸그룹 문자열 받기
			for(int j=0; j<num; j++) {
				String name = br.readLine();
				sb.append(name + " ");
			}
			map.put(team, sb.toString());
		}
		
		// 문제관련 for문
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			int num = Integer.parseInt(br.readLine());
			
			// 0의 입력이 들어왔을 때
			if(num == 0) { // 멤버이름 사전순 출력
				st = new StringTokenizer(map.get(str));
				
				while(st.hasMoreTokens()) {
					result.add(st.nextToken());
				}
				Collections.sort(result);
				
				for(int j=0; j<result.size(); j++) {
					System.out.println(result.get(j));
				}
			}
			// 1의 입력이 들어왔을 때
			else { // 걸그룹 멤버 이름에 맞는 팀명 호출 key : 팀명, value : 이름
				for(String key : map.keySet()) {
					st = new StringTokenizer(map.get(key));
					
					while(st.hasMoreTokens()) {
						String strr = st.nextToken();
						if(str.equals(strr)) {
							System.out.println(key);
						}
					}
				}
//				Iterator<String> it = map.keySet().iterator();
//				
//				while(it.hasNext()) {
//					String key = it.next();
//					st = new StringTokenizer(map.get(key));
//					
//					while(st.hasMoreTokens()) {
//						String strr = st.nextToken();
//						
//						if(str.equals(strr)) {
//							System.out.println(key);
//						}
//					}
//				}
			}
		}
	}
}

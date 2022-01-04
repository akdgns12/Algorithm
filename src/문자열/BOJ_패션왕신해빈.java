package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_패션왕신해빈 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			//key : 의상종류 , value : 의상 개수
			HashMap<String, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			while(n --> 0) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken(); //옷 이름은 필요없음
				String kind = st.nextToken(); // 옷 종
				
				/*
				 * 해당 종류의 옷이 해시맵에 있을경우
				 * 해시맵에 저장되어 있던 해당 종류의 개수를 +1증가시킨다.
				 * 
				 * 해당 종류의 옷이 해시맵에 없을 경우
				 * 해당 종류의 개수 1을 넣는다
				 */
				
				if(map.containsKey(kind)) {
					map.put(kind, map.get(kind)+1);
				}else {
					map.put(kind, 1);
				}
			}
			
			int result = 1;
			
			/*
			 * 안 입는 경우를 고려하여 각 종류별 옷의 개수에 +1 해준 값을
			 * 곱해주어야 한다.
			 * ex)
			 * [headgear] : hat, turban, NULL
			 * [eyewear] : sunglasses, NULL
			 * 3C1 * 2C1 - 1(아무것도 안입는 경우) = answer
			 */
			for(int val : map.values()) {
				result *= (val+1);
			}
			//알몸인 상태를 제외해주어야 하므로 최종값에 -1이 정답
			sb.append(result - 1).append('\n');
		}
		System.out.println(sb);
	}
}

package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 포켓몬 수
		int M = Integer.parseInt(st.nextToken()); // 맞춰야 하는 문제의 개수
		HashMap<String, String> map = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String input = br.readLine();
			String number = Integer.toString(i);
			map.put(input, number);
			map.put(number, input);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String answer = br.readLine();
			sb.append(map.get(answer) + "\n");
		}
		
		System.out.println(sb);
		
		
	}
}

package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 암기왕 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			HashSet<Integer> set = new HashSet<>();
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine()); // 수첩1에 들어있는 정수 개수
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine()); // 수첩2에 들어있는 정수 개수
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				if(set.contains(Integer.parseInt(st.nextToken()))){
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
			System.out.print(sb);
		}
	}
}

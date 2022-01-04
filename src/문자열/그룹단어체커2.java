package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 그룹단어체커2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = N;
		for(int i=0; i<N; i++) {
			
			String str = br.readLine();
			
			boolean[] visited = new boolean[26];
			Arrays.fill(visited, false);
			
			visited[str.charAt(0) - 97] = true;
			for(int j=1; j<str.length(); j++) {
				if(str.charAt(j) != str.charAt(j-1)) { // 현재 문자가 전 문자와 다르다면
					if(visited[str.charAt(j) - 97] == true) { // 이미 방문처리 되어있다면 그룹단어 x
						count--;
						break;
					}else {
						visited[str.charAt(j) - 97] = true;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}

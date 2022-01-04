package 백트래킹;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759 {
	static int L,C;
	static char[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		arr = new char[C];
		visited = new boolean[C];
		for(int i=0; i<C; i++) {
			arr[i] = sc.next().charAt(0);
		}
		// 사전 순 정렬
		Arrays.sort(arr);
		
		combi(0, 0);
	}	
	
	public static void combi(int start, int cnt) {
		if(cnt == L) {
			int moCnt = 0;
			int jaCnt = 0;
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<C; i++) {
				if(visited[i]) {
					sb.append(arr[i]);
					
					if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
						moCnt++;
					}else {
						jaCnt++;
					}
				}
			}
			
			if(moCnt >= 1 && jaCnt >= 2 ) System.out.println(sb.toString());
		}
		
		// 백트래킹
		for(int i=start; i<C; i++) {
			visited[i] = true;
			combi(i+1, cnt+1);
			visited[i] = false;
		}
	}
}

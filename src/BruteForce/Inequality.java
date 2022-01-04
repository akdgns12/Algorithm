package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


// 부등호
public class Inequality {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N; // 부등호 문자의 개수
	private static char[] arr = new char[10]; // 부등호는 최대 9개
	private static boolean[] visited = new boolean[10]; //0~9까지 check
	private static List<String> ans = new ArrayList<>(); // arraylist 가변적인 배열
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()); //문자열 분리
		
		for(int i = 0; i<N; i++) {
			arr[i]=st.nextToken().charAt(0); //st 문자열에 담은 문자열에서 첫번째 문자를 arr[i]에 담는다.
		}
		
		dfs("",0);
		Collections.sort(ans); // 정렬
		
		System.out.println(ans.get(ans.size()-1)); //size() 컬렉
		System.out.println(ans.get(0));
		br.close();
	}
	
	private static void dfs(String num, int idx) {
		if(idx==N+1) {
			ans.add(num);
			return;
		}
		
		for(int i = 0;i<=9;i++) {
			if(visited[i])continue;
			if(idx == 0 || ck(Character.getNumericValue(num.charAt(idx-1)), i, arr[idx-1])){
				visited[i]=true;
				dfs(num+i, idx+1);
				visited[i]=false;
			}
		}
	}
	private static boolean ck(int a, int b, char c) {
		if( c== '<') {
			if(a>b)return false;
		}	else if(c=='>') {
			if(a<b)return false;
		}
		return true;
	}
}

package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 듣보잡_set방법 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		ArrayList<String> result = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			set.add(name);
		}
		
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				result.add(name);
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}

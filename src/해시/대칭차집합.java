package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 대칭차집합 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int result = 0;
		HashSet<Integer> Aset = new HashSet<>();
		HashSet<Integer> Bset = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<A; i++) {
			int num = Integer.parseInt(st.nextToken());
			Aset.add(num);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<B; i++) {
			int num = Integer.parseInt(st.nextToken());
			Bset.add(num);
		}
		
		int count = 0;
		for(int num : Aset) {
			if(!Bset.contains(num)) {
				count += 1;
			}
		}
		
		for(int num : Bset) {
			if(!Aset.contains(num)) {
				count += 1;
			}
		}
		
		System.out.println(count);
		
	}
}

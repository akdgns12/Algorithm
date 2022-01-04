package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 추월 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 차의 대수
		HashMap<String, Integer> map = new HashMap<>();
		int count = 0;
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			map.put(input, i);
		}
		
		int[] out = new int[N];
		for(int i=0; i<N; i++) {
			String output = br.readLine();
			out[i] = map.get(output);
		}
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(out[i] > out[j]) {
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}

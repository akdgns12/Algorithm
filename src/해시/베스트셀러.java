package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 베스트셀러 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 오늘 팔린 책 개수
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		
		//HashMap을 돌며 value가 최대값인 책을 찾음
		// 만약 value가 같다면 책이 사전순으로 앞서는 것을 출력
		int max = 0;
		String maxBook = "";
		for(String key : map.keySet()) {
			int value = map.get(key);
			
			if(value == max && maxBook.compareTo(key) > 0) {
				maxBook = key;
				max = value;
			}else if(value > max) {
				max = value;
				maxBook = key;
			}
		}
		System.out.println(maxBook);
	}
}

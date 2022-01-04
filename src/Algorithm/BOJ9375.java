package Algorithm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// 패션왕 신해빈
// 옷 종류별로 (옷 개수+1) * (옷 개수 + 1 ) * ... * (옷 개수 + 1 ) -1 이 총 알몸이 아닌 상태로 의상을 입을 수 있는 경우의 수 입니다.
public class BOJ9375 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int i=0; i<testcase; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			int n = sc.nextInt();
			for(int j=0; j<n; j++) {
				String name = sc.next();
				String type = sc.next();
				map.put(type, map.getOrDefault(type,0)+1); //map.getOrDefault = 찾는키가 존재한다면 찾는키의 값을 반환하고 없다면 기본 값을 반환.
			}
			int ans = 1;
			for(String key : map.keySet()) { //keyset() key값만 필요할 경우 사용, entryset() key와 value 두개 모두 필요할 경우 사용
				ans *= (map.get(key)+1);
			}
			System.out.println(ans-1);
		}
	}
}
// 예쓰 아이 가뤼 디스 베베, 발상 대박 and 풀이도 좀 어렵스

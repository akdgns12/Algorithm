package 유니온파인드;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 친구네트워크 {
	static int TC, F; // 테스트케이스 수, 친구 관계 수
	static int[] parent; // 유니온 집합 셋
	static int[] count; // 친구 관계 수
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		
		while(TC --> 0) {
			F = sc.nextInt();
			parent = new int[F*2];
			count = new int[F*2];
			
			for(int i=0; i<F; i++) {
				parent[i] = i;
			}
			Arrays.fill(count, 1);
			
			HashMap<String, Integer> map = new HashMap<>();
			int index = 0;
			for(int i=0; i<F; i++) {
				String friend1 = sc.nextLine();
				String friend2 = sc.nextLine();
				
				if(!map.containsKey(friend1)) {
					map.put(friend1, index++);
				}
				if(!map.containsKey(friend2)) {
					map.put(friend2, index++);
				}
				
				System.out.println(union(map.get(friend1),map.get(friend2)));
			}
			
		}
	}
	
	public static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	public static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			if(a < b) {
				parent[b] = a; // b의 부모는 a
				count[a] += count[b];
				return count[a];
			}else {
				parent[a] = b;
				count[b] += count[a];
				return count[b];
			}
		}
		return count[a];
	}
}

package 프로그래머스level2;

import java.util.HashMap;

/*
 * 백트래킹 or DFS
 */

public class 단체사진찍기 {
	//사람들의 모음을 hashmap으로 표현
	static HashMap<Character, Integer> hm;
	//데이터를 넣는 배열
	static int[] permute;
	//선택한 것을 표시하는 배열
	static boolean[] visited;
	static int answer;
	public int solution(int n, String[] data) {
		//캐릭터마다 번호를 매칭
		hm = new HashMap<Character, Integer>()	;
		hm.put('A', 0);
		hm.put('C', 1);
		hm.put('F', 2);
		hm.put('J', 3);
		hm.put('M', 4);
		hm.put('N', 5);
		hm.put('R', 6);
		hm.put('T', 7);
		permute = new int[8];
		visited = new boolean[8];
		answer = 0;
		//dfs를 이용해 모든 경우의 수(순열)을 구하고 data에 있는 조건과 비교해서 answer를 늘린다.
		dfs(0, data);
		return answer;
	}
	//permute에서 pos번째 캐릭터의 위치를 고른다.
	static void dfs(int pos, String[] data) {
		//하나의 permute이 완성
		//주어진 조건들에 부합하는지 검사
		if(pos == 8) {
			char compare;
			int c1, c2, digit;
			for(int i=0; i<data.length; i++) {
				c1 = permute[hm.get(data[i].charAt(0))];
				c2 = permute[hm.get(data[i].charAt(2))];
				compare = data[1].charAt(3);
				// - '0'을 함으로써 in형으로 변환
				digit = data[i].charAt(4) - '0';
				if(compare == '>') {
					if(Math.abs(c1-c2) -1 <= digit)
						return;
				}else if(compare == '<') {
					if(Math.abs(c1 - c2) - 1 >= digit)
						return;
				}else {
					if(Math.abs(c1 - c2) - 1 != digit)
						return;
				}
			}
			answer++;
			return;
		}
		// dfs방식으로 탐색
		// visited 배열 요소가 false라면 pos를 1추가해서 재귀 호출
		// dfs호출 전에 permute[pos]에 i를 추가하고 true표시
		// 호출 후에는 다시 false 표시
		for(int i=0; i<8; i++) {
			if(!visited[i]){
				visited[i] = true;
				permute[pos] = i;
				dfs(pos+1, data);
				visited[i] = false;
			}
		}
	}
}

package DFS_BFS;

import java.util.*;

public class 단체사진찍기_level2 {
	static int[] position; //카카오프렌즈가 서있는 위치
	static boolean[] visited; //카카오 프렌즈의 방문여부
	static int cnt; 
	static HashMap<Character, Integer> kakao;
	static boolean ok;
	
	public int solution(int n, String[] data) {
		int answer = 0;
		position = new int[8];
		visited = new boolean[8];
		cnt = 0;
		kakao = new HashMap<>();
		ok = true;
		//position의 index번호로 매핑
		kakao.put('A', 0);
		kakao.put('C', 1);
		kakao.put('F', 2);
		kakao.put('J', 3);
		kakao.put('M', 4);
		kakao.put('N', 5);
		kakao.put('R', 6);
		kakao.put('T', 7);
		
		//1.순열
		perm(0, data);
		//2.조건 검사
		answer = cnt;
		return answer;
		//조건의 개수 n
		//data 배엘에 주어지는 조건을 만족하는 경우의 수
		//data char로 읽어들여 문자 분리해줘서 조건 만들자
		
	}
	
	public static void perm(int idx, String[] data) {
		//기저조건, 8개 순서 다 결정됐다면
		if(idx == 8) {
			if(isOk(data)) {
				cnt++;
			}
			return;
		}
		
		//순열 
		for(int i=0; i<8; i++) {
			//사용하지 않은거라면
			if(!visited[i]) {
				visited[i] = true;
				position[idx] = i;
				perm(idx+1, data);
				visited[i] = false;
			}
		}
	}
	
	public static boolean isOk(String[] data) {
		//입력받은 값 꺼내고 검사하자
		
		for(int i=0; i<data.length; i++) {
			int X = kakao.get(data[i].charAt(0)); //data배열의 i번째 원소의 첫번째 글자
			int Y = kakao.get(data[i].charAt(2));//data배열의 i번째 원소의 3번째 글자
			char type = data[i].charAt(3); // data배열의 i번째 원소의 4번째 글자 = 부등호
			int diff = data[i].charAt(4) - '0'; // data배열의 i번째 원소의 5번째 글자 int형 정수 
			int Xpos = position[X];
			int Ypos = position[Y];
			if(type == '=') {
				if(Math.abs(Xpos - Ypos) - 1 != diff){
					return false;
				}
			}else if(type == '>') {
				if(Math.abs(Xpos - Ypos) - 1 <= diff) {
					return false;
				}
			}else if(type == '<') {
				if(Math.abs(Xpos - Ypos) -1 >= diff) {
					return false;
				}
			}
		}
		return true;
	}
}

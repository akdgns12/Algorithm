package 그래프탐색;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. 참고사항

- 2차원 배열을 하나의 정수로 표현한다.
- MAP을 이용하여 정수와 이동횟수를 관리한다.
- String.valueOf(int N) : int N을 String으로 변환해준다.
- StringBuilder.setCharAt -> 특정 위치에 char를 삽입할 수 있다.
- String.indexOf(String s) -> s가 위치한 인덱스를 반환한다.
- map.containsKey(String s) -> map이 s라는 key를 갖고있다면 true.
- int row = idx / 3; // idx 가 2차원배열에서 몇 번째 행인지 계산
- int col = idx % 3; // idx 가 2차원배열에서 몇 번째 열인지 계산

2. 구현

- start 변수에 2차원배열을 하나의 정수로 바꾸어 담는다.
- map에 초기 정수와 횟수를 담는다.
- bfs를 시작한다
- 4방향으로 탐색하면서 자신과 바꿀 위치를 스왑하고 map에 중복되지 않으면 담는다.
- 반복

출처: https://toastfactory.tistory.com/228 [이삭이의 토스트 공장]
 */
public class 퍼즐 {
	static String correct = "123456780";
	static Map<String, Integer> map = new HashMap<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		String init ="";
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int num = Integer.parseInt(st.nextToken());
				init += num;
			}
		}
	
		map.put(init, 0);
		System.out.println(bfs(init));
	}
	
	static int bfs(String init) {
		Queue<String> q = new LinkedList<>();
		q.add(init);
		while(!q.isEmpty()) {
			String pos = q.poll();
			int move =map.get(pos); // 움직인 횟수
			int zerIdx = pos.indexOf('0'); // 0의 위치
			int px = zerIdx%3; // 행의 위치
			int py = zerIdx/3; // 열의 위치
			
			if(pos.equals(correct)) { // 만약 정답과 같다면 횟수 return
				return move;
			}
			
			for(int i=0; i<4; i++) { // 이동할 수 있는 곳 검사하기
				int nx = px +dx[i];
				int ny = py + dy[i];
				
				if(nx<0 || ny<0 || nx>2 || ny>2) continue;
				
				int nPos = ny*3 + nx; // 2차원 인덱스를 1차원으로 변환
				char ch = pos.charAt(nPos); // 해당 string의 npos번째 문자
				String next = pos.replace(ch, 'c');
				next = next.replace('0', ch);
				next = next.replace('c', '0');
				
				if(!map.containsKey(next)) {
					q.add(next);
					map.put(next, move+1);
				}
			}
		}
		return -1;
	}
}

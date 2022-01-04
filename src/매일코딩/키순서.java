package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 학생들의 키를 비교한 결곽가 주어질 때, 자신의 키가 몇 번째인지 알 수 있는 학생들이 모두 몇 명인지 계산하라
// 자신을 제외한 모든 정점에서 모든 정점에 대하여 이동할 수 있는지 파악해야함.
/*
 * <로직>
 * 1. 문제의 입력받은 배열에 대하여 플로이드 와샬 알고리즘을 취한다.
 * 2. 문제의 입력과 반대로 받은 배열에 대하여 플로이드 와샬 알고리즘을 취한다.
 * 3. 1번과 2번의 배열 or연산한다.
 * 4. or연산한 배열에서 자신은 제외한 학생 모두를 탐색할 수 있는 인덱스의 개수를 계산한다.
 *	
 * 여기서 문제의 입력과 반대로 받았다는 의미는 "1 5" 대신 "5 1"로 키순서를 반대로 입력받았다는 뜻.
 * 이제 2번과 3번과정을 하게 된 이유를 설명해주자면
 * 1차적으로 문제의 입력이 주어진 대로 플로이드 와샬 알고리즘을 전개하면, 문제가 발생한다.
 * 문제의 입력을 예시로 들면, 4번 학생의 경우 2번과 6번 학생쪽으로만 화살표가 있기 때문에 나머지 1, 3, 5에 대해서는 이동을 할 수가 없다.
 * 하지만, 그래프 상으로는 1,3,5가 명확하게 4번보다 키가 작기때문에 이에 대해서도 판단해야 한다.
 * 
 * 여기서 문제의 입력과 반대로 입력받은 새로운 배열을 정의하여 마찬가지로 플로이드 와샬 알고리즘을 전개하면. 이 경우, 4번 학생이 이동할 수 있는 화살표는 1,3,5번 학생이 된다.
 * 그리고 두 배열을 or 연산을 하면, 4번 학생이 갈 수 있는 길은 1,2,3,5,6으로 모든 학생에 대하여 이동할 수 있다.
 * 결과적으로 4번 학생은 자신의 키가 몇번째로 큰지 파악할 수 있게 된다.
 * 4번 학생이 아니라 5번학생을 기준으로 해보면
 * 문제의 입력을 그대로 받은 배열에 대해서 플로이드 와샬 알고리즘을 취하면, 5번 학생은 2,4,6번 학생을 탐색할 수 있다.
 * 문제의 입력을 반대로 받은 배열에 대해서 플로이드 와샬 알고리즘을 취하면, 5번 학생은 1번 학생만 탐색할 수 있다.
 * 위 두 배열을 or 연산하면 1,2,4,6번으로 3번 학생에 대해서는 키 비교를 할 수 없다.
 * 이런식으로 문제의 조건에 맞게 파악할 수 있다.
 */
public class 키순서 {
	static int N;
	static int M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// a학생이 b학생보다 작다면(연결되어 있다면) 1을 저장한다.
			map[a][b] = 1;
		}
		
		//플로이드와샬 수행
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][k] == 1 && map[k][j] == 1) {
						map[i][j] = 1;
					}
				}
			}
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			boolean flag = true;
			for(int j=1; j<=N; j++) {
				if(i == j) 
					continue;
				
				// 둘 다 1이 아니라는 것(연결되어 있지 않음)은 i 와 j가 키를 비교할 수 없다는 것을 의미
				// -> 자신의 키가 몇번째인지 알 수 없음!
				// 하나라도 연결되어 있으면 비교할 수 있을텐데..
				if(map[i][j] != 1 && map[j][i] != 1) {
					flag = false;
					break;
				}
			}
			
			if(flag) answer++;
		}
		System.out.println(answer);	
	}
}

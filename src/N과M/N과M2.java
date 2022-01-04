package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ_15650
// 1부터 N까지의 수 중 오름차순이면서 M의 길이까지 나열 가능한 수열

public class N과M2 {
	
	static int N, M;
	//static boolean[] visit; (1)과 달리 중복방문인지를 고려할 필요가 없으믈 boolean 배열로 중복여부를 체크할 필요 x
	// 재귀과정에서 만약 모든 배열에 채우지 못하는 경우에는 depth == M 이 될 수 없게되고, 반복문이 먼저 끝나기 때문에 자동으로 걸러지게 된다.
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(1, 0);
		System.out.println(sb);
		
	}
	
	/*
	 * at변수의 의미는 현재 위치, 즉 어디서부터 시작하는지를 의미하는 변수.
	 * 예로들어 반복문에서 재귀를 해줄 때, at=1부터 시작하면 다음 재귀는 오름차순으로 탐색하기 위해 at를 1증가시킨 2를
	 * 인자로 넘겨주면서 다음 재귀의 반복문이 2부터 시작핟록 하는 변수를 의미한다.
	 */
	public static void dfs(int at, int depth) {
			/*
			 깊이가 M이랑 같을경우 출력
			 */
			if(depth==M) {
				for(int val : arr) { // arr이라는 배열의 데이터를 0부터 마지막까지 val이라는 곳에 대입된다.
					sb.append(val).append(' ');
				}
				sb.append('\n');
				return;
			}
			/*
			 * 재귀하면서 백트래킹 할 
			 * 반복문 구현
			 */
			for(int i=at; i<=N; i++) {
				arr[depth]=i;
				dfs(i+1, depth+1);
			}
		}
	}
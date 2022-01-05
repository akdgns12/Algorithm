package 매일코딩;
//
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점(i,j)에 대해서, i에서 j로 가는
 * 경로가 있는지 없는지 구하는 프로그램을 작성하라
 * 
 * 입력 
 * 첫째줄에 정점의 개수 N(1~100)이 주어진다. 둘째줄부터 N개 줄에는 그래프의 인접행렬이 주어진다.
 * i번� 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고,
 * 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.
 */

// 플로이드 와샬 알고리즘
/*
 * 모든 정점에서 모든 정점으로의 최단거리를 구하는 알고리즘.
 * 다익스트라 알고리즘이나 벨만 포드 알고리즘은 한 정점에서 다른 모든 정점의 최단거리를 구하는 것과 차이가 있다.
 * 
 * 플로이드 와샬 알고리즘의 핵심 아이디어는 '거쳐가는 정점'을 기준으로 한다는 것
 * 즉, i에서 j까지 가는 것과 i에서 k로 가고, k에서 j로 가는 것은 같다는 의미입니다.
 * 
 * 이러한 아이디어는 문제의 조건과 완전히 부합해야 한다. 문제에서는 i에서 j로 갈 수 있는 경로가 있는지 판단해야 하기 때문이다.
 * 
 * 따라서, 거쳐가는 정점인 k가 0일 ��, 1일 때, ... , N - 1일때까지 설정해놓고,
 * arr[i][k] == 1 && arr[k][j] == 1 인 경우만 arr[i][j] == 1 로 초기화 하면 된다.
 */
public class _플로이드와샬연습문제_백준경로찾기 {
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// i에서 j까지 갈 수 있는가?
		// i에서 k로 가고, k에서 j로 갈 수 있는가?
		// 위에 2개의 질문은 동일함
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 단순히 갈 수 있는 경로가 있는지만 체크함
					if(arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

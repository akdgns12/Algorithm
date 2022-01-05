package 그래프탐색;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//플로이드 와셜 알고리즘 적용 문제
// 자신을 제외한 모든 정점에서 모든 정점에 대하여 이동할 수 있는지 파악해야 함.
/*
 * 1. 문제의 입력을 받은 배열에 대하여 플로이드 와샬 알고리즘을 취한다.
 * 2. 문제의 입력과 반대로 받은 배열에 대하여 플로이드 와샬 알고리즘을 취한다.
 * 3. 1번과 2번의 배열 or 연산
 * 4. or 연산한 배열에서 자신은 제외한 학생 모두를 탐색할 수 있는 인덱스의 
 * 개수를 계산
 * 
 */
/*
 * Floyd-Warshall 알고리즘을 이용한 방법
* 1. 플로이드 워셜 방법을 사용할 수 있는 이유는 다음과 같다. 
* 2. 플로이드 워셜 알고리즘을 통해 각 정점에서 다른 정점까지의 가장 짧은 거리를 구한다고 했을 때
* 3. dist[i][j] 는 정점 i에서 시작하여 정점 j까지의 최단거리를 의미한다. 이 때 dist[i][j] 가 존재하면 도달 할 수 있는 것이므로
* 4. 각각의 정점의 입장에서 살펴보면 i 보다 큰 정점이 + 1, j 보다 작은 정점이 + 1 이 되게 된다. 
* 5. 모든 거리 배열을 살펴봤을 때 각 정점에서의 합이 n - 1개가 되면 각 정점에서 모든 정점간의 관계를 알 수 있는 정점이다. 
*/

public class BOJ_키순서 {
	public static final int INF = (int)1e9;
	static int n,m;
	static int cnt;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n+1][n+1];
		
		//최단거리 테이블을 모두 무한으로 초기화
		//자기 자신에게 가는 비용은 0으로 초기화
		for(int i=1; i<=n; i++) {
			Arrays.fill(graph[i],  INF);
			graph[i][i] = 0;
		}
		
		//간선 정보 입력받음
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//경로가 존재한다면 cost를 1로 준다
			graph[from][to] = 1;
		}
		
		//플로이드
		for(int k=1; k<=n; k++) {//경유지
			for(int i=1; i<=n; i++) {//출발지
				for(int j=1; j<=n; j++) {//도착지
					graph[i][j] = Math.min(graph[i][j],  graph[i][k] + graph[k][j]);
				}
			}
		}
		
		
		//path[i]입장에서 보면 i보다 graph[i][j] = 1 이라는건 i보다 큰 정점이 하나 있다는 소리
		//그래서 graph[i][j]=1이면서 <INF 일때 path[i] +=1을 해주다가 path[i] == n-1이 되면 자신을 제외한 순서를
		//모두 파악 가능하기 때문에 count +=1 해주면 된다. j정점 입장에서도 같은 원리
		int[] path = new int[n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				if(graph[i][j] < INF) {
					path[i] += 1;
					path[j] += 1;
					if(path[i] == n - 1) cnt +=1;
					if(path[j] == n - 1) cnt +=1;
				}
			}
		}
		System.out.println(cnt);
	}
}

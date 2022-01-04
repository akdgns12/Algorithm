package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * [플로이드 와샬]
 * A, B, C, D, E가 있다고 하자. A와 B는 친구이고, B와 C가 친구일 때 
 * A와 C는 친구이다. 그럼 C와 D가 친구일 때 A와 D는 친구일까? 아니다. 2-친구이므로
 * 나의 친구의 친구까지 인정된다. 따라서 D는 A의 3-친구이다. 이 문제에서는 2-친구만을
 * 답으로 원하므로 플로이드 와샬을 수행하여 각 친구들이 n-친구인지 구하고 2이하인 친구들의
 * 개수를 구하도록 한다.(0일떄는 친구가 아니므로 pass, 1과 2일 때만 카운트를 증가한다)
 */
public class BOJ_친구 {
	//가장 유명한 사람의 2-친구의 수를 구하라
	// 어떤 사람 A가 또다른 사람 B의 2-친구가 되기 위해선, 두 사람이 친구이거나,
	// A와 친구이고, B와 친구인 C가 존재해야한다.
	
	// 모든 정점에서 다른 모든 정점까지를 구해야 하기 때문에 플로이드 와샬 알고리즘
	static int N;
	static int MAX_VALUE = 987654321;
	static int[][] friends; //2차원 테이블 <- 여기에 최단거리 정보를 저장
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		friends = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				if(s.charAt(j) == 'N') // 친구가 아닐 경우 MAX_VALUE
					friends[i][j] = MAX_VALUE;
				else // 친구일 경우 1
					friends[i][j] = 1;
				if(i == j) // 자기 자신과의 거리는 0으로 설정
					friends[i][j] = 0;
			}
		}
		
		// 플로이드 와샬 알고리즘 시작
		// k : 기준정점
		// i : 시작
		// j : 도착
		// i -> j로 가는 경로보다 i ->  k -> j로 가는 경로가 짧으면 값을 수정한다
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(friends[i][j] > friends[i][k] + friends[k][j])
						friends[i][j] = friends[i][k] + friends[k][j];
				}
			}
		}
		
		
		int max = 0;
		for(int i=0; i<N; i++) {
			int count = 0;
			//2-친구의 수를 구한다	
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				if(friends[i][j] <= 2) count++;
			}
			if(max < count) max = count;
		}
		System.out.println(max);

	}
}

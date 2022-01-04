package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (1)
// 백트래킹
// 중복되는 수를 제외한 모든 경우의 수를  탐색하면 됨. 기본적으로 재귀
// 재귀를 하면서 이미 방문한 노드(값)이라면 다음 노드를 탐색하기 위해(유망한 노드인지 검사하기 위해)
// M 크기의 boolean 배열을 생성하고, 탐색과정에서 값을 담을 int 배열 arr을 생성한다.
// dfs 함수에는 N과 M을 변수로 받고 depth 변수를 추가해야한다. depth를 통해 재귀가 깊어질 때마다 
// depth를 1씩 증가시켜 M과 같아지면 더이상 재귀를 호출하지 않고 탐색과정 중 값을 담았던 arr배열을 출력해주고
// return하는 역할을 위해서.

public class BOJ_15649 {
	
	static int N, M;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정적변수 N과 M을 초기화.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		
		// 정적변수를 쓰면 되기 때문에 굳이 N과 M을 넘겨줄 필요 없다
		dfs(0);
		System.out.println(sb);
	}
	
		public static void dfs(int depth) {
			
			// 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
			if (depth == M ) {
				for(int val : arr) {
					sb.append(val).append(' ');
				}
				sb.append("\n");
				return;
		}
			
			for(int i=0; i<N; i++) {
				// 만약 해당 노드(값)을 방문하지 않았다면?
				if(!visit[i]) {
					
					visit[i]=true; 	//해당노드를 방문한 상태로 변경
					arr[depth]= i+1;	// 해당 깊이를 index로 하여 i+1값 저장
					dfs(depth +1);	// 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출
					
					// 자식노드 방문이 끝나고 돌아오면 방문노드를  방문하지 않은 상태로 변경
					visit[i]= false;
				}
			}
	}
}

/*
boolean[] visit = new boolean[N];
int[] arr = new int[M];
 
public static void dfs(int N, int M, int depth) {
 
	// 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
	if (depth == M) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
		return;
	}
 
 
	for (int i = 0; i < N; i++) {
 
		// 만약 해당 노드(값)을 방문하지 않았다면?
		if (visit[i] == false) {
			
			visit[i] = true;		// 해당 노드를 방문상태로 변경
			arr[depth] = i + 1;		// 해당 깊이를 index로 하여 i + 1 값 저장
			dfs(N, M, depth + 1);	// 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출
            
			// 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
			visit[i] = false;
		}
	}
	return;
}
*/
package 그래프탐색;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * <풀이>
 * 부모 인덱스를 입력받고 , 노드를 삭제한 후 리프 노드를 count하는 문제로 
 * dfs적용하여 문제 풀기
 * 노드를 삭제할 때는 재귀함수를 이용하여 현재 노드의 부모 인덱스가 삭제된 노드라면
 * 연쇄적으로 삭제가 일어나도록 구현한다.
 * 리프노드를 카운트 할 때에는 dfs를 활용하여 현재 노드를 부모로 가지는 노드가
 * 하나라도 존재한다면 자식노드를 연쇄적으로 탐색하도록 하였다. 재귀 함수 속
 * 에서 자식노드가 하나라도 존재하는지를 기록해 주기 위해 boolean타입의 변수를
 * 하나 생성해준다. 자식 노드가 없다면 리프노드의 카운트를 증가시킨다.
 */
public class BOJ_트리 {
	static int n, delete;
	static int[] parent;
	static int count;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//노드의 개수 n
		n = Integer.parseInt(br.readLine());
		parent = new int[n];
		int root = 0;
		
		//각 노드의 부모 정보 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
			if(parent[i] == -1) root = i;
		}
		
		//삭제하는 노드
		delete = Integer.parseInt(br.readLine());
		
		deleteNode(delete);
		
		count = 0;
		visited = new boolean[n];
		countLeaf(root);
		
		System.out.println(count);		
	}
	
	public static void deleteNode(int d) {
		parent[d] = -2; // 삭제된 노드 -2로 표시
		for(int i=0; i<n; i++) {
			if(parent[i] == d) {
				deleteNode(i);
			}
		}
	}
	
	public static void countLeaf(int s) {
		boolean isLeaf = true;
		visited[s] = true;
		if(parent[s] != -2) {
			for(int i=0; i<n; i++) {
				if(parent[i] == s && visited[i] == false) {
					countLeaf(i);
					isLeaf = false;
				}
			}
			if(isLeaf) count++;
		}
	}
	
}

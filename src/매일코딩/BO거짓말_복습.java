package 매일코딩;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BO거짓말_복습 {
	// 1. 진실을 아는 사람들의 정보를 list에 담는다
	// 2. 진실을 아는 사람들의 파티를 조사하여 해당 파티원들을 
	//    모두 진실을 아는 사람들의 정보 list에 추가한다
	// 3. 이미 진실을 알고 있는 사람이거나, 이미 확인한 파티는 조사하지 않는다.
	
	static int N, M;
	// 진실을 알고 있는 사람들의 번호 담을 list
	static ArrayList<Integer> truth = new ArrayList<>();
	static ArrayList<Integer>[] party; // 각 파티 정보 담을 list배열
	static int total_party;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int T = sc.nextInt(); // 진실을 알고 있는 사람 수
		for(int i=0; i<T; i++) { // 진실을 알고 있는 사람 번호 list에 넣어줌
			truth.add(sc.nextInt());
		}
		
		party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<>();
			
			int num = sc.nextInt();
			for(int j=0; j<num; j++) {
				party[i].add(sc.nextInt());
			}
		}
		
		total_party = M;
		bfs();
		System.out.println(total_party);
		
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] people_visited = new boolean[N+1]; // 검사한 사람 체크할 배열
		boolean[] party_visited = new boolean[M]; // 검사한 파티 체크할 배열
		// 진실을 알고 있는 사람의 수 큐에 넣어주기
		for(int i=0; i<truth.size(); i++) {
			q.offer(truth.get(i));
			people_visited[truth.get(i)] = true;
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<M; i++) {
				if(!party_visited[i] && party[i].contains(Integer.valueOf(cur))) {
					for(int j=0; j<party[i].size(); j++){
						int next = party[i].get(j);
						if(!people_visited[next]) {
							people_visited[next] = true;
							q.offer(next);
						}
					}
					total_party--;
					party_visited[i] = true;
				}
			} // end For
		} // end While
	}
}

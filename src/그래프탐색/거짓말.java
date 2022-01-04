package 그래프탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 거짓말 {
	// BOJ 거짓말 / 골드 4 / 그래프 탐색 / 거짓말 할 수 있는 파티의 최댓값 리턴
	/*
	 * 문제의 조건을 정리해보자
	 * 지민 -> 진실 or 과장(되도록 과장 but 거짓말을 들키기 싫어함)
	 * 진실 아는 사람 존재 - > 과장 할 수 없음
	 * 진실을 한 번이라도 들은 사람은 진실을 아는 사람
	 * 
	 * 풀이 순서
	 * 1. 진실을 아는 사람들의 정보를 모은다
	 * 2. 진실을 아는 사람이 속해있는 파티를 조사하여 해당 파티원들을 전부 진실을 아는 사람들의 정보에 추가한다.
	 * 3. 이미 진실을 아는 사람이거나, 이미 확인한 파티는 조사하지 않는다.
	 * 
	 * <진실을 아는 사람들의 정보를 모은다>
	 *  - 진실을 아는 사람들의 정보를 입력 받을떄면서 리스트에 저장해 준다
	 *  
	 *  <진실을 아는 사람이 속해있는 파티를 조사하여 해당 파티원들을 진실을 아는 사람들의 정보에 추가한다>
	 *  - BFS탐색을 사용. 위상정렬과 비슷. 
	 *  - 먼저 큐에 진실을 아는 사람들의 정보를 담아주고 한명 한명 씩 속해있는 파티를 조사해준다.
	 *  - 조사할 때는 조사하지 않은 파티 중에서, 현재 사람이 속해있는 파티를 조사
	 *  - 만약 이미 진실을 알고 있는 사람을 발견하면 다시 그 사람을 확인하지 않아도 되므로
	 *  진실을 모르는 사람들의 정보를 큐에 담아준다.
	 *  - 현재 사람이 속해있는 파티가 존재했다면 해당 파티는 더 이상 과장되서 말할 수 없는
	 *  파티가 되므로 현재까지 과장되어 말할  수 있는 파티의 개수에서 1을 줄여준다.
	 *  
	 *  <이미 진실을 아는 사람이거나, 이미 확인한 파티는 조사하지 않는다>
	 *  - 파티 방문 여부를 체크하는 boolean배열과, 이미 진실을 알고 있는 사람여부를 체크하는
	 *  boolean 배열을 사용
	 */
	static int N,M;
	static int total_party;
	static ArrayList<Integer> truth = new ArrayList<>();
	static ArrayList<Integer>[] party;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 사람 수
		M = sc.nextInt(); // 파티 수
		
		int t = sc.nextInt(); // 진실을 아는 사람의 수
		for(int i=0; i<t; i++) { // 진실을 아는 사람의 번호 truth 리스트에 담기
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
		find_truth();
		System.out.println(total_party);
	}
	
	public static void find_truth() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] party_visited = new boolean[M];
		boolean[] people_visited = new boolean[N+1];
		for(int i=0; i<truth.size(); i++) {
			q.offer(truth.get(i));
			people_visited[truth.get(i)] = true;
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<M; i++) {
				if(!party_visited[i] && party[i].contains(Integer.valueOf(cur))) {
					for(int j=0; j<party[i].size(); j++) {
						int next = party[i].get(j);
						if(!people_visited[next]) {
						people_visited[next] = true;
						q.offer(next);
						}
					}
					total_party--;
					party_visited[i] = true;
				}
			}
		}
	}
}

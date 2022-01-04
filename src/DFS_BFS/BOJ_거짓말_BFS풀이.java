package DFS_BFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * [문제 조건 정리]
 * 지민 -> 진실 or 과장(되도록 과장 but 거짓말 들키기 싫어함)
 * 진실 아는 사람 존재 -> 과장 할  수 없음.
 * 진실을 한번이라도 들은 사람은 진실을 아는 사람이다.
 * 
 * [풀이 순서]
 * 1. 진실을 아는 사람들의 정보를 모은다.
 * 2. 진실을 아는 사람이 속해있는 파티를 조사하여 해당 파티원들 전부 진실을 아는 사람들의 정보에 추가한다.
 * 3. 이미 진실을 아는 사람이거나, 이미 확인한 파티는 조사하지 않는다.
 * 
 * - 진실을 아는 사람들의 정보를 모은다.
 *  진실을 아는 사람들의 정보를 입력 받을때면서  리스트에 저장해 주었다.
 *  - 진실을 아는 사람이 속해있는 파티를 조사하여 해당 파티원들을 진실을 아는 사람들의 정보에 추가한다.
 *  BFS탐색을 사용. 
 *  먼저, 큐에 진실을 아는 사람들의 정보를 담아주고 한명 한명씩 속해있는 파티를 조사해준다.
 *  조사할 때는 조사하지 않은 파티 중에서, 현재 사람이 속해있는 파티를 조사해 주었다.
 *  만약 이미 진실을 알고 있는 사람을 발견하면 다시 그 사람을 확인하지 않아도 되므로 진실을 모르는 사람들의 정보를 큐에 담는다.
 *  현재 사람이 속해있는 파티가 존재했다면 해당 파티는 더 이상 과장되서 말할 수 없는 파티가 되므로 현재까지 과장되어 말할 수 있는 파티의 개수에서
 *  1을 줄여준다.
 *  
 *  - 이미 진실을 아는 사람이거나, 이미 확인한 파티는 조사하지 않는다.
 */
public class BOJ_거짓말_BFS풀이 {
	
	static ArrayList<Integer> truth = new ArrayList<>();
	static ArrayList<Integer>[] party;
	static int n,m;
	static int total_party;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 사람 수
		m = sc.nextInt(); // 파티 수
		
		int t = sc.nextInt(); // 진실을 아는 사람의 수
		for(int i=0; i<t; i++) {
			truth.add(sc.nextInt()); // 진실을 아는 사람의 번호 list에 추가
		}
		
		party = new ArrayList[m];
		for(int i=0; i<m; i++) { // 파티 정보 입력받기 시작
			party[i] = new ArrayList<>();
			
			int num = sc.nextInt();
			for(int j=0; j<num; j++) { // 파티에 오는 사람의 번호정보 party list에 저장
				party[j].add(sc.nextInt());
			}
		}
		
		total_party = m; // 진실을 아는 사람이 포함된 파티 줄여나가갈 것이므로 초기는 파티 수 전체
		find_truth(); //BFS 시작
		System.out.println(total_party);
	}
	
	public static void find_truth() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] party_visited = new boolean[m]; // 파티 방문 여부를 체크하는 bool 배열
		boolean[] people_visited = new boolean[n+1]; // 이미 진실을 알고있는 사람 여부 체크하는 bool 배열
		// 먼저, 큐에 진실을 아는 사람들의 정보를 담아준다.
		for(int i=0; i<truth.size(); i++) {
			q.offer(truth.get(i));
			people_visited[truth.get(i)] = true;
		}
		
		// 한명 한명씩 속해있는 파티를 조사한다.
		while(!q.isEmpty()) {
			int current = q.poll(); // 현재사람
			
			for(int i=0; i<m; i++) {
				// 조사할 때는 조사하지 않은 파티 중에서, 현재 사람이 속해있는 파티를 조사해준다.
				if(!party_visited[i] && party[i].contains(Integer.valueOf(current))) {
					for(int j=0; j<party[i].size(); i++) {
						// 만약 진실을 알고있는 사람을 발견하면 다시 그 사람을 확인하지 않아도 되므로 
						// 진실을 모르는 사람들의 정보를 큐에 담아준다.
						int next = party[i].get(j);
						if(!people_visited[next]) {
							people_visited[next] = true;
							q.offer(next);
						}
					}
					
					// 현재 사람이 속해있는 파티가 존재했다면 해당 파티는 더 이상 과장되서
					// 말할 수 없는 파티가 되므로 현재까지 과장되어 말할 수 있는 파티의 개수에서
					// 1을 줄여준다.
					total_party--;
					party_visited[i] = true;
				}
			}
		}
	}
}

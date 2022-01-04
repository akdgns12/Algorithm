package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
/*
 * 최댓값과 최솟값을 출력해주기 위해 remove메소드를 사용하여 큐를 탐색한 다음 제거했다.
 * O(n)의 시간복잡도로 시간초과....
 * TreeMap 사용하여 탐색시간 해결가능
 * 1. 데이터를 key값에 의해 자동으로 정렬시켜 저장
 * 2. 해당 데이터 구조는 트리형태로 탐색속도는 O(logN)
 * 
 * 우선순위 큐와 Map의 사용목적을 TreeMap하나로 해결 가능
 */
/*
 * What is TreeMap?
 * TreeMap은 이진트리를 기반으로 한 Map 컬렉션. 같은 Tree구조로 이루어진 TreeSet과의 차이점은
 * TreeSet은 그냥 값만 저장한다면 TreeMap은 키와 값이 저장된 Map, Entry를 저장한다는 점. TreeMap에
 * 객체를 저장하면 자동으로 정렬되는데, 키는 저장과 동시에 오름차순으로 정렬되고 숫자 타입을 경우네는 값으로, 문자열 타입일 경우에는
 * 유니코드로 정렬한다. 정렬 순서는 기본적으로 부모 키값과 비교해서 키 값이 낮은 것은 왼쪽 자식 노드에 키값이 높은 것은 오른쪽 자식 노드에 Map.Entry 객체를 저장한다.
 * TreeMap은 일반적으로 Map으로써의 성능이 HashMap보다 떨어진다. TreeMap은 데이터를 저장할 때 즉시 정렬하기에 추가나 삭제가 HashMap보다 오래걸린다.
 * 하지만 정렬된 상태로 Map을 유지해야 하거나 정렬된 데이터를 조회해야 하는 범위 검색이 필요한 경우 TreeMap을 사용하는 것이 효율성면에서 좋다.
 * 
 * (Red-Black-Tree)
 * TreeMap은 이진탐색트리의 문제점을 보완한 레드블랙트리로 이루어져 있다. 일반적인 이진 탐색 트리는 트리의 높이만큼 시간이 필요하다. 값이 전체 트리에 잘 분산되어 있다면
 * 효율성에 있어 크게 문제가 없으나 데이터가 들어올 때 값이 한쪽으로 편향되게 들어올 경우 한쪽 방면으로 크게 치우쳐진 트리가 되어 굉장히 비효율적인 퍼포먼스를 낸다. 이 문제를 보완하기 위해
 * 레드블랙트리가 등장. 레드블랙트리는 부모 노드보다 작은 값을 가지는 노드는 왼쪽 자식으로, 큰 값을 가지는 노드는 오른쪽 자식으로 배치하여 데이터의 추가나 삭제시 트리가 한쪽으로 치우쳐지지 않도록
 * 균형을 맞춰준다.
 * 
 * TreeMap<key, value>
 * key는 자동으로 오름차순 정렬
 */

public class BOJ_이중우선순위큐_TreeMap사용법 {
	static int T; // 입력 데이터의 수
	static int K; // 적용할 연산의 개수
	static TreeMap<Integer, Integer> map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int K = Integer.parseInt(br.readLine());
			map = new TreeMap<>();
			
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(command.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1); // 숫자와 해당 숫자의 개수 저장
					
				}else if(command.equals("D")){
					if(map.size() == 0) continue; // 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우ㅡ, 해당 연산은 무시
					
					int tgt = (num == 1 ? map.lastKey() : map.firstKey());
					
					int cnt = map.put(tgt, map.get(tgt) - 1);
					if(cnt == 1) map.remove(tgt);
				}
			}
			
			if(map.size() == 0) {
				System.out.println("EMPTY");
			}else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		} // End of For
	}
}

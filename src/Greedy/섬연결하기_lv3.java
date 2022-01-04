package Greedy;

import java.util.Arrays;
import java.util.Comparator;
/*
 * 1. Union-Find(합집합 찾기)
 * 두 개의 정점이 같은 부모로 연결되어있는지 확인할 수 있는 알고리즘.
 * 각 정점마다, 가지고 있는 최상위 부모 노드를 기록한다
 * 부모의 기준은 더 작은 수가 된다.
 * 정점 2가 1의 부모를 가지고 있다면 arr[2] = 1; 과같이 표현.
 * 
 * 2.크루스칼 알고리즘
 * 가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘.
 * 먼저 주어진 가중치를 오름차순으로 정렬한다.
 * 그리고 낮은 가중부터 정점을 연결하면서 그래프를 만들어간다.
 * 그래프를 만들면서 주의해야 할 점은, 연결하려는 두 정점이 이미 연결되어있다면
 * 제외시켜주어야 한다는 것.
 * 그렇기 때문에, 연결 할 수 없는 경우는 Skip, 연결 할 수 있는 경우에는 최상위
 * 부모 노드를 update수행해준다.
 * 이렇게 주어진 그래프의 모든 정점을 낮은 가중치를 기준으로 붙여 나가다 보면, 
 * 최소비용을 사용하는 정점을 먼저 연결하고 이후에 나온 비용이 큰 노드는 
 * skip처리가 되어 모든 정점을 최소비용으로 연결할 수 있게 된다.
 * 
 */
public class 섬연결하기_lv3 {
	static int[] findParent;  //부모와 자식의 정보가 담긴 배열
	
	public int find(int child) {
		if(findParent[child] == child) { //부모 찾기
			return child;
		}else {
			return findParent[child] = find(findParent[child]);
		}
		
	}
	
	public int solution(int n, int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() { //가중치 기준으로 오름차순
			@Override
			public int compare(int[] o1, int[] o2) {
				Integer a = o1[2];
				Integer b = o2[2];
				return a.compareTo(b);
			}
		});
		
		findParent = new int[n]; // 초기배열에서 부모는 자기자신.
		for(int i=0; i<n; i++) {
			findParent[i] = i;
		}
		
		int answer = 0;
		for(int i=0; i<costs.length; i++) {
			int firstIsland = find(costs[i][0]);
			int secondIsland = find(costs[i][1]);
			if(firstIsland != secondIsland) { //부모가 같지 않다면 연결이 안된 최솟값이므로
				findParent[secondIsland] = firstIsland; //연결
				answer += costs[i][2];
			}
		}
		
		return answer;
	}
}

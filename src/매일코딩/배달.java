package 매일코딩;

public class 배달 {
	import java.util.*;

	//우선순위 큐에 데이터가 들어갈 때 거리가 더 낮은 값이 우선순위를 갖도록 하기 위해 Compare 클래스 사용
	class Node implements Comparable<Node> {
	    private final int index; //노드번호
	    private final int cost; //거리

	    public Node(int index, int cost) {
	        this.index = index;
	        this.cost = cost;
	    }

	    public int getIndex() {
	        return index;
	    }

	    public int getCost() {
	        return cost;
	    }

	    @Override
	    public int compareTo(Node o) {
	        return Integer.compare(this.cost, o.cost);
	    }
	}

	// 프로그래머스 배달 문제
	class Solution {
	    static List<List<Node>> graph = new ArrayList<>(); 
	    static int[] d; //최단 거리 테이블
	    static int INF = (int) 1e9;

	    public int solution(int N, int[][] road, int K) {
	        d = new int[N + 1];
	        Arrays.fill(d, INF); //최단거리 테이블 무한대로 초기화
	        //그래프 초기화
	        for (int i = 0 ; i <= N; i++) {
	            graph.add(new ArrayList<>());
	        }
	        
	        //road에 있는 간선정보 받아오기
	        for (int[] street : road) {
	            int nodeA = street[0]; //노드A
	            int nodeB = street[1]; //노드B
	            int cost = street[2]; //거리

	            graph.get(nodeA).add(new Node(nodeB, cost)); //A에서 B로가는 거리
	            graph.get(nodeB).add(new Node(nodeA, cost)); //B에서 A로가는 거리
	        }

	        dijkstra();

	        int answer = 0;
	        for (int i = 1; i <= N; i++) {
	            if (d[i] <= K) {
	                answer++;
	            }
	        }
	        return answer;
	    }

	    static void dijkstra() {
	        PriorityQueue<Node> pq = new PriorityQueue<>();
	        pq.offer(new Node(1, 0)); // 시작 노드 거리 0 초기 삽입
	        d[1] = 0;

	        while (!pq.isEmpty()) {
	            Node node = pq.poll();
	            int nIdx = node.getIndex(); //현재 노드
	            int nCost = node.getCost(); //현재 노드까지의 거리
	            
	            //현재 노드가 이미 처리된 적 있는 노드라면 무시
	            if (d[nIdx] < nCost) {
	                continue;
	            }

	            List<Node> nodes = graph.get(nIdx);
	            for (Node next : nodes) {
	                int cost = next.getCost() + nCost;

	                if (cost < d[next.getIndex()]) {
	                    d[next.getIndex()] = cost;
	                    pq.offer(new Node(next.getIndex(), cost));
	                }
	            }
	        }
	    }
	}
}

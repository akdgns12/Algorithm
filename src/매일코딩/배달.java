package �����ڵ�;

public class ��� {
	import java.util.*;

	//�켱���� ť�� �����Ͱ� �� �� �Ÿ��� �� ���� ���� �켱������ ������ �ϱ� ���� Compare Ŭ���� ���
	class Node implements Comparable<Node> {
	    private final int index; //����ȣ
	    private final int cost; //�Ÿ�

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

	// ���α׷��ӽ� ��� ����
	class Solution {
	    static List<List<Node>> graph = new ArrayList<>(); 
	    static int[] d; //�ִ� �Ÿ� ���̺�
	    static int INF = (int) 1e9;

	    public int solution(int N, int[][] road, int K) {
	        d = new int[N + 1];
	        Arrays.fill(d, INF); //�ִܰŸ� ���̺� ���Ѵ�� �ʱ�ȭ
	        //�׷��� �ʱ�ȭ
	        for (int i = 0 ; i <= N; i++) {
	            graph.add(new ArrayList<>());
	        }
	        
	        //road�� �ִ� �������� �޾ƿ���
	        for (int[] street : road) {
	            int nodeA = street[0]; //���A
	            int nodeB = street[1]; //���B
	            int cost = street[2]; //�Ÿ�

	            graph.get(nodeA).add(new Node(nodeB, cost)); //A���� B�ΰ��� �Ÿ�
	            graph.get(nodeB).add(new Node(nodeA, cost)); //B���� A�ΰ��� �Ÿ�
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
	        pq.offer(new Node(1, 0)); // ���� ��� �Ÿ� 0 �ʱ� ����
	        d[1] = 0;

	        while (!pq.isEmpty()) {
	            Node node = pq.poll();
	            int nIdx = node.getIndex(); //���� ���
	            int nCost = node.getCost(); //���� �������� �Ÿ�
	            
	            //���� ��尡 �̹� ó���� �� �ִ� ����� ����
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

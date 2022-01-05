package ���ͽ�Ʈ��_�ִܰ�ξ˰���;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
//
public class ��å {
	static class Node implements Comparable<Node>{
		int end, dist;
		public Node(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			return this.dist - other.dist;
		}
	}
    final static int INF =(int)1e9;
    static ArrayList<Node>[] list;
    static int []distS;
    static int []distE;
    static int []used;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        used = new int[N];
        distS = new int[N];
        distE = new int[N];
        list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            distS[i] = distE[i] = INF;
        }

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1; // 0-based
            int b = sc.nextInt() - 1; // 0-based
            
            list[a].add(new Node(b,1));
            list[b].add(new Node(a,1));
        }

        int S = sc.nextInt() - 1; // 0-based
        int E = sc.nextInt() - 1; // 0-based

        Dijkstra(distS, S); // 1. S���� ��� ������ ���� �ִ� �Ÿ��� ���Ͽ� distS�� ����
        Dijkstra(distE, E); // 2. E���� ��� ������ ���� �ִܰŸ��� ���Ͽ� distE�� ����
        long ans = distS[E]; // distS[E](S���� E������ �ִܰŸ�)�� ���� ���ϰ� ans�� ����        

        /*
         * 4. distS,distE�� �̿��� S->E���� �ִ� �Ÿ��� �̵��ϸ鼭 �̵��� ��ε� �� ���� ������ �ռ� ���� ã�´�.
			4.1 S���� �����Ͽ� S�� ����� ���� ��带 N�̶� �� ��, dist[S]+N���� ���� �Ÿ�(����ġ) + distE[N] == distS[E]
    			��� �ش� ���� �ִ� ��ο� ���� ��尡 �´�. 
			4.2 S���� �����Ͽ� S�� ����� �� �ٸ� ���� ��带 M�̶� �� ��, 4.1�� ������ �ݺ��� ��, N,M�� ���Ͽ� ���� ����
    			���� ������ �ռ� ��ΰ� �ȴ�. 
			4.3 N,M�� ���� ���� N�̶�� �� ��, S�� N���� ������ �ش�.
			4.4 ���� 4.1~4.3 ������ S�� E�� �� ������ �ݺ��ϰ�, ���⼭ ���� ������ used[]�迭�� true�� �����Ͽ� S->E���� 
     			���� �������� �����Ѵ�.
			5. used�迭�� true�� ����Ǿ� �ִ�(S->E ��ο��� �̹� �����)������ �����ϰ� ���ͽ�Ʈ�� ���� ��, distE[S]����
   				answer�� �����ش�. 
         */
        eraseEdge(S, E);
        
        for(int i = 0; i < N; i++) distE[i] = INF;

        Dijkstra(distE, E);
        ans += distE[S];
        
        System.out.println(ans);
    }

    static public void Dijkstra(int []dist, int S) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[S] = 0;
        pq.offer(new Node(S, 0));
        while(!pq.isEmpty()) {
        	Node node = pq.poll();
        	int now = node.end;
            if(dist[node.dist] != node.end) continue;
            for(Node next : list[now]) {
                int nxt = (int)next.end;
                if(used[nxt] == 1) continue;
                if(dist[nxt] > dist[node.end] + next.end) {
                    dist[nxt] = dist[node.end] + next.end;
                    pq.add(new Node(dist[nxt], nxt));
                }
            }
        }
    }

    static void eraseEdge(int S, int E) {
        int pre = S;
        while(S != E) { // S�� E�� �ɶ�����
            int min = Integer.MAX_VALUE;
            //S���� �����Ͽ� S�� ����� ���� ��带 N�̶� �� ��, dist[S]+N���� ���� �Ÿ�(����ġ) + distE[N] == distS[E]
        		//	��� �ش� ���� �ִ� ��ο� ���� ��尡 �´�.
            for(Node next : list[S]) {
                int nxt = (int)next.end;
                if(nxt == pre) continue;
                if(distS[S] + next.dist + distE[nxt] == distS[E]) {
                    min = Math.min(min, nxt);
                }
            }
            pre = S;
            S = min;
            if(S != E) used[S] = 1;
        }
    }
}
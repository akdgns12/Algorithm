package 다익스트라_최단경로알고리즘;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
//
public class 산책 {
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

        Dijkstra(distS, S); // 1. S에서 모든 정점에 대한 최단 거리를 구하여 distS에 저장
        Dijkstra(distE, E); // 2. E에서 모든 정점에 대한 최단거리를 구하여 distE에 저장
        long ans = distS[E]; // distS[E](S에서 E까지의 최단거리)를 최종 리턴값 ans에 저장        

        /*
         * 4. distS,distE를 이용해 S->E까지 최단 거리로 이동하면서 이동한 경로들 중 사전 순으로 앞선 값을 찾는다.
			4.1 S에서 시작하여 S와 연결된 다음 노드를 N이라 할 때, dist[S]+N노드로 가는 거리(증가치) + distE[N] == distS[E]
    			라면 해당 노드는 최단 경로에 사용된 노드가 맞다. 
			4.2 S에서 시작하여 S와 연결된 또 다른 다음 노드를 M이라 할 때, 4.1의 과정을 반복한 후, N,M을 비교하여 낮은 수가
    			사전 순으로 앞선 경로가 된다. 
			4.3 N,M중 작은 수가 N이라고 할 때, S를 N으로 갱신해 준다.
			4.4 위의 4.1~4.3 과정을 S가 E가 될 때까지 반복하고, 여기서 구한 노드들을 used[]배열에 true로 저장하여 S->E에서 
     			사용된 노드들임을 저장한다.
			5. used배열에 true로 저장되어 있는(S->E 경로에서 이미 사용한)노드들을 제외하고 다익스트라를 돌린 후, distE[S]값을
   				answer에 더해준다. 
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
        while(S != E) { // S가 E가 될때까지
            int min = Integer.MAX_VALUE;
            //S에서 시작하여 S와 연결된 다음 노드를 N이라 할 때, dist[S]+N노드로 가는 거리(증가치) + distE[N] == distS[E]
        		//	라면 해당 노드는 최단 경로에 사용된 노드가 맞다.
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
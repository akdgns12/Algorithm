package 다익스트라_최단경로알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {
	// BOJ 1753 최단경로 / 골 5 / 다익스트라 -> 최단경로 알고리즘
	/* - 출발점에서 목표지점까지의 최단경로 구하는 알고리즘
	 * 현재까지 알고있던 최단경로를 계속해서 갱신하는 것
	 * 1. 출발지 정점에서 연결된 정점의 가중치 값 입력
	   2. 방문하지 않았고 가장 작은 가중치의 값을 가지고 있는 정점 방문
 	   3. 방문한 정점에서 연결된 정점들의 가중치 값 업데이트 minimum(연결된 정점의 현재 값, 현재 정점의 값 + 연결된 간선의 가중치)
	   4. 2~3 반복
	 */
	// 다음 노드의 인덱스와, 그 노드로 가는데 필요한 비용을 담고 있는 클래스
	static ArrayList<Node> list[];
    static int distance[];
    static boolean visit[];
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(stz.nextToken()); // 정점의 개수
        int e = Integer.parseInt(stz.nextToken()); // 간선의 개수
        int start = Integer.parseInt(br.readLine()); // 시작 정점
        
        visit = new boolean[v+1];
        list = new ArrayList[v+1];
        distance = new int[v+1];
        Arrays.fill(distance, -1);
        
        for(int i = 1; i <= v; i++)
            list[i] = new ArrayList<>();
         
        for(int i = 0; i < e; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int dist = Integer.parseInt(stz.nextToken());
            list[start].add(new Node(b, dist));
        }
        
        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= v; i++)
            sb.append(distance[i] == -1 ? "INF" : distance[i]).append("\n");
        System.out.print(sb.toString());
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(!visit[now.end]) {
                visit[now.end] = true;
                
                for(Node next : list[now.end]) {
                    if(distance[next.end] == -1 || distance[next.end] > distance[now.end] + next.dist) {
                        distance[next.end] = distance[now.end] + next.dist;
                        pq.offer(new Node(next.end, distance[next.end]));
                    }
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int end, dist;
        
        Node(int end, int dist){
        	this.end = end;
        	this.dist = dist;
        }
        
        public int compareTo(Node other) {
            return dist - other.dist;
        }
    }
}
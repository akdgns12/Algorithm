package ���ͽ�Ʈ��_�ִܰ�ξ˰���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class �ִܰ�� {
	// BOJ 1753 �ִܰ�� / �� 5 / ���ͽ�Ʈ�� -> �ִܰ�� �˰���
	/* - ��������� ��ǥ���������� �ִܰ�� ���ϴ� �˰���
	 * ������� �˰��ִ� �ִܰ�θ� ����ؼ� �����ϴ� ��
	 * 1. ����� �������� ����� ������ ����ġ �� �Է�
	   2. �湮���� �ʾҰ� ���� ���� ����ġ�� ���� ������ �ִ� ���� �湮
 	   3. �湮�� �������� ����� �������� ����ġ �� ������Ʈ minimum(����� ������ ���� ��, ���� ������ �� + ����� ������ ����ġ)
	   4. 2~3 �ݺ�
	 */
	// ���� ����� �ε�����, �� ���� ���µ� �ʿ��� ����� ��� �ִ� Ŭ����
	static ArrayList<Node> list[];
    static int distance[];
    static boolean visit[];
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(stz.nextToken()); // ������ ����
        int e = Integer.parseInt(stz.nextToken()); // ������ ����
        int start = Integer.parseInt(br.readLine()); // ���� ����
        
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
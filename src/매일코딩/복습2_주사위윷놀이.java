package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ����2_�ֻ��������� {
	static class Node{
		int score;
		boolean isEmpty;
		boolean isFinish;
		Node next;
		Node fastPath;
		
		public Node(int score) {
			this.score = score;
			this.isEmpty = true;
		}
		
		// ���� 
		public Node addNext(int score) {
			Node nextNode = new Node(score);
			this.next = nextNode;
			return nextNode;
		}
		
		// ��� ã��(������ ���� ������ ã�� ���� �Լ�)
		public static Node getNode(Node start, int target) {
			Node temp = start;
			while(true) { // ���� �������� Ž���ذ��� Ư�� ��带 ã�´�
				if(temp == null) return null;
				if(temp.score == target) return temp;
				temp = temp.next;
			}
		}
	}
	static int[] dice, order; // �ֻ���, ��ġ ����
	static Node[] horse; // 4���� ��
	static Node start;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dice = new int[10+1];
		order = new int[10+1];
		horse = new Node[4+1];
		
		for(int i=1; i<=10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		init(); // �U������ ����
		permutation(1); // 10���� �Ͽ� ���� 4���� ���� ���� ��ġ ����
		System.out.println(answer);
	}
	
	public static void init() {
		start = new Node(0); // ���� ������ ���ھ�� 0
		
		Node temp = start;
		for(int i=2; i<=40; i+=2) { // �������� �ٱ��� ��� ����
			temp = temp.addNext(i);
		}
		
		Node end = temp.addNext(0);
		end.isFinish = true;
		end.next = end;
		
		Node crossroads = new Node(25);
		
		// ������(25) -> 30 -> 35 -> 40
		temp = crossroads.addNext(30);
		temp = temp.addNext(35);
		temp.next = Node.getNode(start, 40);
		
		// 10 -> 13 -> 16 -> 19 -> 25(������)
		temp = Node.getNode(start, 10);
		temp = temp.fastPath = new Node(13);
		temp = temp.addNext(16);
		temp = temp.addNext(19);
		temp.next = crossroads;
		
		// 20 -> 22 -> 24 -> 25
		temp = Node.getNode(start, 20);
		temp = temp.fastPath = new Node(22);
		temp = temp.addNext(24);
		temp.next = crossroads;
		
		// 30 -> 28 -> 27 -> 26 -> 25(������)
        temp = Node.getNode(start, 30);
        temp = temp.fastPath = new Node(28);
        temp = temp.addNext(27);
        temp = temp.addNext(26);
        temp.next = crossroads;
	}
	
	public static void permutation(int depth) {
		if(depth >= 11) {
			answer = Math.max(answer, gameStart());
			return;
		}
		
		for(int i=1; i<=4; i++) {
			order[depth] = i;
			permutation(depth + 1);
		}
	}
	
	public static int gameStart() {
		Arrays.fill(horse, start); // ������ ���� �������� ��ġ
		
		int score = 0;
		for(int i=1; i<=10; i++) {
			Node cur = horse[order[i]]; // ������ �Ҵ�� ������� ������ �����δ�.
			cur.isEmpty = true; // ���� �ִ� ĭ�� ����ش�.
			
			for(int j=1; j<=dice[i]; j++) { // �ֻ����� ���� ��ġ��ŭ �̵�
				if(j==1 && cur.fastPath != null) {// ó�� �̵��� �����ϴ� ��ġ�� �Ķ��� ĭ�̶��
					cur = cur.fastPath; // ������� �̵�(�Ķ��� ����)
				}else {
					cur = cur.next;
				}
			}
			
			horse[order[i]] = cur; // �̵� ��, �� ��ġ ����
			
			if(!cur.isEmpty && !cur.isFinish) { // �̵��� ��ģ ĭ�� �ٸ� ���� �ִٸ�, �ش縻�� �� �� ����.
				score = 0 ; // �ֻ����� �Ҵ���� ������ ������ ��ȿó��.
				break;
			}else {
				cur.isEmpty = false; // ���� �����ϴ� ������ ǥ��
				score += cur.score;
			}
	}// ���� ����
		
		// ���� ������ ���� ������ ��ġ�� �����ش�.
		for(int i=1; i<=4; i++) {
			horse[i].isEmpty = true;
		}
		return score;
}
	
}

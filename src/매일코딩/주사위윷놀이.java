package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 처음에는 시작칸에 말 4개가 있다
 * 말은 게임판에 그려진 화살표의 방향대로만 이동가능
 * 말이 파란색 칸에서 이동을 시작하면 파란색 화살표를 타야함.
 * 이동하는 도중ㅇ거나 파란색이 아닌 칸에서 이동을 시작하면 빨간색 화살표를 타야함.
 * 말이 도착 칸으로 이동하면 주사위에 나온 수와 관계없이 이동 끝
 * 게임은 10개의 턴으로 이루어짐. 매 턴 마다 1부터 5까지 한 면에 하나씩 적혀있는 5면체 주사위
 * 를 굴리고, 도착 칸에 있지 않은 말을 하나 골라 주사위에 나온 수 만큼 이동.
 */
public class 주사위윷놀이 {
	static class Node{ // 윷놀이판을 연결리스트 구조에 담는다.
		int score; // 해당 칸의 점수
		boolean isEmpty; // 해당 칸이 비었는지(다른 말이 있는지 체크)
		boolean isFinish; // 도착지점인지 체크
		Node next;
		Node fastPath; // 윷놀이판에서 10, 20, 30은 두가지 방향이 존재한다.
		
		public Node(int score) {
			this.score = score;
			this.isEmpty = true;
		}
		
		// 노드 연결(연결 리스트 구조)
		public Node addNext(int score) {
			Node nextNode = new Node(score);
			this.next = nextNode;
			return nextNode;
		}
		
		// 노드 찾기(지름길 놓는 지점을 찾기 위한 함수)
		public static Node getNode(Node start, int target) {
			Node temp = start;
			while(true) { // 시작 지점부터 탐색해가며 특정 노드를 찾는다.
				if(temp == null) return null;
				if(temp.score == target) return temp;
				temp = temp.next;
			}
		}
	}
	
	static int[] dice, order; // 주사위, 배치순서
	static Node[] horse; // 4개의 말
	static Node start; // 시작지점
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
		
		init(); // 윷놀이판 설정
		permutation(1); // 10개의 주사위 결과를 말들에게 할당
		System.out.println(answer);
	}
	// 10개의 턴에 대한 4개의 말들의 순서 배치.(백트래킹)
	public static void permutation(int depth) {
		if(depth >= 11) {
			answer = Math.max(answer, gameStart());
			return;
		}
		
		for(int i=1; i<=4; i++) {
			order[depth] = i;
			permutation(depth+1);
		}
	}
	
	public static int gameStart() {
		Arrays.fill(horse, start); // 말들을 시작 지점으로 배치
		
		int score = 0;
		for(int i=1; i<=10; i++) {
			Node cur = horse[order[i]]; // 순열로 할당된 순서대로 말들을 움직인다.
			cur.isEmpty = true; // 현재 있는 칸을 비워준다
			
			for(int j=1; j<=dice[i]; j++) { // 주사위에 나온 수치만큼 이동한다.
				if(j == 1 && cur.fastPath != null) { // 처음 이동을 시작하는 위치가 파란색  칸이라면.
					cur = cur.fastPath; // 지름길로 이동(파란색 방향)
				} else {
					cur = cur.next; // 빨간색 방향으로 이동
				}
		}
			
			horse[order[i]] = cur; // 이동 후, 말 위치 설정
			
			if(!cur.isEmpty && !cur.isFinish) { // 이동을 마친 칸에 다른 말이 있다면, 해당 말은 고를 수  없다
				score = 0; // 주사위에 할당받은 말들의 순서가 무효처리.
				break;
			}else {
				cur.isEmpty = false; // 말이 존재하는 것으로 표시
				score += cur.score; // 해당 칸의 점수 추가
			}
		}
		
		// 다음 게임을 위해 말들의 위치를 지워준다.
		for(int i=1 ;i<=4; i++) 
			horse[i].isEmpty = true;
			
			return score; // 획득한 점수 반환
		}
		
		public static void init() {
			start = new Node(0); // 시작 지점.(시작 지점의 스코어는 0)
			
			Node temp = start;
			for(int i=2; i<=40; i+=2) {
				temp = temp.addNext(i); // 윷놀이판 바깥쪽 경로 설정
			}
			
			Node end = temp.addNext(0); // 도착지점.(도착지점의 스코어는 0)
			end.isFinish = true;
			end.next = end; // 자기자신을 가르키도록 설정(도착 지점을 넘어서는 이동에 대해 NPE 방지)
			
			Node crossroads = new Node(25); // 가운데 교차점(score = 25);
			
			// 교차점(25) -> 30 -> 35 -> 40
			temp = crossroads.addNext(30);
			temp = temp.addNext(35);
			temp.next = Node.getNode(start, 40);
			
			// 10 -> 13 -> 16 -> 19 -> 25(교차점)
			temp = Node.getNode(start, 10);
			temp = temp.fastPath = new Node(13);
			temp = temp.addNext(16);
			temp = temp.addNext(19);
			temp.next = crossroads;
			
			// 20 -> 22 -> 24 -> 25 (교차점)
			temp = Node.getNode(start,  20);
			temp = temp.fastPath = new Node(22);
			temp = temp.addNext(24);
			temp.next = crossroads;
			
			// 30 -> 28 -> 27 -> 26 -> 25(교차점)
			temp = Node.getNode(start,  30);
			temp = temp.fastPath = new Node(28);
			temp = temp.addNext(27);
			temp = temp.addNext(26);
			temp.next = crossroads;
		}
	}


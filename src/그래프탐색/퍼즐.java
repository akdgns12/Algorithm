package �׷���Ž��;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. �������

- 2���� �迭�� �ϳ��� ������ ǥ���Ѵ�.
- MAP�� �̿��Ͽ� ������ �̵�Ƚ���� �����Ѵ�.
- String.valueOf(int N) : int N�� String���� ��ȯ���ش�.
- StringBuilder.setCharAt -> Ư�� ��ġ�� char�� ������ �� �ִ�.
- String.indexOf(String s) -> s�� ��ġ�� �ε����� ��ȯ�Ѵ�.
- map.containsKey(String s) -> map�� s��� key�� �����ִٸ� true.
- int row = idx / 3; // idx �� 2�����迭���� �� ��° ������ ���
- int col = idx % 3; // idx �� 2�����迭���� �� ��° ������ ���

2. ����

- start ������ 2�����迭�� �ϳ��� ������ �ٲپ� ��´�.
- map�� �ʱ� ������ Ƚ���� ��´�.
- bfs�� �����Ѵ�
- 4�������� Ž���ϸ鼭 �ڽŰ� �ٲ� ��ġ�� �����ϰ� map�� �ߺ����� ������ ��´�.
- �ݺ�

��ó: https://toastfactory.tistory.com/228 [�̻����� �佺Ʈ ����]
 */
public class ���� {
	static String correct = "123456780";
	static Map<String, Integer> map = new HashMap<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		String init ="";
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int num = Integer.parseInt(st.nextToken());
				init += num;
			}
		}
	
		map.put(init, 0);
		System.out.println(bfs(init));
	}
	
	static int bfs(String init) {
		Queue<String> q = new LinkedList<>();
		q.add(init);
		while(!q.isEmpty()) {
			String pos = q.poll();
			int move =map.get(pos); // ������ Ƚ��
			int zerIdx = pos.indexOf('0'); // 0�� ��ġ
			int px = zerIdx%3; // ���� ��ġ
			int py = zerIdx/3; // ���� ��ġ
			
			if(pos.equals(correct)) { // ���� ����� ���ٸ� Ƚ�� return
				return move;
			}
			
			for(int i=0; i<4; i++) { // �̵��� �� �ִ� �� �˻��ϱ�
				int nx = px +dx[i];
				int ny = py + dy[i];
				
				if(nx<0 || ny<0 || nx>2 || ny>2) continue;
				
				int nPos = ny*3 + nx; // 2���� �ε����� 1�������� ��ȯ
				char ch = pos.charAt(nPos); // �ش� string�� npos��° ����
				String next = pos.replace(ch, 'c');
				next = next.replace('0', ch);
				next = next.replace('c', '0');
				
				if(!map.containsKey(next)) {
					q.add(next);
					map.put(next, move+1);
				}
			}
		}
		return -1;
	}
}

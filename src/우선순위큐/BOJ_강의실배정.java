package �켱����ť;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_���ǽǹ��� {
	// BOJ ���ǽ� ���� ��� 5 / �켱���� ť 
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/*
		 * 1. input data�� 2�����迭�� �޴´�
		 * 2. �Է� �����͸� ������������ ����(���۽ð��� ���ٸ�, ������ �ð��� ������������ ����)
		 * 3. �켱����ť ������ְ�, ���ĵ� ù���� ������ ������ �ð� �־���
		 * 4. �迭�� �ι�° ������ ��ȸ�ϸ鼭 start�� PriorityQueue�� peek()���� �۰ų� ���ٸ�, pq���� �ϳ� ����
		 *  4-1 . ��ȸ�ϸ鼭, ���� end���� pq�� �־��ش�.
		 * 5. pq�� �����ִ� �������� ������ �ʿ��� ���ǽ��� �����̴�.
		 */
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		// 1. Input �����͸� 2���� �迭�� �޴´�. 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 2. �Է� �����͸� ������������ �������ش�. (���۽ð��� ���ٸ�, ������ �ð��� ������������ ����)
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		// 3.PriorityQueue(�켱���� ť)�� ������ְ�, (���ĵ�)�迭�� ù ��° end���� ť�� �ִ´�.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0][1]);
		
		// 4. �迭�� �� ��° ������ ��ȸ�ϸ鼭,
		for(int i=1; i<N; i++) {
			// start�� PriorityQueue�� peek()���� ũ�ų� ���ٸ�, pq���� �ϳ� ����.
			if(pq.peek() <= arr[i][0]) pq.poll();
			
			// 4-1. ��ȸ�ϸ鼭, ���� end���� ���� pq�� �־��ش�.
			pq.add(arr[i][1]);
		}
		
		// 5. pq�� �����ִ� �������� ������ �ʿ��� ���ǽ��� �����̴�
		System.out.println(pq.size());
	}
} 

package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(q.size() != 1) { // 큐 사이즈가 1일때까지 반복
			// K-1번째 까지는 처음에 있던 값을 맨뒤로 보낸다
			for(int i=0; i<K-1; i++) {
				q.offer(q.poll());
			}
			// K번째 값은 poll한 후 출력한다
			sb.append(q.poll() + ", ");
		}
		
		// 큐 사이즈가 1일때는 단순히 poll하면 된다.
		sb.append(q.poll() + ">");
		
		System.out.println(sb.toString());
	}
}

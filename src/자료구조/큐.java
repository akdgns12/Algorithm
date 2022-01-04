package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		int back = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				back = Integer.parseInt(st.nextToken());
				q.add(back);
				break;
			case "pop":
				if(!q.isEmpty())
					System.out.println(q.poll());
				else
					System.out.println(-1);
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if(!q.isEmpty())
					System.out.println(0);
				else
					System.out.println(1);
				break;
			case "front":
				if(!q.isEmpty())
					System.out.println(q.peek());
				else
					System.out.println(-1);
				break;
			case "back": // 큐에 가장 뒤에 있는 정수 출력
				if(!q.isEmpty())
					System.out.println(back);
				else
					System.out.println(-1);
			}
		}
	}

}

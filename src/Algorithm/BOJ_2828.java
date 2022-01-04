package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ2828 사과담기 게임
// 
public class BOJ_2828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(st.nextToken());
		
		int start = 1;
		int end = m;
		int move =0;
		
		for(int i=0; i<j; i++) {
			// ap = 사과의 위치
			int ap = Integer.parseInt(br.readLine());
			if(ap >= start && ap<=end) continue;
			
			if(ap<start) {
				move += start - ap;
				end -= start - ap;
				start = ap;
			}
			else if(ap>end) {
				move += ap - end;
				start += ap-end;
				end = ap;
			}
		}
		System.out.println(move);
	}
}

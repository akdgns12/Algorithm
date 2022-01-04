package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 종이자르기 
// 가로, 세로 종이 길이 그리고 잘라야할 점선들이 주어질 때, 가장 큰 조각의 넓이 구하기
public class BOJ_2628 {
	static ArrayList<Integer> a,b;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = new ArrayList<Integer>(); 
		b = new ArrayList<Integer>(); 
		
		int width = Integer.parseInt(br.readLine());
		int height = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			int where = Integer.parseInt(st.nextToken()); // 세로인지 가로이지 판단할 여부 1이면 세로
			int k = Integer.parseInt(st.nextToken()); // 점선번호
			if(where==1) {
				a.add(k);
			}else {
				b.add(k);
			}
		}
		// 정렬
		Collections.sort(a);
		Collections.sort(b);
		// 가로
		int w = 0;
		int start = 0;
		//size() arraylist에 들어있는 원소 수
		for(int i = 0; i<a.size(); i++) {
			if(a.get(i)-start>w) {
				w=a.get(i)-start;
			}
			start = a.get(i);
		}
		if(width-start>w) {
			w=width-start;
		}
		//세로
		int h=0;
		start =0;
		for(int i=0; i<b.size();i++) {
			if(b.get(i)-start>h){
				h=b.get(i)-start;
			}
			start=b.get(i);
		}
		if(height-start>h) {
			h=height-start;
		}
		System.out.println(h*w);
	}
}

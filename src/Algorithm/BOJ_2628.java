package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// �����ڸ��� 
// ����, ���� ���� ���� �׸��� �߶���� �������� �־��� ��, ���� ū ������ ���� ���ϱ�
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
			int where = Integer.parseInt(st.nextToken()); // �������� �������� �Ǵ��� ���� 1�̸� ����
			int k = Integer.parseInt(st.nextToken()); // ������ȣ
			if(where==1) {
				a.add(k);
			}else {
				b.add(k);
			}
		}
		// ����
		Collections.sort(a);
		Collections.sort(b);
		// ����
		int w = 0;
		int start = 0;
		//size() arraylist�� ����ִ� ���� ��
		for(int i = 0; i<a.size(); i++) {
			if(a.get(i)-start>w) {
				w=a.get(i)-start;
			}
			start = a.get(i);
		}
		if(width-start>w) {
			w=width-start;
		}
		//����
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

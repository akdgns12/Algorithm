package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


// �ε�ȣ
public class Inequality {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N; // �ε�ȣ ������ ����
	private static char[] arr = new char[10]; // �ε�ȣ�� �ִ� 9��
	private static boolean[] visited = new boolean[10]; //0~9���� check
	private static List<String> ans = new ArrayList<>(); // arraylist �������� �迭
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()); //���ڿ� �и�
		
		for(int i = 0; i<N; i++) {
			arr[i]=st.nextToken().charAt(0); //st ���ڿ��� ���� ���ڿ����� ù��° ���ڸ� arr[i]�� ��´�.
		}
		
		dfs("",0);
		Collections.sort(ans); // ����
		
		System.out.println(ans.get(ans.size()-1)); //size() �÷�
		System.out.println(ans.get(0));
		br.close();
	}
	
	private static void dfs(String num, int idx) {
		if(idx==N+1) {
			ans.add(num);
			return;
		}
		
		for(int i = 0;i<=9;i++) {
			if(visited[i])continue;
			if(idx == 0 || ck(Character.getNumericValue(num.charAt(idx-1)), i, arr[idx-1])){
				visited[i]=true;
				dfs(num+i, idx+1);
				visited[i]=false;
			}
		}
	}
	private static boolean ck(int a, int b, char c) {
		if( c== '<') {
			if(a>b)return false;
		}	else if(c=='>') {
			if(a<b)return false;
		}
		return true;
	}
}

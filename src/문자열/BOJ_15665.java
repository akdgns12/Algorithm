package ���ڿ�;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class BOJ_15665 {
	// N��M(11) ��Ʈ��ŷ / �ǹ� 2
	static int n,m;
	static int[] num,print;
	static LinkedHashSet<String> set=new LinkedHashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		num=new int[n];
		print=new int[m];
		
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		
		Arrays.sort(num); // ���ĵ� �迭 ���
		dfs(0);
		
		// LinkedHashSet�� ����� ���� ���
		Iterator iter=set.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	static void dfs(int depth) {
		// ���õ� m���� ���ڷ� ������� ������ LinkedHashSet�� ����
		if(depth==m) {
			StringBuilder sb=new StringBuilder();
			for(int i:print)
				sb.append(i).append(" ");
			set.add(sb.toString());
			return;
		}
		
		// ���ڸ� �ߺ��Ͽ� �����ص� �Ǳ� ������ visited �迭�̳� for���� ������ �������� �ʾƵ� ��
		for(int i=0;i<n;i++) {
			print[depth]=num[i];
			dfs(depth+1);
		}
	}
}
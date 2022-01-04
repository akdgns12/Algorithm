import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
// 1. ���Ͽ� ���ε��?
/*
 * ��ǥ�� �׷��� �˰������� '������ ã��'��� �ǹ̸� ������ �ִ�.
 * ��ȣ ��Ÿ�� �����̶�� �Ѵ�.
 * ���� ��尡 ������ ��, �� ���� ��带 �����ؼ�, ���� �� ��尡 ���� ���� �׷����� ���ϴ��� �Ǻ��ϴ� �˰���
 * 2���� �������� �̷���� �ִ�.
 * - Find : x�� � ���տ� ���ԵǾ� �ִ��� ã�� ����
 * - Union : x�� y�� ���ԵǾ� �ִ� ������ ��ġ�� ����
 */
// 1. parent[] �迭�� �ʱ�ȭ ���ݴϴ�.
// 2. find(), union(), isSameParent() �޼ҵ带 ����� �ݴϴ�.
// 3. ���⼭ isSameParent()�� ������ �̸����� ���� �Լ���.. find(), union() �޼ҵ��� �۵� ������
//    �ľ��ص� ����� Ǯ �� �ִ�. 
public class Main {
	public static int[] parent;
	
	public static int find(int x) {
		if(x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
        if(x < y) parent[y] = x;
        else parent[x] = y;
	}
	
	public static void isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n+1];
		// �θ����̺� �󿡼� �θ� �ڱ��ڽ����� �ʱ�ȭ
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(a == 0) {
				union(x,y);
			}else {
				isSameParent(x,y);
			}
		}
	}
}

package Algorithm;
//���¾� ���ϸ� ������ �̴ټ�

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// ���ڿ�Ž������ Hashmap�� ���� ȿ���� ����
// HashMap<String, Integer>�� ���ڿ��� �´� ��ȣ�� ���, String[] �� ��ȣ(�ε���)�� �´� ���ڿ��� ���
// ��Ȳ�� �°�(�Է� ���� �������� �������� �����ؼ�)�����Ǵ� ���� ����ϸ� ��!
public class BOJ1620 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ���ϸ��� ���� n
		int n = Integer.parseInt(st.nextToken());
		// ����� �ϴ� ������ ���� m
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
		String[] nameArr = new String[n+1];
		StringBuilder sb = new StringBuilder();
		
		//�Է�
		for(int i=1; i<n+1; i++) {
			String name = br.readLine(); //���ϸ� �̸���
			nameMap.put(name,i); // name�� �´� ��ȣ ���
			nameArr[i]=name;	// ��ȣ�� �´� name ���
		}
		
		// while(variable-->0) ����
		// ������ �������� m���� 1�� �ٰԵǰ� ���� ���� 0���� Ŭ ��쿡�� ����.
		while(m-->0) {
			String findStr = br.readLine();
			if(isStringNumber(findStr)) { //����(�ε���)�� �Է¹��� ���
				int index = Integer.parseInt(findStr);
				sb.append(nameArr[index]);
			}
			else { // ���ڸ� �Է¹��� ���
				sb.append(nameMap.get(findStr));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// �� ���ڿ��� �������� �ƴ��� �Ǵ��ϴ� �Լ�
	public static boolean isStringNumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
}

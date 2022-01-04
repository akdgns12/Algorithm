package �ؽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ����Ʈ���� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // ���� �ȸ� å ����
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		
		//HashMap�� ���� value�� �ִ밪�� å�� ã��
		// ���� value�� ���ٸ� å�� ���������� �ռ��� ���� ���
		int max = 0;
		String maxBook = "";
		for(String key : map.keySet()) {
			int value = map.get(key);
			
			if(value == max && maxBook.compareTo(key) > 0) {
				maxBook = key;
				max = value;
			}else if(value > max) {
				max = value;
				maxBook = key;
			}
		}
		System.out.println(maxBook);
	}
}

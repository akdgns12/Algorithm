package �ؽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ���δٸ��κй��ڿ��ǰ��� {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// S�� ���� �ٸ� �κ� ���ڿ��� ���� ���϶�
		String input = br.readLine(); 	// ���ڿ� S
		HashSet<String> set = new HashSet<>();
		
		String name = "";
		
		for(int i=0; i<input.length(); i++) {
			name = "";
			// i���� ������ �ݺ��� �Ͽ� set�� �ִµ� �ߺ��� ������ �ȳִ´�
			for(int j=i; j<input.length(); j++) {
				name += input.substring(j,j+1);
				set.add(name);
			}
		}
		
		System.out.println(set.size());
		
	}
}

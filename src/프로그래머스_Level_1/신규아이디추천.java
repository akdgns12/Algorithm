package ���α׷��ӽ�_Level_1;
/*
 * 1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
     ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
 */
public class �űԾ��̵���õ {
	class Solution {
	    public String solution(String new_id) {
	    	//1. ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ
			
			new_id = new_id.toLowerCase();
			//2. ���ĺ� �ҹ���, ����, ����, ����, ��ħǥ�� ������ ��� ���� ����
			String id = "";
			for(int i=0; i<new_id.length(); i++) {
				char ch = new_id.charAt(i); 
				
				if(ch >= 'a' && ch <= 'z') {
					id += String.valueOf(ch);
				}else if(ch >= '0' && ch <= '9'){
					id += String.valueOf(ch);
				}else if(ch == '-' || ch == '_' || ch == '.') {
					id += String.valueOf(ch);
				}
			}
			//3.��ħǥ�� 2���̻� ���ӵ� �κ���  �ϳ��� ��ħǥ��
			for(int i=0; i<id.length(); i++) {
				if(id.charAt(i) == '.') {
					int j = i+1;
					String dot = ".";
					
					while(j != id.length() && id.charAt(j) == '.') {
						dot += ".";
						j++;
					}
					
					if(dot.length() > 1)
						id = id.replace(dot, ".");
					}
			}
			
			//4. ��ħǥ�� ó���̳� ���� ��ġ�Ѵٸ� ����
			if(id.startsWith("."))
				id = id.substring(1, id.length());
			if(id.endsWith("."))
				id = id.substring(0, id.length()-1);
			
			//5.�� ���ڿ��̶�� "a" ����
			if(id.length() == 0) {
				id += "a";
			}
			
			//6.���̰� 16�� �̻��̸� ù ���ڸ� ������ ������ ���� ��� ����
			// ���� ���� �� ��ħǥ�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ ����
			if(id.length() >= 16) {
				id = id.substring(0,15);
			}
			
			if(id.endsWith("."))
				id = id.substring(0,id.length()-1);
			
			//7. ���̰� 2�����϶��, ������ ���ڸ� ���̰� 3�� �� ������ 
			// �ݺ��ؼ� ����
			String last = id.charAt(id.length()-1) + "";
			if(id.length() <= 2) {
				while(id.length() < 3)
					id += last;
			}
			return id;
	    }
	}
}

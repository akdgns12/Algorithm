package ���α׷��ӽ�level2;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * msg �빮�ڷθ� �̷��� ���ڿ��� �־�����.
 */
/*
 * LZW ������ ���� ������ ��ģ��.

1.���̰� 1�� ��� �ܾ �����ϵ��� ������ �ʱ�ȭ�Ѵ�.
2.�������� ���� �Է°� ��ġ�ϴ� ���� �� ���ڿ� w�� ã�´�.
3.w�� �ش��ϴ� ������ ���� ��ȣ�� ����ϰ�, �Է¿��� w�� �����Ѵ�.
4.�Է¿��� ó������ ���� ���� ���ڰ� �����ִٸ�(c), w+c�� �ش��ϴ� �ܾ ������ ����Ѵ�.
5.�ܰ� 2�� ���ư���.
 */
public class ���� {
	public int[] solution(String msg) {
		//���̰� 1�� ��� �ܾ �����ϵ��� ������ �ʱ�ȭ�Ѵ�.
		//����� ���� ��ȣ�� ���� ArrayList
		ArrayList<Integer> list = new ArrayList<>(); 
		//������ ���� ���� HashMap
		HashMap<String, Integer> dic = new HashMap<>();
		
		for(int i=1; i<27; i++) { // (A~Z) LZW 1������
			char alpha = (char)(64+i);
			dic.put(String.valueOf(alpha), i);
		}
		
		// 2,3,4 ����
		for(int i=0; i<msg.length(); i++) {//�ܾ��� ó������ ������ �ϳ��ϳ� Ȯ���Ѵ�
			String Key = msg.charAt(i) + ""; //i��°�� �ش��ϴ� �ܾ� �� ���� �Է�(w)
			int index = i + 1; //���� ����(c)�� ��� ���� index
			
			while(index<=msg.length()) { //�ܾ��� ���������� Ȯ���ϸ鼭 ������ �ֳ����� Ȯ���ؾ���
				if(index == msg.length()) {//�ܾ��� ���������� �� ���
					list.add(dic.get(msg.substring(i))); //i���� ������ �ܾ���� ���ڿ� �����Ǵ� ���ι�ȣ�� ���
					i = index; //i���� index������ ������ �ݺ����� �������� �Ѵ�.
					break;
				}
				
				String nextKey = msg.substring(i, index+1); //�����Է�(w) + ��������(c)
				if(dic.containsKey(nextKey)) { // w+c�� �ִٸ� �ٽ� index�� �ϳ� ���� �������ڰ� ������ �ִ��� Ȯ��
					index++;
				}else { //���� ���ڰ� ������ ����
					//�ݺ����� ���� ���� ���ڰ� ���� ������ key�� ���̴� ���ϱ� ������ ������ ���� index�������� key�� �ٽ� �����Ѵ�.
					Key = msg.substring(i, index);
					list.add(dic.get(Key)); //�� ���� key���� �����Ǵ� ���ι�ȣ ���
					dic.put(nextKey, dic.size()+1); //w+c ������ �߰�
					i = index-1; //���� ������ index���� �ٽ� LZW
					break;
				}
			}
		}
		
		//list���� answer�� ������ ������
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}

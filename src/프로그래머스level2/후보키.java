package ���α׷��ӽ�level2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * 2019īī�� ��ä
 */
/*
 * 1.�ϴ� �ĺ�Ű�� �� �� �ִ� ��� ���յ��� �����ش� -> ������ �ĺ�Ű���� ������ �����صд�
 * 1-1 �� �� ���ϼ� �˻縦 ����� �ĺ�Ű�鸸 �������ش�
 * 2.���ο� �ĺ�Ű ������ ���Ҷ����� �����ص� �ĺ�Ű������ ���ο� �ĺ�Ű���տ� ����
 * �ȴٸ� ������ �ĺ�Ű�� �ּҼ��� ���������� �߰������� �ʴ´�.
 * 
 */
//public class �ĺ�Ű {
//	//hashSet �ߺ� ��� x
//	static ArrayList<HashSet<Integer>> candidateKey;
//	static String Table[][];
//	static int length;
//	static int answer;
//	public int solution(String[][]  relation) {
//		answer = 0;
//		candidateKey = new ArrayList<HashSet<Integer>>();
//		Table = relation;
//		length = relation[0].length;
//		
//		for(int i=1; i<=length; i++) {
//			makeSet(-1, i, 0, new HashSet<Integer>());
//		}
//		
//		
//		return answer;
//	}
//	
//	public static void makeSet(int index, int target, int count, HashSet<Integer> set) {
//		if(count== target) {
//			if(!isUnique(set)) {
//				return;
//			}
//			//containsAll - list1.containsAll(list2) : ������ ������� list2�� ���ҵ��� ��� list1�� 
//			//�����ϴ��� true/false
//			for(HashSet<Integer> key : candidateKey) {
//				if(set.containsAll(key)) {
//					return;
//				}
//			}
//			candidateKey.add(set);
//			answer++;
//			return;
//		}
//		
//		for(int i=index+1; i<length; i++) {
//			HashSet<Integer> newSet = new HashSet<Integer>(set);
//			newSet.add(i);
//			makeSet(i, target, count+1, newSet);
//		}
//	}
//	
//	public static boolean isUnique(HashSet<Integer> set) {
//		ArrayList<String> list = new ArrayList<String>();
//		for(int i=0; i<Table.length; i++) {
//			String temp = "";
//			for(int index : set) {
//				temp += Table[i][index];
//			}
//			if(!list.contains(temp)) {
//				list.add(temp);
//			}else {
//				return false;
//			}
//		}
//	
//		return true;
//	}
//}
class �ĺ�Ű {
	
	Comparator<Integer> comp = new Comparator<Integer>() {
		int countBits(int n) {
			int ret = 0;
			while(n != 0) {
				if((n & 1) != 0 ) ret++;
				n = n >> 1;
			}
			
			return ret;
		}
		public int compare(Integer a, Integer b) {
			int x = countBits(a), y = countBits(b);
			if(x>y)
				return 1;
			else if( x < y)
				return -1;
			else
				return 0;
		}
	}
	boolean check(String[][] relation, int rowsize, int colsize, int subset) {
		for(int a = 0; a<rowsize -1; a++) {
			for(int b=a+1; b<rowsize; b++) {
				boolean isSame = true;
				for(int k=0; k<colsize; k++) {
					if((subset & 1 << k) == 0) continue;
					if(relation[a][k].equals(relation[b][k]) == false) {
						isSame = false;
						break;
					}
				}
				
				if(isSame) return false;
			}
		}
		
		return true;
	}
	
	public int soultion(String[][] relation) {
		int answer = 0;
		int rowsize = relation.length;
		int colsize = relation[0].length;
		//���ϼ� �����ϴ¾ֵ� candidates�� ����
		List<Integer> candidates = new LinkedList<Integer>();
		
		//�������� �ʿ���⶧���� i�� 1����
		for(int i=1; i< 1 << colsize; i++) {
			if(check(relation, rowsize, colsize, i) == true)
				candidates.add(i);
		}
		
		//���ϼ��� �����ϴ� candidates���� �Ӽ��� ������������ ����
		Collections.sort(candidates, comp);
		
		
		
		while(candidates.size() != 0) {
			int n = candidates.remove(0);
			answer++;
			
			for(Iterator<Integer> it = candidates.iterator(); it.hashNext();) {
				int c = it.next();
				if((n & c) == n)
					it.remove();
			}
		}
		
		
		
		
		
		
		return answer;
	}
}
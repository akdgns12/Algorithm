package 프로그래머스level2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * 2019카카오 공채
 */
/*
 * 1.일단 후보키가 될 수 있는 모든 조합들을 구해준다 -> 구해준 후보키들의 조합을 저장해둔다
 * 1-1 이 때 유일성 검사를 통과한 후보키들만 저장해준다
 * 2.새로운 후보키 조합을 구할때마다 저장해둔 후보키조합이 새로운 후보키조합에 포함
 * 된다면 샐구한 후보키는 최소성을 위반함으로 추가해주지 않는다.
 * 
 */
//public class 후보키 {
//	//hashSet 중복 허용 x
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
//			//containsAll - list1.containsAll(list2) : 순서에 상관없이 list2의 원소들이 모두 list1에 
//			//존재하는지 true/false
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
class 후보키 {
	
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
		//유일성 만족하는애들 candidates에 저장
		List<Integer> candidates = new LinkedList<Integer>();
		
		//공집합은 필요없기때문에 i는 1부터
		for(int i=1; i< 1 << colsize; i++) {
			if(check(relation, rowsize, colsize, i) == true)
				candidates.add(i);
		}
		
		//유일성을 만족하는 candidates들을 속성이 적은개수부터 정렬
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
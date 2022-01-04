package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

// 2910 빈도정렬
// 수 정렬 문제
// 1. 해쉬맵에 키와 빈도수를 저장한다.
// 2. 해쉬맵에 저장된 모든 키들을 리스트에 저장한다.
// 3. 리스트들안에 저장된 키들을 빈도에 따라서 정렬한다.
// 4. 출력
// 복습
public class BOJ_2910 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		
		str = br.readLine().split(" ");
		HashMap<Integer, Integer> list = new LinkedHashMap<Integer, Integer>();
		
		// 해쉬맵을 이용
		for(int i=0; i<n; i++) {
			//키가 존재하면 value를 +1
			if(list.containsKey(Integer.parseInt(str[i]))) {
				list.replace(Integer.parseInt(str[i]), list.get(Integer.parseInt(str[i]))+1);
			}
			// 키가 없을시  value 값을 1로 생성한다.
			else {
				list.put(Integer.parseInt(str[i]),1);
			}
		}
		//key들을 모두 배열에 저장한다.
		ArrayList<Integer> v = new ArrayList<Integer>(list.keySet());
		
		//배열에 저장된 키들의 값을 value값으로 내림차순으로 정렬한다.
		Collections.sort(v, new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				// list.get(b) 와 list.get(a)의 위치가 바뀌면 오름차순이 된다.
				return Integer.compare(list.get(b), list.get(a));
			}
		});
		//Iterator를 통해서 출력한다.
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {
			Integer element = it.next();
			for(int i=0; i<list.get(element); i++	) {
				System.out.println(element+ " ");
			}
		}
	}
}

package 해시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class 회사에있는사람 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt(); // 출입기록의 수
//		HashSet<String> set = new HashSet<>();
//		
//		for(int i=0; i<n; i++) {
//			String name = sc.next();
//			String command = sc.next();
//			
//			switch(command) {
//			case "enter":
//				set.add(name);
//				break;
//			case "leave":
//				if(set.contains(name))
//					set.remove(name);
//			}
//		}
//		
//		ArrayList<String> result = new ArrayList<>(set);
//		Collections.sort(result, Collections.reverseOrder());
//		
//		for(String name : result) {
//			System.out.println(name);
//		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 출입기록의 수
		HashSet<String> set = new HashSet<>();
		ArrayList<String> result = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			String name = sc.next();
			String command = sc.next();
			
			switch(command) {
			case "enter":
				set.add(name);
				break;
			case "leave":
				if(set.contains(name))
					set.remove(name);
			}
		}
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			result.add(it.next());
		}
		
		Collections.sort(result, Collections.reverseOrder());
		
		for(String name : result) {
			System.out.println(name);
		}
	}

}

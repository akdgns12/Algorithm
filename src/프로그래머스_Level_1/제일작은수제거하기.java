package 프로그래머스_Level_1;
/*
 * 정수를 저장한 배열, arr에서 가장 작은 수를 제거한 배열을 return하는 함수
 * solution을 완성하라
 * 단, return하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 return
 * 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 return하고,
 * [10]이면 [-1]를 return
 */
/*
 * -배열이 빌 경우는 length가 1인 배열 -> 그냥 -1 담아서 return
 * -arr와 answer는 길이가 1차이
 * -루프 돌 때 다른 루프변수를 이용해야함.
 * -arr[j]가 최솟값과 같은 경우는 answer에 넣어주지 말아야함.
 */
public class 제일작은수제거하기 {
	public int[] solution(int[] arr) {
		int[] answer = {};
		int min = arr[0];
		if(arr.length == 1) {
			return new int[] {-1};
		}
		// 최솟값 구하기
		for(int i=0; i<arr.length; i++) {
			min = Math.min(arr[i], min);
		}
		// answer는 arr보다 1작음
		answer = new int[arr.length-1];
		
		int j = 0;
		for(int i=0; i<answer.length; i++) {
			if(arr[j] == min) { //arr[j]가 최솟값과 같은경우는 answer에 넣어주지 말아야함.
				j++;
				i--;
				continue;
			}
			answer[i] = arr[j];
			j++;
		}
		return answer;
	}
}
/*
 * ArrayList 이용해 list에서 remove함수로 지워준 풀이
 int [] answer = {-1};
 ArrayList<Integer> list = new ArrayList<>();
 
 for(int a : arr)
	 list.add(a);
 
 int temp = arr[0];
 for(int a : list) { //최소값 구하기
	 if(a<temp) {
		 temp = a;
	 }
 }
 lsit.remove(list.indexOf(temp)); //최소값 제거
 
 if(list.size() > 1) {
	 asnwer = new int[list.size()];
	 
	 for(int i=0; i<list.size(); i++) {
		 answer[i] = list.get(i);
	 }
 }
return answer;
*/
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
       String[] answer = new String[n];
		for(int i=0; i<n; i++) {
			answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
		}
		
		for(int i=0; i<n; i++) {
            //String의 자릿수를 맞출 때 사용 String.format("%자릿수s", str) = n개의 자릿수만큼 문자열 담기
			answer[i] = String.format("%"+n+"s", answer[i]); // 앞공백 채우기라는데 잘 모르겠음
			answer[i] = answer[i].replaceAll("1", "#");
			answer[i] = answer[i].replaceAll("0", " ");
		}
        return answer;
    }
}
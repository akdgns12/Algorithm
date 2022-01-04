package 매일코딩;

import java.util.Arrays;
/*
 * 이분탐색 알고리즘 코드
 * 
 * int BinarySearch(int arr[], int target) {
    int start = 0;
    int end = arr.length - 1;
    int mid;

    while(start <= end) {
        mid = (start + end) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            end = mid - 1;
        else
            start = mid + 1;
    }
    return -1;
}
 */
/*
 * 1. 무엇(start, end, mid)을 이분탐색할 것이고 어떤걸(위의 BinarySearch 코드의 target)
 * 비교하여 다음 탐색 구간을 정할지 먼저 찾음
 * -> 이분 탐색할 것 : 심사를 받는데 걸리는 시간(mid)
 * -> 비교대상(target) : n(입국 심사를 기다리는 사람)
 * 
 * 2. 심사를 받는데 최소로 걸리는 시간(answer)를 구하므로 심사를 받는데 걸리는 시간(mid)을
 * 이분탐색함.
 * 
 * 3. input에서 비교대상으로 n(입굼심사를 기다리는 사람)명이 주어지므로 n명을 target으로 정해 다음 탐색 구간을 정함
 * 
 * 4. n과 비교하기 위해 주어진 mid시간 동안 검사할 수 있는 사람 수(sum)을 구하는 알고리즘이 포함되어야 함.
 * 
 * 5. answer를 구하기 위해 최소시간을 찾아내야함
 * 
 */
public class 이분탐색_입국심사 {

	public long solution(int n, int[] times) {
		// 모든 사람이 심사를 받는데 걸리는 시간의 최솟값
		long answer = Long.MAX_VALUE;
		
		Arrays.sort(times);
		
		long start, mid, end;
		start = 0;
		end = Long.MAX_VALUE;
		long sum;
		// 모든 사람이 심사받는데 걸리는 시간 이분탐색
		// mid : 심사를 받는데 주어진 시간
		// sum : 주어진 시간(mid)동안 심사를 받을 수 있는 사람의 수
		while(start <= end) {
			mid = (start + end) / 2;
			
			sum = 0;
			// 주어진 시간동안 몇명 검사할 수 있는지 누적합
			for(int i=0; i<times.length; i++) {
				sum += mid / times[i];
				
				if(sum >= n)
					break;
			}
			
			// 비교대상(사람 수)
			// 검사  다 못할 떄(시간부족)
			if(n > sum) {
				start = mid + 1;
			}
			// 검사 다 했을 때(시간이 남음)
			// 최소 시간 찾아야함
			else {
				end = mid - 1;
				answer = Math.min(answer, mid);
			}
		}

		
       
        
        return answer;
    }
}
